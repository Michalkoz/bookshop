package com.michalkoz.catalog.domain;

import lombok.*;

//nie przechodzi Required lub AllArgsConstructor
//@AllArgsConstructor
@ToString
@Getter
public class Book {
    private final Long id;
    public final String title;
    private final String author;
    private final Integer year;

    public Book(Long id, String title, String author, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
