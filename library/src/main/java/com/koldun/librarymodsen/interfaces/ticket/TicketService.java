package com.koldun.librarymodsen.interfaces.ticket;

import com.koldun.librarymodsen.controller.ticket.TicketRequest;
import com.koldun.librarymodsen.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket getTicketById(Long id);
    void setTicket(TicketRequest ticketRequest);
    List<Ticket> getAllTickets();
    Ticket setTicketDate(TicketRequest ticketRequest);
    List<Ticket> getFreeBooks();
}
