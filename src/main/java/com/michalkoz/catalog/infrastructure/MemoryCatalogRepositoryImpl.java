package com.michalkoz.catalog.infrastructure;

import com.michalkoz.catalog.domain.Book;
import com.michalkoz.catalog.domain.CatalogRepository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryCatalogRepositoryImpl implements CatalogRepository {

    private final Map<Long, Book> storage = new ConcurrentHashMap<>();

    public MemoryCatalogRepositoryImpl() {


        storage.put(1l, new Book(1l, "Book 1", "Author 1", 1999));
        storage.put(2L, new Book(1L, "Ogniem i mieczem", "Henryk Sienkiewicz", 1884));
        storage.put(3L, new Book(1L, "Pan Tadeusz", "Adam Mickiewicz", 1834));
        storage.put(3L, new Book(1L, "Chłopi", "Władysław Reymont", 1904));
    }

    @Override
    public List<Book> findAll() {
        // 1 opcja
//        return List.of(new Book(1l, "Book 1", "Author 1", 1999));

        // 2 opcja
        return new ArrayList<>(storage.values());
    }
}
