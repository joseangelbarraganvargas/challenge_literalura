package com.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public record DatosDTO(List<LibroDTO> libros) {
    public DatosDTO(@JsonAlias({"results"}) List<LibroDTO> libros) {
        this.libros = libros;
    }

    @JsonAlias({"results"})
    public List<LibroDTO> libros() {
        return this.libros;
    }
}

