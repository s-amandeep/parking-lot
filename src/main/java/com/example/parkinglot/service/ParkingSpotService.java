package com.example.parkinglot.service;

import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.models.ParkingSpot;
import com.example.parkinglot.models.VehicleType;
import com.example.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpot allocateSpot(Long parkingLotId, VehicleType vehicleType){
        return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

    public ParkingSpot update(ParkingSpot parkingSpot){
        return parkingSpotRepository.update(parkingSpot);
    }

    public void createParkingSpots(ParkingLot parkingLot){
        List<ParkingSpot> parkingSpots = parkingLot.getFloors()
                .stream()
                .flatMap(parkingFloor -> parkingFloor.getSpots().stream())
                .collect(Collectors.toList());

        parkingSpotRepository.saveAll(parkingSpots);
    }

    public List<ParkingSpot> getParkingSpots(Long parkingLotId){
        return parkingSpotRepository.findAllByParkingLotId(parkingLotId);
    }

    public ParkingSpot getParkingSpot(Long parkingSpotId){
        return parkingSpotRepository.findOneById(parkingSpotId);
    }
}
