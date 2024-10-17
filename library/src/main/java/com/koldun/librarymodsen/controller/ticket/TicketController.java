package com.koldun.librarymodsen.controller.ticket;

import com.koldun.librarymodsen.interfaces.ticket.TicketService;
import com.koldun.librarymodsen.model.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    @GetMapping("/id")
    public Ticket getTicketById(@RequestParam Long id) {
        return ticketService.getTicketById(id);
    }
    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
    /*@PostMapping
    public void changeTicketDate(@RequestBody TicketRequest ticketRequest) {
        ticketService.setTicketDate(ticketRequest);
    }*/
    @PostMapping
    void addTicket(@RequestBody TicketRequest ticketRequest) {
        ticketService.setTicket(ticketRequest);
    }
}
