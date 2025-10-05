package com.michalkoz.catalog;

import com.michalkoz.catalog.application.CatalogController;
import com.michalkoz.catalog.domain.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStartup implements CommandLineRunner {

    private final CatalogController catalogController;
    private final String title;
    private final Long limit;

    public ApplicationStartup(CatalogController catalogController,
                              @Value("${Bookaro.catalog.query}") String title,
                              @Value("${Bookaro.catalog.limit}") Long limit
    ) {
        this.catalogController = catalogController;
        this.title = title;
        this.limit = limit;
    }


    @Override
    public void run(String... args) {

        List<Book> books = catalogController.findByTitle(title);
        System.out.println("********************************************************************************************");
        books.stream().limit(limit).forEach(System.out::println);
        System.out.println("********************************************************************************************");
    }
}
