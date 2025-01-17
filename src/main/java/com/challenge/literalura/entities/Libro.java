package com.challenge.literalura.entities;

import com.challenge.literalura.dto.LibroDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "libro"
)
public class Libro {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            unique = true
    )
    private String name;
    @Column(
            nullable = false
    )
    private List<String> idiomas;
    private Integer numeroDescargas;
    private List<String> tags;
    @ManyToOne
    private Autor autor;

    public Libro() {
    }

    public Libro(LibroDTO libroDTO) {
        this.name = libroDTO.titulo();
        this.idiomas = libroDTO.idiomas();
        this.numeroDescargas = libroDTO.numeroDescargas();
        this.tags = libroDTO.tags();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIdiomas() {
        return this.idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDescargas() {
        return this.numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String toString() {
        String var10000 = this.getName();
        return "Titulo -> " + var10000 + "\nIdiomas -> " + String.valueOf(this.getIdiomas()) + "\nNumeroDescargas-> " + String.valueOf(this.getNumeroDescargas()) + "\nEtiquetas -> " + String.valueOf(this.getTags()) + "\nAutor -> " + this.autor.getname();
    }
}
