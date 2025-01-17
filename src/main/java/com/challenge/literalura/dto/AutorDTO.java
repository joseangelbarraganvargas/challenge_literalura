package com.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
public record AutorDTO(String name, Integer birth_year, Integer death_year) {
    public AutorDTO(@JsonAlias({"name"}) String name, @JsonAlias({"birth_year"}) Integer birth_year, @JsonAlias({"death_year"}) Integer death_year) {
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
    }

    @JsonAlias({"name"})
    public String name() {
        return this.name;
    }

    @JsonAlias({"birth_year"})
    public Integer birth_year() {
        return this.birth_year;
    }

    @JsonAlias({"death_year"})
    public Integer death_year() {
        return this.death_year;
    }
}
