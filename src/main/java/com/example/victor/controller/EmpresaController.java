package com.example.victor.controller;
import java.util.List;
import java.util.Optional;

import com.example.victor.model.entity.Empresa;
import com.example.victor.server.EmpresaServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaServer empresaServer;

    @PostMapping
    public ResponseEntity<Empresa> salvarEmpresa(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = empresaServer.save(empresa);
        return ResponseEntity.ok().body(novaEmpresa);
    }

    @GetMapping
    public List<Empresa> obterTodasEmpresas() {
        return empresaServer.empresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obterEmpresaPorId(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaServer.empresa(id);
        return empresa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> editarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        Optional<Empresa> empresaAtualizada = empresaServer.editar(empresa, id);
        return empresaAtualizada.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        empresaServer.empresaDeletar(id);
        return ResponseEntity.noContent().build();
    }
}

