package com.example.parkinglot.controller;

import com.example.parkinglot.dtos.CreateParkingLotRequest;
import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.service.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/parking-lot") // Mapping all the request for this URL to this controller
public class ParkingLotController {

    private ParkingLotService parkingLotService;
    // Create a parking lot
    // POST

    // 1. Request Validation
    // 2. Data transformation

    //POST /api/v1/parking-lot
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request){
        validate(request);

        ParkingLot parkingLot = transform(request);
        return  parkingLotService.create(parkingLot);
    }

    //GET /api/v1/parking-lot/{id}
    @GetMapping("/{id}") // Added method level mapping
    public ParkingLot getParkingLot(@PathVariable("id") Long id) { // Added path variable
        return ParkingLot.builder().id(id).build();
    }

    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() < 0){
            throw new RuntimeException("Invalid number of floors");
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request){
        return request.toParkingLot();
    }
}
