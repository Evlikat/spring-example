package net.thumbtack.example.controller;

import net.thumbtack.example.controller.model.CatCreation;
import net.thumbtack.example.model.Cat;
import net.thumbtack.example.repo.CatRepository;
import net.thumbtack.example.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cat")
public class CatController {

    private final CatRepository catRepository;
    private final CatService catService;

    @Autowired
    public CatController(CatRepository catRepository, CatService catService) {
        this.catRepository = catRepository;
        this.catService = catService;
    }

    @GetMapping
    public Page<Cat> findAll(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(value = "count", required = false, defaultValue = "10") Integer count,
                             @RequestParam(value = "name", required = false) String name
    ) {
        if (name == null) {
            return catRepository.findAll(new PageRequest(page, count));
        } else {
            return new PageImpl<>(catRepository.findByNameIgnoringCase("name"));
        }
    }

    @PostMapping
    public Cat create(@RequestBody CatCreation creation) {
        return catRepository.saveAndFlush(creation.build());
    }

    @PostMapping("/clone")
    public Cat createWithClone(@RequestBody CatCreation creation) {
        return catService.createWithClone(creation.build());
    }
}
