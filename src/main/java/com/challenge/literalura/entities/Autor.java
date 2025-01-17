package com.challenge.literalura.entities;

import com.challenge.literalura.dto.AutorDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "autor"
)
public class Autor {
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
    private Integer birth_year;
    private Integer death_year;
    @OneToMany(
            mappedBy = "autor",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER
    )
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(AutorDTO autorDTO) {
        this.name = autorDTO.name();
        this.birth_year = autorDTO.birth_year();
        this.death_year = autorDTO.death_year();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return this.birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return this.death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    public List<Libro> getLibros() {
        return this.libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public String toString() {
        String var10000 = String.valueOf(this.id);
        return "Autor [id=" + var10000 + ", name=" + this.name + ", birth_year=" + String.valueOf(this.birth_year) + ", death_year=" + String.valueOf(this.death_year) + ", libros=" + String.valueOf(this.libros) + "]";
    }
}
