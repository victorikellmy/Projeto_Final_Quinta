package com.example.victor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.victor.model.entity.Candidato;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
