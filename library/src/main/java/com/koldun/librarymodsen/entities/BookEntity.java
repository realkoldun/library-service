package com.koldun.librarymodsen.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String ISBN;
    @Column(nullable=false)
    private String title;
    private String genre;
    private String description;
    @Column(nullable=false)
    private String author;
}

