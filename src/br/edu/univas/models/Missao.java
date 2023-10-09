package br.edu.univas.models;

import java.util.List;
import java.util.Scanner;

import br.edu.univas.views.MissaoView;

public class Missao implements RPG {
    private String simbolo;
    private String titulo;
    private String descricao;
    private List<Item> recompensas;
    private List<Inimigo> objetivos;
    private Boolean status;
    private Integer linha;
    private Integer coluna;

    public Missao(String titulo, String descricao, List<Item> recompensas, List<Inimigo> objetivos) {
        this.simbolo = "M";
        this.titulo = titulo;
        this.descricao = descricao;
        this.recompensas = recompensas;
        this.objetivos = objetivos;
        this.status = false;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Item> getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(List<Item> recompensas) {
        this.recompensas = recompensas;
    }

    public List<Inimigo> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(List<Inimigo> objetivos) {
        this.objetivos = objetivos;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        return this.getSimbolo();
    }

    @Override
    public void interagirCom(Scanner scanner, MundoVirtual mundoVirtual, Personagem personagem) {
        new MissaoView().interagirComMissao(scanner, mundoVirtual, personagem, this);
    }
}