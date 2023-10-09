package br.edu.univas.models;

import java.util.List;
import java.util.Scanner;

public class Personagem implements RPG {
    private String simbolo;
    private String nome;
    private Integer nivel;
    private Double saude;
    private Double energia;
    private List<Habilidade> habilidades;
    private List<Item> itens;
    private Missao missao;
    private Integer linha;
    private Integer coluna;

    public Personagem(String nome, List<Habilidade> habilidades, List<Item> itens) {
        this.simbolo = "P";
        this.nome = nome;
        this.nivel = 1;
        this.saude = 100D;
        this.energia = 100D;
        this.habilidades = habilidades;
        this.itens = itens;
        this.missao = null;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Double getSaude() {
        return saude;
    }

    public void setSaude(Double saude) {
        this.saude = saude;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        this.energia = energia;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
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
        /*
         * Não existe uma interação específica com o Personagem.
         */
    }

}