package com.alurachallenges.bookapi.principal;

import com.alurachallenges.bookapi.models.Libros;
import com.alurachallenges.bookapi.models.Resultados;
import com.alurachallenges.bookapi.service.ConsumoAPI;
import com.alurachallenges.bookapi.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mustraMenu() {

        // Buscar los 10 libros mas descargados
        var jsonMasDescargados = consumoAPI.obtenerDatos(URL_BASE);
        var resultados = conversor.obtenerDatos(jsonMasDescargados, Resultados.class);

        System.out.println("A continuacion los 10 libros más descargados");

        resultados.resultados().stream()
                .sorted(Comparator.comparing(Libros::totalDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        System.out.println("Algunas estadísticas...");

        DoubleSummaryStatistics est = resultados.resultados().stream()
                .filter(d -> d.totalDescargas() > 0)
                .collect(Collectors.summarizingDouble(Libros::totalDescargas));
        //System.out.println(est);
        System.out.println("Media de descargas " + est.getAverage());
        System.out.println("Mas descargado: " + est.getMax());
        System.out.println("Menos decargado: " + est.getMin());
        System.out.println("Cantidad " + est.getCount());

////

// Buscar libro por nombre o autor
        System.out.println("Por favor escribe el nombre del libro o autor que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE+"?search="+nombreLibro.replace(" ","%20"));

        var datos = conversor.obtenerDatos(json, Resultados.class);

        Optional<Libros> libroBuscado = datos.resultados().stream()
                .filter(l->l.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        }else{
            System.out.println("Libro no encontrado");
        }

   //     }

    }
}
