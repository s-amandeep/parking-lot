package com.example.parkinglot.repositories;

import com.example.parkinglot.dtos.CreateTicketRequest;
import com.example.parkinglot.models.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {

    private List<Ticket> tickets = new ArrayList<>();

    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    public Ticket getTicket(Long ticketId) {
        return tickets.stream().filter(ticket -> ticket.getId().equals(ticketId)).findFirst().get();

    }

}
