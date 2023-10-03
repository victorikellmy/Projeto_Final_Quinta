package com.example.victor.controller;

import com.example.victor.model.entity.Candidato;
import com.example.victor.model.repository.CandidatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Transactional
@Controller
@RequestMapping("candidatos")
public class CandidatosController {
    @Autowired
    CandidatoRepository candidatoRepository;


    @GetMapping
    public List<Candidato> candidatos(){
        return  candidatoRepository.findAll();

    }

    @GetMapping("/{id}")
    public Optional<Candidato> candidato(@PathVariable Long id){
        return candidatoRepository.findById(id);
    }

    @PostMapping
    public Candidato save(@RequestBody Candidato candidato){
        return candidatoRepository.save(candidato);
    }

    @DeleteMapping("/{id}")
    public void candidatoDeletar(@PathVariable Long id){
        candidatoRepository.deleteById(id);
    }


    @PutMapping("/{id}")
    public Optional<Candidato> editar(@RequestBody Candidato candidato, @PathVariable Long id){
        return candidatoRepository.findById(id).map(c -> {
            c.setNome(candidato.getNome());
            c.setEmail(candidato.getEmail());
            c.setTelefone(candidato.getTelefone());
            var u = candidatoRepository.save(c);
            return u;
        });

    }
}

