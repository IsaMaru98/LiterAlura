package com.alurachallenges.bookapi.repository;

import com.alurachallenges.bookapi.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
