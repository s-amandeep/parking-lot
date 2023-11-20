package com.example.parkinglot.repositories;

import com.example.parkinglot.models.ParkingSpot;
import com.example.parkinglot.models.SpotStatus;
import com.example.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotRepository {

    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType type){
        for(ParkingSpot parkingSpot: parkingSpots){
            if (parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == type){
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot update(ParkingSpot filledSpot) {
        ParkingSpot currentSpot = parkingSpots.stream().filter(parkingSpot -> parkingSpot.getId().equals(filledSpot.getId()))
                .findFirst()
                .get();

        if (currentSpot == null){
            throw new RuntimeException("Invalid Parking Spot");
        }

        parkingSpots.remove(currentSpot);
        parkingSpots.add(filledSpot);

        return filledSpot;
    }

    public void saveAll(List<ParkingSpot> parkingSpots){
        parkingSpots.addAll(parkingSpots);
    }

    public List<ParkingSpot> findAllByParkingLotId(Long id){
        return parkingSpots;
    }

    public ParkingSpot findOneById(Long id){
        return parkingSpots.stream().filter(parkingSpot -> parkingSpot.getId().equals(id)).findFirst().get();
    }
}
