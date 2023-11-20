package com.example.parkinglot.service;

import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.repositories.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot create(ParkingLot parkingLot) {
        ParkingLot persistedLot = parkingLotRepository.save(parkingLot);
        parkingSpotService.createParkingSpots(persistedLot);
        return persistedLot;
    }

    public ParkingLot getById(Long id){
        return parkingLotRepository.findById(id);
    }


}
