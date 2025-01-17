package com.example.zagirox.biblioteca;

import com.example.zagirox.biblioteca.services.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(BookService bookService) {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			int option;

			do {
				System.out.println("--------------");
				System.out.println("Elija la opción a través de su número:");
				System.out.println("1- Buscar libro por título");
				System.out.println("2- Listar libros registrados");
				System.out.println("3- Listar autores registrados");
				System.out.println("4- Listar autores vivos en un determinado año");
				System.out.println("5- Listar libros por idioma");
				System.out.println("0- Salir");
				System.out.println("--------------");

				option = scanner.nextInt();
				scanner.nextLine();

				switch (option) {
					case 1:
						System.out.println("Ingrese el título del libro a buscar:");
						String title = scanner.nextLine();
						bookService.searchBookByTitle(title);
						break;
					case 2:
						bookService.listAllBooks();
						break;
					case 3:
						bookService.listAllAuthors();
						break;
					case 4:
						System.out.println("Ingrese el año:");
						int year = scanner.nextInt();
						bookService.listLivingAuthorsByYear(year);
						break;
					case 5:
						System.out.println("Ingrese el idioma para buscar los libros:");
						System.out.println("es- español");
						System.out.println("en- inglés");
						System.out.println("fr- francés");
						System.out.println("pt- portugués");
						String language = scanner.nextLine();
						bookService.listBooksByLanguage(language);
						break;
					case 0:
						System.out.println("Saliendo del sistema...");
						break;
					default:
						System.out.println("Opción no válida. Intente de nuevo.");
				}

			} while (option != 0);
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
