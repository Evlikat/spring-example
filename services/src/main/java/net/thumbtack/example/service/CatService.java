package net.thumbtack.example.service;

import javax.transaction.Transactional;

import net.thumbtack.example.model.Cat;

public class CatService {

    private final CatSavingRepository catRepository;

    public CatService(CatSavingRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Transactional
    public Cat createWithClone(Cat prototype) {
        catRepository.saveAndFlush(new Cat(prototype.getName() + "-clone"));
        if (prototype.getName().equals("NOOO!")) {
            throw new IllegalArgumentException("NOOO!");
        }
        return catRepository.saveAndFlush(prototype);
    }
}
