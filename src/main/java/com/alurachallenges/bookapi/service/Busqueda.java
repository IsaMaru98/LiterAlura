//package com.alurachallenges.bookapi.service;
//
//public class Busqueda {
//
//    public String buscaLibroPorTitulo(){
//        System.out.println("Por favor escribe el nombre del libro o autor que deseas buscar");
//        var nombreLibro = scanner.nextLine();
//        var json = consumoAPI.obtenerDatos(URL_BASE+"?search="+nombreLibro.replace(" ","%20"));
//
//    }

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


