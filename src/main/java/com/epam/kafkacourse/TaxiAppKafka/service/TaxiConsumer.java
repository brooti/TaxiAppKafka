package com.epam.kafkacourse.TaxiAppKafka.service;

import com.epam.kafkacourse.TaxiAppKafka.model.VehicleSignal;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TaxiConsumer {
    @KafkaListener(topics = "${kafka.consumer.topic}", concurrency = "3", groupId = "${kafka.consumer.group}", containerFactory = "vehicleSignalKafkaListenerFactory")
    public void consumeJson(VehicleSignal vehicleSignal){
        System.out.println(vehicleSignal.getLatitude() + " " + vehicleSignal.getLongitude() + " ");
    }
}
