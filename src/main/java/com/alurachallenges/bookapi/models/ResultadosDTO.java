package com.alurachallenges.bookapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadosDTO(
        @JsonAlias("results") List<LibroDTO> resultados
) {
}
