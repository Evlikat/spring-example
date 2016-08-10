package net.thumbtack.example.repo;

import java.util.List;

import net.thumbtack.example.model.Cat;
import net.thumbtack.example.service.CatSavingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long>, CatSavingRepository {

    Page<Cat> findAll(Pageable pageable);

    Cat saveAndFlush(Cat cat);

    List<Cat> findByNameIgnoringCase(String name);
}
