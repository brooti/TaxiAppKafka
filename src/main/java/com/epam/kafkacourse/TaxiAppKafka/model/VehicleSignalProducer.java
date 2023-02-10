package com.epam.kafkacourse.TaxiAppKafka.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class VehicleSignalProducer {
    @Value("${kafka.consumer.topic}")
    private String topic;

    private final KafkaTemplate<Long, VehicleSignal> vehicleSignalKafkaSender;

    public VehicleSignalProducer(
            @Qualifier("vehicleSignalKafkaSender")
            KafkaTemplate<Long, VehicleSignal> vehicleSignalKafkaSender) {

        this.vehicleSignalKafkaSender = vehicleSignalKafkaSender;
    }

    public void acceptVehicleSignal(VehicleSignal signal) throws ExecutionException, InterruptedException, TimeoutException {
        vehicleSignalKafkaSender.send(topic, signal.getId(), signal).get(2, TimeUnit.MINUTES);
    }
}
