package com.koldun.librarymodsen.interfaces.ticket;

import com.koldun.librarymodsen.controller.ticket.TicketRequest;
import com.koldun.librarymodsen.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketToDtoMapper {
    Ticket ticketRequestToTicket(TicketRequest ticketRequest);
}
