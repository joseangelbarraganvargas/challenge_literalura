package com.challenge.literalura.service;

import com.challenge.literalura.entities.Autor;
import com.challenge.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AutorService {
    Scanner teclado;
    @Autowired
    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.teclado = new Scanner(System.in);
        this.autorRepository = autorRepository;
    }

    public void showAllAuthors() {
        this.autorRepository.findAll().forEach((autor) -> {
            System.out.println(autor.getname());
        });
    }

    public void showAllAuthorsAlive() {
        System.out.println("Introduce el año");
        Long year = this.teclado.nextLong();
        List<Autor> autores = this.autorRepository.autoresVivosPorAnio(year);
        autores.forEach((autor) -> {
            System.out.println(autor.getname());
        });
    }
}
