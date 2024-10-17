package com.koldun.librarymodsen.model;

import java.util.Date;

public record Ticket(Book book,
                     Date takenDate,
                     Date returnDate) {
}
