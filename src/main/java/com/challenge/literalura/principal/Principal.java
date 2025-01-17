package com.challenge.literalura.principal;

import com.challenge.literalura.repository.AutorRepository;
import com.challenge.literalura.repository.LibroRepository;
import com.challenge.literalura.service.AutorService;
import com.challenge.literalura.service.LibroService;

import java.util.Scanner;

public class Principal {
    private LibroService libroService;
    private AutorService autorService;
    private Scanner teclado;

    public Principal(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.teclado = new Scanner(System.in);
        this.libroService = new LibroService(libroRepository);
        this.autorService = new AutorService(autorRepository);
    }

    public void menu() {
        int opcion = -1;

        while(opcion != 0) {
            String menu = "------- MENU PRINCIPAL -------\n1 - Buscar libro por titulo\n2 - Listar todos los libros\n3 - Lista de autores\n4 - Listar autores vivos en determinado año\n5 - Cantidad de libros por autor\n6 - Listar libros por idioma\n7 - Cantidad de libros de un idioma\n8 - Buscar libro por etiqueta\n9 - Top 5 libros mas descargados\n\n0 - Salir\n";
            System.out.println(menu);
            opcion = this.teclado.nextInt();
            this.teclado.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                case 1:
                    this.libroService.findByTitle();
                    break;
                case 2:
                    this.libroService.showAllBooks();
                    break;
                case 3:
                    this.autorService.showAllAuthors();
                    break;
                case 4:
                    this.autorService.showAllAuthorsAlive();
                    break;
                case 5:
                    this.libroService.amountOfBooksByAuthor();
                    break;
                case 6:
                    this.libroService.showBooksByLanguage();
                case 7:
                    break;
                case 8:
                    this.libroService.showAllBooksByTag();
                    break;
                case 9:
                    this.libroService.showTop5Books();
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }
}
