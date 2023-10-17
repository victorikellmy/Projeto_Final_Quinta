package com.example.victor.controller;

import com.example.victor.model.entity.Experiencia;
import com.example.victor.model.entity.Vaga;
import com.example.victor.server.ExperienciaServer;
import com.example.victor.server.VagaServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vagas")
public class VagaController {


    @Autowired
    private VagaServer vagaServer;

    @PostMapping
    public ResponseEntity<Vaga> salvarVaga(@RequestBody Vaga vaga) {
        var novavaga = vagaServer.save(vaga);
        return ResponseEntity.ok().body(novavaga);
    }

    @GetMapping
    public List<Vaga> obterTodasVaga() {
        return vagaServer.vagas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> obterVagaPorId(@PathVariable Long id) {
        var vaga = vagaServer.vaga(id);
        return vaga.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> editarVaga(@PathVariable Long id, @RequestBody Vaga vaga) {
        var vagaAtualizada = vagaServer.editar(vaga, id);
        return vagaAtualizada.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable Long id) {
        vagaServer.vagaDelete(id);
        return ResponseEntity.noContent().build();
    }
}
