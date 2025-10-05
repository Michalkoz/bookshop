package com.michalkoz.catalog;

import com.michalkoz.catalog.application.CatalogController;
import com.michalkoz.catalog.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStartup implements CommandLineRunner {

    private final CatalogController catalogController;
    private final String title;

    public ApplicationStartup(CatalogController catalogController, String title) {
        this.catalogController = catalogController;
        this.title = title;
    }


    @Override
    public void run(String... args) {

        List<Book> books = catalogController.findByTitle(title);
        System.out.println("********************************************************************************************");
        books.forEach(System.out::println);
        System.out.println("********************************************************************************************");
    }
}
