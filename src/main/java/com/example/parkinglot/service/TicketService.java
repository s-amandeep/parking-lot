package com.example.parkinglot.service;

import com.example.parkinglot.dtos.CreateTicketRequest;
import com.example.parkinglot.models.ParkingSpot;
import com.example.parkinglot.models.SpotStatus;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class TicketService {

    private TicketRepository ticketRepository;
    private VehicleService vehicleService;
    private ParkingSpotService parkingSpotService;
    public Ticket createTicket(CreateTicketRequest request) {

        ParkingSpot parkingSpot = parkingSpotService.allocateSpot(request.getParkingLotId(), request.getVehicleType());

        if (parkingSpot == null){
            throw new RuntimeException("Sorry, no spaces available for this Vehicle Type");
        }

        // Update the status in Database
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        parkingSpotService.update(parkingSpot);

        Ticket ticket = Ticket.builder()
                .entryGateId(request.getEntryGateId())
                .entryTime(new Date())
                .spotId(parkingSpot.getId())
                .vehicle(vehicleService.findOneorCreate(request.getLicenseNumber(), request.getVehicleType()))
                .build();

        return ticketRepository.save(ticket);
    }

//    public Ticket getTicket(Long ticketId){
//        return ticketRepository.getTicket(ticketId);
//    }
}
