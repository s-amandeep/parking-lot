package com.example.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
public class ParkingSpot extends BaseModel{
    private Long floorId;
    private SpotStatus spotStatus;
    private VehicleType vehicleType;

    public static ParkingSpot mediumAvailable(){
        return ParkingSpot.builder()
                .spotStatus(SpotStatus.AVAILABLE)
                .vehicleType(VehicleType.MEDIUM)
                .build();
    }
}