package com.example.parkinglot.dtos;

import com.example.parkinglot.idGenerators.ParkingFloorId;
import com.example.parkinglot.idGenerators.ParkingLotId;
import com.example.parkinglot.idGenerators.ParkingSpotId;
import com.example.parkinglot.models.*;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;
    private Integer numberOfSpotsPerFloor;

    public ParkingLot toParkingLot(){
        //Create dummy Parking Spots and update their ids
        List<ParkingSpot> parkingSpots = Collections.nCopies(numberOfSpotsPerFloor, ParkingSpot.mediumAvailable());
        parkingSpots.forEach(parkingSpot -> parkingSpot.setId(ParkingSpotId.nextId()));

        //Create dummy Parking Floors and update their ids
        List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors, ParkingFloor.builder()
                        .spots(parkingSpots)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build());

        parkingFloors.forEach(parkingFloor -> parkingFloor.setId(ParkingFloorId.nextId()));

        return ParkingLot.builder()
                .id(ParkingLotId.nextId())
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates(Collections.nCopies(numberOfEntryGates, EntryGate.builder().build()))
                .exitGates(Collections.nCopies(numberOfExitGates, ExitGate.builder().build()))
                .build();
    }
}
