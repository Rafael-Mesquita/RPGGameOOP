package br.edu.univas.models;

import java.util.Scanner;

import br.edu.univas.views.InimigoView;

public class Inimigo implements RPG {
    private String simbolo;
    private String nome;
    private Integer nivel;
    private Double saude;
    private Item item;
    private Integer linha;
    private Integer coluna;

    public Inimigo(String nome, Integer nivel, Double saude, Item item) {
        this.simbolo = "A";
        this.nome = nome;
        this.nivel = nivel;
        this.saude = saude;
        this.item = item;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        new InimigoView().interagirComInimigo(scanner, mundoVirtual, personagem, this);
    }

}