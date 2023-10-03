package com.example.victor.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String nomeEmpresa;
    String cargo;
    LocalDateTime periodoInicio;
    LocalDateTime periodoFim;

    String formaContratacao;
    String tarefaExecutada;

    @ManyToOne
    private Candidato candidato;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDateTime getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(LocalDateTime periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public LocalDateTime getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(LocalDateTime periodoFim) {
        this.periodoFim = periodoFim;
    }

    public String getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(String formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public String getTarefaExecutada() {
        return tarefaExecutada;
    }

    public void setTarefaExecutada(String tarefaExecutada) {
        this.tarefaExecutada = tarefaExecutada;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
}
