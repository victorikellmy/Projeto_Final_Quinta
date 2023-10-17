package com.example.victor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.victor.model.entity.Empresa;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

   @Query("SELECT e FROM Empresa e WHERE e.endereco.estado = :estado")
   List<Empresa> findByEstado(@Param("estado") String estado);

   List<Empresa>findByNome(String nome);

}
