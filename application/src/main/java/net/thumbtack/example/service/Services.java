package net.thumbtack.example.service;

import net.thumbtack.example.repo.CatRepository;
import org.springframework.context.annotation.Bean;

public class Services {

    @Bean
    public CatService catService(CatRepository catRepository) {
        return new CatService(catRepository);
    }
}
