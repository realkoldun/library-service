package com.koldun.librarymodsen.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name="book_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    private BookEntity book;
    private Date takenDate;
    private Date returnDate;
}
