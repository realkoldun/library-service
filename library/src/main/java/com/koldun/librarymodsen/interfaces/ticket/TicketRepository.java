package com.koldun.librarymodsen.interfaces.ticket;

import com.koldun.librarymodsen.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
    void deleteById(Long id);
}
