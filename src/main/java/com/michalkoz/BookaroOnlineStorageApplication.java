package com.michalkoz;

import com.michalkoz.catalog.domain.CatalogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.michalkoz.catalog.domain.Book;
import java.util.List;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class BookaroOnlineStorageApplication implements CommandLineRunner {

    public static void main( String[] args )
    {

        SpringApplication.run(BookaroOnlineStorageApplication.class, args);
        System.out.println( "Hello World!" );
    }

    @Override
    public void run(String... args) throws Exception {
        CatalogService service = new CatalogService();
        List<Book> books = service.findByTitle("Ogniem i Mieczem");
        books.forEach(System.out::println);
    }
}
