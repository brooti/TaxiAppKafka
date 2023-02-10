package com.epam.kafkacourse.TaxiAppKafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSignal {
    private Long id;
    private double longitude;
    private double latitude;
}
