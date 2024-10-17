package com.koldun.librarymodsen.interfaces;

import com.koldun.librarymodsen.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepositoty extends CrudRepository<TicketEntity, Long> {
}
