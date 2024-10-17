package com.koldun.librarymodsen.interfaces;

import com.koldun.librarymodsen.entities.TicketEntity;
import com.koldun.librarymodsen.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketToEntityMapper {
    Ticket ticketEntityToTicket(TicketEntity ticketEntity);
    TicketEntity ticketToTicketEntity(Ticket ticket);
}
