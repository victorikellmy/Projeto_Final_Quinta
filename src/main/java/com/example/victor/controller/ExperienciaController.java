package com.example.victor.controller;

import com.example.victor.model.entity.Endereco;
import com.example.victor.model.entity.Experiencia;
import com.example.victor.server.EnderecoServer;
import com.example.victor.server.ExperienciaServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaServer experienciaServer;

    @PostMapping
    public ResponseEntity<Experiencia> salvarExperiencia(@RequestBody Experiencia experiencia) {
        Experiencia novaExperiencia = experienciaServer.save(experiencia);
        return ResponseEntity.ok().body(novaExperiencia);
    }

    @GetMapping
    public List<Experiencia> obterTodasEndereco() {
        return experienciaServer.experiencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> obterExperienciaPorId(@PathVariable Long id) {
        Optional<Experiencia> experiencia = experienciaServer.experiencia(id);
        return experiencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experiencia> editarExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        Optional<Experiencia> experienciaAtualizada = experienciaServer.editar(experiencia,id);
        return experienciaAtualizada.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExperiencia(@PathVariable Long id) {
        experienciaServer.experienciaDelete(id);
        return ResponseEntity.noContent().build();
    }
}
