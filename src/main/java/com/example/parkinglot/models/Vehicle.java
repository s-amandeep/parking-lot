package com.example.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Vehicle extends BaseModel{
    private VehicleType vehicleType;
    private String licenseNumber;
}
