package com.example.victor.controller;

import com.example.victor.model.entity.Candidato;
import com.example.victor.model.entity.Endereco;
import com.example.victor.model.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Transactional
@Controller
@RequestMapping("enderecos")
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> enderecos(){
        return enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Endereco> endereco(@PathVariable Long id){
        return  enderecoRepository.findById(id);
    }

    @PostMapping
    public Endereco save(@RequestBody Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    @DeleteMapping("/{id}")
    public void enderecoDelete(@PathVariable Long id){
        enderecoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Endereco> editar(@RequestBody Endereco endereco, @PathVariable Long id){
        return enderecoRepository.findById(id).map(e -> {
            e.setRua(endereco.getRua());
            e.setCidade(endereco.getCidade());
            e.setEstado(endereco.getEstado());
            e.setTipo(endereco.getTipo());
            e.setUf(endereco.getUf());
            var u = enderecoRepository.save(e);
            return u;
        });

    }

}
