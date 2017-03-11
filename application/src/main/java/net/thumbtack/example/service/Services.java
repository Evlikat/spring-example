package net.thumbtack.example.service;

import org.springframework.context.annotation.Bean;

public class Services {

    @Bean
    public CatService catService(CatRepository catRepository) {
        return new CatService(catRepository);
    }
}
