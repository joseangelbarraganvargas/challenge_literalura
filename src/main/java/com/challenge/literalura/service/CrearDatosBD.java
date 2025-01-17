package com.challenge.literalura.service;

import com.challenge.literalura.dto.DatosDTO;
import com.challenge.literalura.entities.Autor;
import com.challenge.literalura.entities.Libro;
import com.challenge.literalura.repository.AutorRepository;
import com.challenge.literalura.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Component
public class CrearDatosBD {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LibroRepository libroRepository;
    private String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI api = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public CrearDatosBD(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public void cargarLibrosBBDD() {
        IntStream.range(1, 200).forEach((i) -> {
            String json = this.api.obtenerDatos(this.URL_BASE + "?page=" + i);
            DatosDTO datos = (DatosDTO)this.conversor.obtenerDatos(json, DatosDTO.class);
            datos.libros().forEach((libro) -> {
                Libro nuevoLibro = new Libro(libro);
                libro.autores().forEach((autor) -> {
                    try {
                        Optional<Autor> autorBuscado = this.autorRepository.findByName(autor.name());
                        if (autorBuscado.isPresent()) {
                            nuevoLibro.setAutor((Autor)autorBuscado.get());
                            this.libroRepository.save(nuevoLibro);
                            return;
                        }

                        Autor a = new Autor(autor);
                        this.autorRepository.save(a);
                        nuevoLibro.setAutor(a);
                        this.libroRepository.save(nuevoLibro);
                    } catch (Exception var5) {
                        Exception e = var5;
                        System.out.println(e);
                    }

                });
            });
        });
    }

    @Transactional
    public void asignarValoresNulos() {
        List<Autor> autores = this.autorRepository.findAll();
        autores.forEach((a) -> {
            if (a.getBirth_year() == 0) {
                a.setBirth_year(0);
                a.setDeath_year(0);
            }

            if (a.getDeath_year() == 0) {
                a.setBirth_year(0);
                a.setDeath_year(0);
            }

        });
        this.autorRepository.saveAll(autores);
    }
}

