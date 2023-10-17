package com.example.victor.controller;

import com.example.victor.model.entity.Candidato;
import com.example.victor.model.entity.Empresa;
import com.example.victor.server.CandidatosServer;
import com.example.victor.server.EmpresaServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatosServer candidatosServer;

    @PostMapping
    public ResponseEntity<Candidato> salvarEmpresa(@RequestBody Candidato candidato) {
        Candidato novoCandidato = candidatosServer.save(candidato);
        return ResponseEntity.ok().body(novoCandidato);
    }

    @GetMapping
    public List<Candidato> obterTodasEmpresas() {
        return candidatosServer.candidatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> obterCandidatoPorId(@PathVariable Long id) {
        Optional<Candidato> candidato = candidatosServer.candidato(id);
        return candidato.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidato> editarcandidato(@PathVariable Long id, @RequestBody Candidato candidato) {
        Optional<Candidato> candidatoAtualizada = candidatosServer.editar(candidato, id);
        return candidatoAtualizada.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCandidato(@PathVariable Long id) {
        candidatosServer.candidatoDeletar(id);
        return ResponseEntity.noContent().build();
    }
}
