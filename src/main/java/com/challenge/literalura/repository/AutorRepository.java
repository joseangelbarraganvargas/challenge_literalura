package com.challenge.literalura.repository;

import com.challenge.literalura.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByName(String name);

    Optional<Autor> findById(Long id);

    @Query("SELECT a FROM Autor a WHERE a.birth_year <= :year AND a.death_year >= :year")
    List<Autor> autoresVivosPorAnio(Long year);
}
