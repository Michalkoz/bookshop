package com.michalkoz.catalog.infrastructure;

import com.michalkoz.catalog.domain.Book;
import com.michalkoz.catalog.domain.CatalogRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Primary
class MemoryCatalogRepository implements CatalogRepository {

    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    private final AtomicLong ID_NEXT_VALUE = new AtomicLong(0L);

    public MemoryCatalogRepository() {
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

    @Override
    public Optional<Book> findById(Long id) {
        return storage.values().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    private Long nextId(){
        return ID_NEXT_VALUE.getAndIncrement();
    }
}
