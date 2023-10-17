package com.example.victor.server;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.victor.model.entity.Empresa;
import com.example.victor.model.repository.EmpresaRepository;


@Service
public class EmpresaServer {
    @Autowired
    private EmpresaRepository empresaRepository;

 

    public List<Empresa> empresas(){
        return  empresaRepository.findAll();

    }
    public Optional<Empresa> empresa(@PathVariable Long id){
        return empresaRepository.findById(id);
    }


    public Empresa save(@RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }


    public void empresaDeletar(@PathVariable Long id){
         empresaRepository.deleteById(id);
    }

    

    public Optional<Empresa> editar(@RequestBody Empresa empresa, @PathVariable Long id){
        return empresaRepository.findById(id).map(e -> {
            e.setNome(empresa.getNome());
            e.setDescricao(empresa.getDescricao());
            e.setCnpj(empresa.getCnpj());
            e.setEmail(empresa.getEmail());
            return empresaRepository.save(e);
        });
        
    }

    public List<Empresa>bucarPorNome(@PathVariable String nome){
        return  empresaRepository.findByNome(nome);
    }

    public List<Empresa>buscarPorEstado(@PathVariable String estado){
        return empresaRepository.findByEstado(estado);
    }
}
