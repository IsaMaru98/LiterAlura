package com.alurachallenges.bookapi.repository;

import com.alurachallenges.bookapi.models.Libro;
import com.alurachallenges.bookapi.models.LibroDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
