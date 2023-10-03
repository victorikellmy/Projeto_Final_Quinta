package com.example.victor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.victor.model.entity.Empresa;
import com.example.victor.model.repository.EmpresaRepository;

import jakarta.transaction.Transactional;


@Transactional
@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    EmpresaRepository empresaRepository;

 
    @GetMapping
    public List<Empresa> empresas(){
        return  empresaRepository.findAll();

    }

    @GetMapping("/{id}")
    public Optional<Empresa> empresa(@PathVariable Long id){
        return empresaRepository.findById(id);
    }

    @PostMapping
    public Empresa save(@RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }

    @DeleteMapping("/{id}")
    public void empresaDeletar(@PathVariable Long id){
         empresaRepository.deleteById(id);
    }

    
    @PutMapping("/{id}")
    public Optional<Empresa> editar(@RequestBody Empresa empresa, @PathVariable Long id){
        return empresaRepository.findById(id).map(e -> {
            e.setNome(empresa.getNome());
            e.setDescricao(empresa.getDescricao());
            e.setCnpj(empresa.getCnpj());
            e.setEmail(empresa.getEmail());
            var u = empresaRepository.save(e);
            return u;
        });
        
    }
}
