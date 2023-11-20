package com.example.parkinglot.dtos;

import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.models.VehicleType;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class CreateTicketRequest {
    private String licenseNumber;
    private VehicleType vehicleType;
    private Long parkingLotId;
    private Long entryGateId;
    private Long issuerId;

}
