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

    private final CatalogService catalogService;

    // tu katalog service jest wstrzykniety
    public BookaroOnlineStorageApplication( CatalogService catalogService ) {
        this.catalogService = catalogService;
    }

    @Override
    public void run(String... args) throws Exception {
//        CatalogService service = new CatalogService();
        //juz nie wolamy recznie takiej zaleznosci
//        List<Book> books = service.findByTitle("Ogniem i mieczem");

        // tylko wstrzykujemy taka zaleznosc:
        List<Book> books = catalogService.findByTitle("Ogniem i mieczem"); 
        books.forEach(System.out::println);
    }
}
