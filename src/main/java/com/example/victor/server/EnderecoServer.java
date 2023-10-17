package com.example.victor.server;

import com.example.victor.model.entity.Endereco;
import com.example.victor.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServer {
    @Autowired
    EnderecoRepository enderecoRepository;


    public List<Endereco> enderecos(){
        return enderecoRepository.findAll();
    }


    public Optional<Endereco> endereco(@PathVariable Long id){
        return  enderecoRepository.findById(id);
    }


    public Endereco save(@RequestBody Endereco endereco){
        return enderecoRepository.save(endereco);
    }


    public void enderecoDelete(@PathVariable Long id){
        enderecoRepository.deleteById(id);
    }


    public Optional<Endereco> editar(@RequestBody Endereco endereco, @PathVariable Long id){
        return enderecoRepository.findById(id).map(e -> {
            e.setRua(endereco.getRua());
            e.setCidade(endereco.getCidade());
            e.setEstado(endereco.getEstado());
            e.setTipo(endereco.getTipo());
            e.setUf(endereco.getUf());
            return enderecoRepository.save(e);
        });

    }

}
