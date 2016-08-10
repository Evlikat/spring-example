package net.thumbtack.example.service;

import net.thumbtack.example.model.Cat;

public interface CatSavingRepository {

    Cat saveAndFlush(Cat cat);
}
