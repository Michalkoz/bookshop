package com.michalkoz.catalog;

import com.michalkoz.catalog.application.CatalogController;
import com.michalkoz.catalog.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStartup implements CommandLineRunner {

    private final CatalogController catalogController;

    public ApplicationStartup(CatalogController catalogController) {
        this.catalogController = catalogController;
    }


    @Override
    public void run(String... args) {

        List<Book> books = catalogController.findByTitle("Pan");
        System.out.println("********************************************************************************************");
        books.forEach(System.out::println);
        System.out.println("********************************************************************************************");
    }
}
