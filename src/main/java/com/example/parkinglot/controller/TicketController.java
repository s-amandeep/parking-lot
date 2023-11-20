package com.example.parkinglot.controller;

import com.example.parkinglot.dtos.CreateTicketRequest;
import com.example.parkinglot.models.EntryGate;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private TicketService ticketService;

    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest request){
        return ticketService.createTicket(request);
    }

//    @GetMapping("/{id}")
//    public Ticket getTicket(@PathVariable("id") Long id){
//        return ticketService.getTicket(id);
//    }
}
