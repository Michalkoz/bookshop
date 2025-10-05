package com.michalkoz;

import com.michalkoz.catalog.domain.CatalogService;
import com.michalkoz.catalog.infrastructure.MemoryCatalogRepositoryImpl;
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

    private final MemoryCatalogRepositoryImpl memoryCatalogRepositoryImpl;

    // tu katalog service jest wstrzykniety
    public BookaroOnlineStorageApplication(MemoryCatalogRepositoryImpl memoryCatalogRepositoryImpl) {
        this.memoryCatalogRepositoryImpl = memoryCatalogRepositoryImpl;
    }

    @Override
    public void run(String... args) throws Exception {
//        CatalogService service = new CatalogService();
        //juz nie wolamy recznie takiej zaleznosci
//        List<Book> books = service.findByTitle("Ogniem i mieczem");

        // tylko wstrzykujemy taka zaleznosc:
//        List<Book> books = catalogService.findByTitle("Ogniem i mieczem");
//        books.forEach(System.out::println);
        List<Book> books = memoryCatalogRepositoryImpl.findAll();
//        .findByTitle("Ogniem i mieczem");
        books.forEach(System.out::println);
    }
}
