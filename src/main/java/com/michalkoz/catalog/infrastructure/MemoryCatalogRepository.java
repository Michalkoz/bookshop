package com.michalkoz.catalog.infrastructure;

import com.michalkoz.catalog.domain.Book;
import com.michalkoz.catalog.domain.CatalogRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Primary
class MemoryCatalogRepository implements CatalogRepository {

    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    private final AtomicLong ID_NEXT_VALUE = new AtomicLong(0L);

    public MemoryCatalogRepository() {
        storage.put(1L, new Book(1L, "Book 1", "Author 1", 1999));
        storage.put(2L, new Book(2L, "Ogniem i mieczem", "Henryk Sienkiewicz", 1884));
        storage.put(3L, new Book(3L, "Pan Tadeusz", "Adam Mickiewicz", 1834));
        storage.put(4L, new Book(4L, "Chłopi", "Władysław Reymont", 1904));
        storage.put(5L, new Book(5L, "PanSamochodzik", "Zbigniew Nienacki", 1904));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void save(Book book) {
            Long nextId = nextId();
            book.setId(nextId);
            storage.put(nextId, book);
    }

    private Long nextId(){
        return ID_NEXT_VALUE.getAndIncrement();
    }
}
