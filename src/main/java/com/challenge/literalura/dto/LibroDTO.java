package com.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public record LibroDTO(Integer id, String titulo, List<String> idiomas, Integer numeroDescargas, List<String> tags, List<AutorDTO> autores) {
    public LibroDTO(@JsonAlias({"id"}) Integer id, @JsonAlias({"title"}) String titulo, @JsonAlias({"languages"}) List<String> idiomas, @JsonAlias({"download_count"}) Integer numeroDescargas, @JsonAlias({"subjects"}) List<String> tags, @JsonAlias({"authors"}) List<AutorDTO> autores) {
        this.id = id;
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.numeroDescargas = numeroDescargas;
        this.tags = tags;
        this.autores = autores;
    }

    @JsonAlias({"id"})
    public Integer id() {
        return this.id;
    }

    @JsonAlias({"title"})
    public String titulo() {
        return this.titulo;
    }

    @JsonAlias({"languages"})
    public List<String> idiomas() {
        return this.idiomas;
    }

    @JsonAlias({"download_count"})
    public Integer numeroDescargas() {
        return this.numeroDescargas;
    }

    @JsonAlias({"subjects"})
    public List<String> tags() {
        return this.tags;
    }

    @JsonAlias({"authors"})
    public List<AutorDTO> autores() {
        return this.autores;
    }
}

