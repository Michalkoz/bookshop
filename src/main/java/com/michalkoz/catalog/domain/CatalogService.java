package com.michalkoz.catalog.domain;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CatalogService {

    //bedziemy wstrzykiwac katalog repository
    private final CatalogRepository repository;

    public CatalogService(CatalogRepository repository) {
        this.repository = repository;



    }

//    public List<Book> findByTitle(String title){
//        return repository.findAll()
//                .stream()
//                .filter(book -> book.title.startsWith(title))
//                .collect(Collectors.toList());
//    }
    public List<Book> findAll(String title){
        return repository.findAll()
                .stream()
                .filter(book -> book.title.startsWith(title))
                .collect(Collectors.toList());


    }
}
