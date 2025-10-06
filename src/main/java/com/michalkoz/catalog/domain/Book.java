package com.michalkoz.catalog.domain;

import lombok.*;

//nie przechodzi Required lub AllArgsConstructor
//@AllArgsConstructor
@ToString
@Getter
@Setter
public class Book {
    public Long id;
    public String title;
    private String author;
    private Integer year;

    public Book(Long id, String title, String author, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

//    public Book(String title, String author, Integer year) {
//        this.title = title;
//        this.author = author;
//        this.year = year;
//    }
}
