package com.koldun.librarymodsen.interfaces;

import com.koldun.librarymodsen.controller.TicketRequest;
import com.koldun.librarymodsen.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket getTicketById(Long id);
    void setTicket(TicketRequest ticketRequest);
    List<Ticket> getAllTickets();
    void setTicketDate(TicketRequest ticketRequest);
}
