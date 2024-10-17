package com.koldun.librarymodsen.services;

import com.koldun.librarymodsen.controller.ticket.TicketRequest;
import com.koldun.librarymodsen.entities.BookEntity;
import com.koldun.librarymodsen.entities.TicketEntity;
import com.koldun.librarymodsen.interfaces.book.BookRepository;
import com.koldun.librarymodsen.interfaces.ticket.TicketRepositoty;
import com.koldun.librarymodsen.interfaces.ticket.TicketService;
import com.koldun.librarymodsen.interfaces.ticket.TicketToEntityMapper;
import com.koldun.librarymodsen.model.Ticket;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultTicketService implements TicketService {
    private final TicketRepositoty ticketRepository;
    private final BookRepository bookRepository;
    private final TicketToEntityMapper mapper;
    //private final TicketToDtoMapper dtoMapper;

    @Override
    public Ticket getTicketById(Long id) {
        TicketEntity ticketEntity = ticketRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found: = " + id));
        return mapper.ticketEntityToTicket(ticketEntity);
    }


    @Override
    public void setTicket(TicketRequest ticketRequest) {
        BookEntity book = bookRepository
                .findById(ticketRequest.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found: id = " + ticketRequest.getBookId()));
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setBook(book);
        ticketEntity.setTakenDate(ticketRequest.getTakenDate());
        ticketEntity.setReturnDate(ticketRequest.getReturnDate());
        ticketRepository.save(ticketEntity);
    }

    @Override
    public List<Ticket> getAllTickets() {
        Iterable<TicketEntity> ticketEntities = ticketRepository.findAll();
        List<Ticket> tickets = new ArrayList<>();
        for (TicketEntity ticketEntity : ticketEntities)
            tickets.add(mapper.ticketEntityToTicket(ticketEntity));
        return tickets;
    }

    @Override
    public void setTicketDate(TicketRequest ticketRequest) {

    }
}
