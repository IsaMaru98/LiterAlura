package com.alurachallenges.bookapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Libros(
        @JsonAlias("title") String titulo,

        @JsonAlias("authors") List<Autor> autores,
        @JsonAlias("languages") List<String> idiomas,

        @JsonAlias("download_count") Double totalDescargas

) {
    @Override
    public String toString() {
        return  "Titulo: " + titulo+
                ", Total Descargas: " + totalDescargas+
                ", Idiomas: " + idiomas +
                ", Autores: " + autores;
    }
}
