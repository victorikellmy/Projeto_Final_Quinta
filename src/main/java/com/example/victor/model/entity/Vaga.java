package com.example.victor.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Vaga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String cargo;
    String descricao;
    String contracao;
    String remuneracao;

    @OneToMany(mappedBy = "vaga")
    private List<Candidato> candidatos;

    @OneToMany(mappedBy = "vaga")
    private List<Empresa> empresas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContracao() {
        return contracao;
    }

    public void setContracao(String contracao) {
        this.contracao = contracao;
    }

    public String getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(String remuneracao) {
        this.remuneracao = remuneracao;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}