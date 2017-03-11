package net.thumbtack.example.service;

import net.thumbtack.example.model.Cat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long>, CatSavingRepository {

    Page<Cat> findAll(Pageable pageable);

    Cat saveAndFlush(Cat cat);

    List<Cat> findByNameIgnoringCase(String name);
}
