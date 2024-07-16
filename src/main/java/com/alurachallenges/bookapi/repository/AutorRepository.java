package com.alurachallenges.bookapi.repository;

import com.alurachallenges.bookapi.models.Autor;
import com.alurachallenges.bookapi.models.AutorDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
