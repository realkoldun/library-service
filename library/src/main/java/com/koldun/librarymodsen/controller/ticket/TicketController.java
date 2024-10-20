package com.koldun.librarymodsen.controller.ticket;

import com.koldun.librarymodsen.interfaces.ticket.TicketService;
import com.koldun.librarymodsen.model.Ticket;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
@Tag(name="Ticket Controller", description = "How to interact with Tickets")
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
    @GetMapping("/free")
    public List<Ticket> getFreeBooks() {
        return ticketService.getFreeBooks();
    }
    @PostMapping("/update")
    public ResponseEntity<Ticket> setTicketDate(@RequestBody TicketRequest ticketRequest) {
        Ticket ticket = ticketService.setTicketDate(ticketRequest);
        return ResponseEntity.ok(ticket);
    }
    @PostMapping
    void addTicket(@RequestBody TicketRequest ticketRequest) {
        ticketService.setTicket(ticketRequest);
    }
}
