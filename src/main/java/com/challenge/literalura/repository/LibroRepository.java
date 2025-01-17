package com.challenge.literalura.repository;

import com.challenge.literalura.entities.Libro;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByNameIgnoreCase(String name);

    @Query("SELECT l FROM Libro l ORDER BY l.numeroDescargas DESC")
    List<Libro> findTop5ByOrderByNumeroDescargasDesc(Pageable pageable);

    @Query("SELECT COUNT(l) FROM Libro l WHERE l.autor.name = :authorName")
    Long countBooksByAuthor(@Param("authorName") String authorName);
}
