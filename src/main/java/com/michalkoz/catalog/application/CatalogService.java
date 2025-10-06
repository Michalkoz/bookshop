package com.michalkoz.catalog.application;

import com.michalkoz.catalog.domain.Book;
import com.michalkoz.catalog.domain.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogService implements com.michalkoz.catalog.application.port.CatalogUseCase {

    private final CatalogRepository repository;

    public CatalogService(CatalogRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Book> findByTitle(String title){
        return repository.findAll()
                .stream()
                .filter(book -> book.title.startsWith(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAll(){
        return null;
    }

    @Override
    public Optional<Book> findOneByTitleAndAuthor(String title, String author){
        return null;
    }

    @Override
    public void addBook(){

    }

    @Override
    public void removeById(Long id){

    }

    @Override
    public void updateBook(){

    }
}
