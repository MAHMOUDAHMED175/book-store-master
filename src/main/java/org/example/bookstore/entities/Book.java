package org.example.bookstore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Double price;
    private String isbn;
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date")
    private Date publicationDate;
    private Integer stock;

    public Book(String title, String author, Double price, String isbn, String description, Date date, Integer stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.description = description;
        this.publicationDate = date;
        this.stock = stock;
    }
}
