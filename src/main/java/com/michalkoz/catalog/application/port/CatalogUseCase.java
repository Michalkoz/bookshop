package com.michalkoz.catalog.application.port;

import com.michalkoz.catalog.domain.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    List<Book> findByTitle(String title);

    List<Book> findAll();

    Optional<Book> findOneByTitleAndAuthor(String title, String author);

//    void addBook(CreateBookCommand createBookCommand);
    void addBook(Long id, String title, String author, Integer year);

    void removeById(Long id);

    void updateBook();

    // @Value z Lomboka od razu pola są prywatne i finalne

//    @Value
//    class CreateBookCommand {
//        Long id;
//        String title;
//        String author;
//        Integer year;
//    }
}
