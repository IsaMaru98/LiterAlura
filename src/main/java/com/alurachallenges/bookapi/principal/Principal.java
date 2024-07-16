package com.alurachallenges.bookapi.principal;

import com.alurachallenges.bookapi.models.LibroDTO;
import com.alurachallenges.bookapi.models.ResultadosDTO;
import com.alurachallenges.bookapi.service.ConsumoAPI;
import com.alurachallenges.bookapi.service.ConvierteDatos;

import java.util.*;

public class Principal {

    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mustraMenu() {
        boolean exit = false;

        while (!exit) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("Opción 1 seleccionada.");
                        buscaLibroPorTitulo();
                        break;
                    case 2:
                        System.out.println("Opción 2 seleccionada.");
                        // Lógica para la opción 2
                        break;
                    case 3:
                        System.out.println("Opción 3 seleccionada.");
                        // Lógica para la opción 3
                        break;
                    case 4:
                        System.out.println("Opción 4 seleccionada.");
                        // Lógica para la opción 4
                        break;
                    case 5:
                        System.out.println("Opción 5 seleccionada.");
                        // Lógica para la opción 5
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción inválida, por favor intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entre 1 y 6.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    private static void printMenu() {
        System.out.println("Bienvenida a  Literalura, escoge una opción");
        System.out.println("1. Buscar libros por titulo");
        System.out.println("2. Listar librs registrados");
        System.out.println("3. Listar autores registrados");
        System.out.println("4. Listar autores vivos en un determinado año");
        System.out.println("5. Listar libros por idioma");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
    public void buscaLibroPorTitulo(){
        System.out.println("Por favor escribe el nombre del libro que deseas buscar");
        var nombreLibro = scanner.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE+"?search="+nombreLibro.replace(" ","%20"));
        var datos = conversor.obtenerDatos(json, ResultadosDTO.class);
//
        Optional<LibroDTO> libroBuscado = datos.resultados().stream()
                .filter(l->l.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        }else{
            System.out.println("Libro no encontrado");
        }

    }
}


//        // Buscar los 10 libros mas descargados
//        var jsonMasDescargados = consumoAPI.obtenerDatos(URL_BASE);
//        var resultados = conversor.obtenerDatos(jsonMasDescargados, Resultados.class);
//
//        System.out.println("A continuacion los 10 libros más descargados");
//
//        resultados.resultados().stream()
//                .sorted(Comparator.comparing(Libros::totalDescargas).reversed())
//                .limit(10)
//                .map(l -> l.titulo().toUpperCase())
//                .forEach(System.out::println);
//
//        System.out.println("Algunas estadísticas...");
//
//        DoubleSummaryStatistics est = resultados.resultados().stream()
//                .filter(d -> d.totalDescargas() > 0)
//                .collect(Collectors.summarizingDouble(Libros::totalDescargas));
//        //System.out.println(est);
//        System.out.println("Media de descargas " + est.getAverage());
//        System.out.println("Mas descargado: " + est.getMax());
//        System.out.println("Menos decargado: " + est.getMin());
//        System.out.println("Cantidad " + est.getCount());
//
//////
//
//// Buscar libro por nombre o autor
//        System.out.println("Por favor escribe el nombre del libro o autor que deseas buscar");
//        var nombreLibro = teclado.nextLine();
//        var json = consumoAPI.obtenerDatos(URL_BASE+"?search="+nombreLibro.replace(" ","%20"));
//
//        var datos = conversor.obtenerDatos(json, Resultados.class);
//
//        Optional<Libros> libroBuscado = datos.resultados().stream()
//                .filter(l->l.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
//                .findFirst();
//        if(libroBuscado.isPresent()){
//            System.out.println("Libro encontrado");
//            System.out.println(libroBuscado.get());
//        }else{
//            System.out.println("Libro no encontrado");
//        }
//
//   //     }
//

