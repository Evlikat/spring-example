package net.thumbtack.example.controller.model;

import javax.validation.constraints.Size;

import net.thumbtack.example.model.Cat;

@lombok.Data
public class CatCreation {

    @Size(min = 2, max = 50)
    private String name;

    public Cat build() {
        return new Cat(name);
    }
}
