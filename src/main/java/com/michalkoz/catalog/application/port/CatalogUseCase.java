package com.michalkoz.catalog.application.port;

import com.michalkoz.catalog.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    List<Book> findByTitle(String title);

    List<Book> findAll();

    Optional<Book> findOneByTitleAndAuthor(String title, String author);

//    void addBook(CreateBookCommand createBookCommand);
    void addBook(String title, String author, Integer year);

    void removeById(Long id);

    UpdateBookResponse updateBook(Long id, String title, String author, Integer year);
//    void updateBook(Long id, String title, String author, Integer year);

    // @Value z Lomboka od razu pola są prywatne i finalne

//    @Value
//    class CreateBookCommand {
//        Long id;

//        String title;
//        String author;
//        Integer year;
//    }

//    @AllArgsConstructor
    public static class UpdateBookResponse {
        public static UpdateBookResponse SUCCESS = new UpdateBookResponse(true, Collections.emptyList());

        boolean success;
        List<String> errors;

        public UpdateBookResponse(boolean success, List<String> errors) {
            this.success = success;
            this.errors = errors;
        }
    }
}
