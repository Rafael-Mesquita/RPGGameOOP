package br.edu.univas.models;

import java.util.Scanner;

import br.edu.univas.views.HabilidadeView;

public class Habilidade implements RPG {
    private String simbolo;
    private String nome;
    private String descricao;
    private Double custoEnergia;
    private Double percentualCura;
    private Double percentualDano;
    private Double percentualEnergia;
    private Boolean status;
    private Integer linha;
    private Integer coluna;

    public Habilidade(String nome, String descricao, Double custoEnergia, Double percentualCura, Double percentualDano,
                      Double percentualEnergia) {
        this.simbolo = "H";
        this.nome = nome;
        this.descricao = descricao;
        this.custoEnergia = custoEnergia;
        this.percentualCura = percentualCura;
        this.percentualDano = percentualDano;
        this.percentualEnergia = percentualEnergia;
        this.status = false;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCustoEnergia() {
        return custoEnergia;
    }

    public void setCustoEnergia(Double custoEnergia) {
        this.custoEnergia = custoEnergia;
    }

    public Double getPercentualCura() {
        return percentualCura;
    }

    public void setPercentualCura(Double percentualCura) {
        this.percentualCura = percentualCura;
    }

    public Double getPercentualDano() {
        return percentualDano;
    }

    public void setPercentualDano(Double percentualDano) {
        this.percentualDano = percentualDano;
    }

    public Double getPercentualEnergia() {
        return percentualEnergia;
    }

    public void setPercentualEnergia(Double percentualEnergia) {
        this.percentualEnergia = percentualEnergia;
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
        new HabilidadeView().interagirComHabilidade(scanner, mundoVirtual, personagem, this);
    }

}