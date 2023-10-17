package com.example.victor.controller;

import com.example.victor.model.entity.Endereco;
import com.example.victor.server.EnderecoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServer enderecoServer;

    @PostMapping()
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco) {
        Endereco novaEndereco = enderecoServer.save(endereco);
        return ResponseEntity.ok().body(novaEndereco);
    }

    @GetMapping
    public List<Endereco> obterTodasEndereco() {
        return enderecoServer.enderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> obterEnderecoPorId(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoServer.endereco(id);
        return endereco.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> editarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Endereco> enderecoAtualizada = enderecoServer.editar(endereco,id);
        return enderecoAtualizada.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoServer.enderecoDelete(id);
        return ResponseEntity.noContent().build();
    }
}
