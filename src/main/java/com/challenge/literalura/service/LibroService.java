package com.challenge.literalura.service;

import com.challenge.literalura.entities.Libro;
import com.challenge.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibroService {
    private Scanner teclado;
    @Autowired
    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.teclado = new Scanner(System.in);
        this.libroRepository = libroRepository;
    }

    public void mostrarLibrosPorIdioma() {
        List<Libro> libros = this.libroRepository.findAll();
        Map<String, List<Libro>> librosPorIdioma = new HashMap();
        Iterator var4 = libros.iterator();

        Iterator var6;
        while(var4.hasNext()) {
            Libro libro = (Libro)var4.next();
            var6 = libro.getIdiomas().iterator();

            while(var6.hasNext()) {
                String idioma = (String)var6.next();
                ((List)librosPorIdioma.computeIfAbsent(idioma, (k) -> {
                    return new ArrayList();
                })).add(libro);
            }
        }

        var4 = librosPorIdioma.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<String, List<Libro>> entry = (Map.Entry)var4.next();
            System.out.println("Idioma: " + (String)entry.getKey());
            var6 = ((List)entry.getValue()).iterator();

            while(var6.hasNext()) {
                Libro libro = (Libro)var6.next();
                System.out.println("  Libro: " + libro.getName());
            }
        }

    }

    public void findByTitle() {
        System.out.println("Escribe el titulo del libro que deseas buscar");
        String nombreLibro = this.teclado.nextLine();
        List<Libro> libroBuscado = this.libroRepository.findByNameIgnoreCase(nombreLibro);
        if (libroBuscado.isEmpty()) {
            System.out.println("Libro no encontrado");
        } else {
            libroBuscado.stream().forEach((l) -> {
                System.out.println("--------------------------");
                System.out.println(l);
                System.out.println("--------------------------");
            });
        }
    }

    public void showAllBooks() {
        System.out.println("--------------------------");
        this.libroRepository.findAll().forEach((libro) -> {
            System.out.println(" - " + libro.getName());
        });
        System.out.println("--------------------------");
    }

    public void showBooksByLanguage() {
        System.out.println("Ingrese el idioma que desea buscar: ");
        String idiomaBuscado = this.teclado.nextLine().trim();
        List<Libro> libros = this.libroRepository.findAll();
        List<Libro> librosFiltrados = (List)libros.stream().filter((librox) -> {
            return librox.getIdiomas().contains(idiomaBuscado);
        }).collect(Collectors.toList());
        if (librosFiltrados.isEmpty()) {
            System.out.println("No se encontraron libros en el idioma: " + idiomaBuscado);
        } else {
            System.out.println("Libros en el idioma " + idiomaBuscado + ":");
            Iterator var5 = librosFiltrados.iterator();

            while(var5.hasNext()) {
                Libro libro = (Libro)var5.next();
                System.out.println("  Libro: " + libro.getName());
            }
        }

    }

    public void showAllBooksByTag() {
        System.out.println("Escribe la etiqueta que deseas buscar");
        String tag = this.teclado.nextLine().trim();
        List<Libro> libros = this.libroRepository.findAll();
        List<Libro> librosFiltrados = (List)libros.stream().filter((librox) -> {
            return librox.getTags().contains(tag);
        }).collect(Collectors.toList());
        if (librosFiltrados.isEmpty()) {
            System.out.println("No se encontraron libros con la etiqueta: " + tag);
        } else {
            System.out.println("Libros con la etiqueta " + tag + ":");
            Iterator var5 = librosFiltrados.iterator();

            while(var5.hasNext()) {
                Libro libro = (Libro)var5.next();
                System.out.println("  Libro: " + libro.getName());
            }
        }

    }

    public void showTop5Books() {
        List<Libro> top5Libros = this.libroRepository.findTop5ByOrderByNumeroDescargasDesc(PageRequest.of(0, 5));
        top5Libros.forEach((libro) -> {
            System.out.println(libro.getName());
        });
    }

    public void countAmountOfBooksByLanguage() {
        System.out.println("Escribe el idioma que deseas buscar");
        String language = this.teclado.nextLine().trim();
        List<Libro> libros = this.libroRepository.findAll();
        List<Libro> librosFiltrados = (List)libros.stream().filter((libro) -> {
            return libro.getIdiomas().contains(language);
        }).collect(Collectors.toList());
        if (librosFiltrados.isEmpty()) {
            System.out.println("No se encontraron libros en el idioma: " + language);
        } else {
            System.out.println("El idioma " + language + " tiene " + librosFiltrados.size() + " libros.");
        }
    }

    public void amountOfBooksByAuthor() {
        System.out.println("Escribe el nombre del autor que deseas buscar");
        String authorName = this.teclado.nextLine();
        Long amount = this.libroRepository.countBooksByAuthor(authorName);
        System.out.println("El autor " + authorName + " ha escrito " + String.valueOf(amount) + " libros.");
    }
}
