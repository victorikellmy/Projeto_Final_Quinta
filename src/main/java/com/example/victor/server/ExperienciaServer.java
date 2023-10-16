package com.example.victor.server;

import com.example.victor.model.entity.Experiencia;
import com.example.victor.model.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaServer {
    @Autowired
    ExperienciaRepository experienciaRepository;

    @GetMapping
    public List<Experiencia> experiencias(){
        return experienciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Experiencia> experiencia(@PathVariable Long id){
        return  experienciaRepository.findById(id);
    }

    @PostMapping
    public Experiencia save(@RequestBody Experiencia experiencia){
        return experienciaRepository.save(experiencia);
    }

    @DeleteMapping("/{id}")
    public void experienciaDelete(@PathVariable Long id){
        experienciaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Experiencia> editar(@RequestBody Experiencia experiencia, @PathVariable Long id){
        return experienciaRepository.findById(id).map(e -> {
            e.setNomeEmpresa(experiencia.getNomeEmpresa());
            e.setCargo(experiencia.getCargo());
            e.setPeriodoInicio(experiencia.getPeriodoInicio());
            e.setPeriodoFim(experiencia.getPeriodoFim());
            e.setFormaContratacao(experiencia.getFormaContratacao());
            e.setTarefaExecutada(experiencia.getTarefaExecutada());
            var u = experienciaRepository.save(e);
            return u;
        });

    }

}
