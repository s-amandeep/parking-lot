package com.example.parkinglot.repositories;

import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    List<Vehicle> vehicles = new ArrayList<>();

    public Vehicle createVehicle(String licenseNumber, VehicleType vehicleType){
        Vehicle vehicle = Vehicle.builder()
                .licenseNumber(licenseNumber)
                .vehicleType(vehicleType)
                .build();

        vehicles.add(vehicle);
        return vehicle;
    }

    public Vehicle findById(Long vehicleId){
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(vehicleId)).findFirst().orElse(null);
    }

    public Vehicle findByLicenseNumber(String licenseNumber){
        return vehicles.stream().filter(vehicle -> vehicle.getLicenseNumber().equals(licenseNumber)).findFirst().orElse(null);
    }
}
