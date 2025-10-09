package com.michalkoz.catalog;

import com.michalkoz.catalog.application.port.CatalogUseCase;
import com.michalkoz.catalog.domain.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class ApplicationStartup implements CommandLineRunner {

    private final CatalogUseCase catalog;
    private final String title;
    private final Long limit;

    public ApplicationStartup(CatalogUseCase catalog,
                              @Value("${Bookaro.catalog.query}") String title,
                              @Value("${Bookaro.catalog.limit:3}") Long limit
    ) {
        this.catalog = catalog;
        this.title = title;
        this.limit = limit;
    }

    @Override
    public void run(String... args) {
        initData();
        findByTitle();
    }

    private void initData() {
//        catalog.addBook(new CatalogUseCase.CreateBookCommand("Book 1", "Author 1", 1999));
//        catalog.addBook(new CatalogUseCase.CreateBookCommand("Ogniem i mieczem", "Henryk Sienkiewicz", 1884));
//        catalog.addBook(new CatalogUseCase.CreateBookCommand("Pan Tadeusz", "Adam Mickiewicz", 1834));
//        catalog.addBook(new CatalogUseCase.CreateBookCommand("Chłopi", "Władysław Reymont", 1904));
//        catalog.addBook(new CatalogUseCase.CreateBookCommand("PanSamochodzik", "Zbigniew Nienacki", 1904));

        catalog.addBook("Book 1", "Author 1", 1999);
        catalog.addBook("Ogniem i mieczem", "Henryk Sienkiewicz", 1884);
        catalog.addBook("Pan Tadeusz", "Adam Mickiewicz", 1834);
        catalog.addBook("Chłopi", "Władysław Reymont", 1904);
        catalog.addBook("PanSamochodzik", "Zbigniew Nienacki", 1904);
    }

    private void findByTitle() {
        List<Book> books = catalog.findByTitle(title);
        System.out.println("********************************************************************************************");
        books.stream().limit(limit).forEach(System.out::println);
        System.out.println("********************************************************************************************");
    }
}
