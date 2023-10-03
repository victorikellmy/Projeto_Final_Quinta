package com.example.victor.controller;

import com.example.victor.model.entity.Vaga;
import com.example.victor.model.repository.VagaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("vagas")
public class VagaController {

    @Autowired
    VagaRepository vagaRepository;

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("vaga", vagaRepository.vagas());
        return "/vaga/list";
    }

    @GetMapping("/form")
    public String form(Vaga vaga) {
        return "/vaga/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Vaga vaga) {
        vagaRepository.save(vaga);
        return new ModelAndView("redirect:/vagas/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        vagaRepository.remove(id);
        return new ModelAndView("redirect:/vagas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("vaga", vagaRepository.vaga(id));
        return new ModelAndView("/vaga/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Vaga vaga) {
        vagaRepository.update(vaga);
        return new ModelAndView("redirect:/vagas/list");
    }
}
