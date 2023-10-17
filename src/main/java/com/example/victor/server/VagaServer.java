package com.example.victor.server;

import com.example.victor.model.entity.Experiencia;
import com.example.victor.model.entity.Vaga;
import com.example.victor.model.repository.ExperienciaRepository;
import com.example.victor.model.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
public class VagaServer {
    @Autowired
    VagaRepository vagaRepository;


    public List<Vaga> vagas(){
        return vagaRepository.findAll();
    }


    public Optional<Vaga> vaga(@PathVariable Long id){
        return  vagaRepository.findById(id);
    }


    public Vaga save(@RequestBody Vaga vaga){
        return vagaRepository.save(vaga);
    }


    public void vagaDelete(@PathVariable Long id){
        vagaRepository.deleteById(id);
    }


    public Optional<Vaga> editar(@RequestBody Vaga vaga, @PathVariable Long id){
        return vagaRepository.findById(id).map(v -> {
            v.setCandidatos(vaga.getCandidatos());
            v.setCargo(vaga.getCargo());
            v.setContracao(vaga.getContracao());
            v.setDescricao(vaga.getDescricao());
            v.setEmpresas(vaga.getEmpresas());
            v.setRemuneracao(vaga.getRemuneracao());
            return vagaRepository.save(v);
        });

    }

}
