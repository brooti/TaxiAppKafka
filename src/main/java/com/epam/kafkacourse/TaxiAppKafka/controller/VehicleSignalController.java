package com.epam.kafkacourse.TaxiAppKafka.controller;

import com.epam.kafkacourse.TaxiAppKafka.model.VehicleSignal;
import com.epam.kafkacourse.TaxiAppKafka.model.VehicleSignalProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/v1/taxi/location")
@RequiredArgsConstructor
public class VehicleSignalController {

    private final VehicleSignalProducer vehicleSignalProducer;

    @PostMapping("/send")
    public ResponseEntity<String> receiveSignal(@RequestBody VehicleSignal vehicleSignal) {
//        if (!signalValidator.validate(vehicleSignal)) {
//            return ResponseEntity.unprocessableEntity().body("Signal has incorrect data");
//        }
        try {
            vehicleSignalProducer.acceptVehicleSignal(vehicleSignal);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Unavailable signal storage");
        }
        return ResponseEntity.accepted().body("Coordinates were accepted");
    }
}