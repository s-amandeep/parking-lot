package com.example.parkinglot.service;

import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.models.VehicleType;
import com.example.parkinglot.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public Vehicle findOneorCreate(String licenseNumber, VehicleType vehicleType){
        Vehicle vehicle = vehicleRepository.findByLicenseNumber(licenseNumber);

        if (vehicle == null){
            return vehicleRepository.createVehicle(licenseNumber, vehicleType);
        }
        return vehicle;
    }
}
