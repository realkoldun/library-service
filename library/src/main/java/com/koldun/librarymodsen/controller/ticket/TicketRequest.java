package com.koldun.librarymodsen.controller.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TicketRequest {
    private Long bookId;
    private Date takenDate;
    private Date returnDate;

    @Override
    public String toString() {
        return "TicketRequest{" +
                "bookId=" + bookId +
                ", takenDate=" + takenDate +
                ", returnDat=" + returnDate +
                '}';
    }
}
