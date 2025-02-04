package com.alurachallenges.bookapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AutorDTO(
    @JsonAlias("name") String nombre,
    @JsonAlias("death_year") String fechaFallecimiento,
    @JsonAlias("birth_year") String fechaNacimiento
) {
}
