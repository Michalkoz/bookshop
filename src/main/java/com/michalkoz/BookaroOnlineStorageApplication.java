package com.michalkoz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BookaroOnlineStorageApplication{

    public static void main( String[] args )
    {
        SpringApplication.run(BookaroOnlineStorageApplication.class, args);
    }

    // usuwamy, nie bedziemy rejestrowac takich beanow w kontekscie springa
//    @Bean
//    String query() {
//        return "Mężczyźni";
//    }

}
