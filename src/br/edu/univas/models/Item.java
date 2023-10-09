package br.edu.univas.models;

import java.util.Scanner;

import br.edu.univas.enums.TipoItem;
import br.edu.univas.views.ItemView;

public class Item implements RPG {
    private String simbolo;
    private String nome;
    private String descricao;
    private TipoItem tipo;
    private Double cura;
    private Double dano;
    private Double energiaConsumida;
    private Double energiaRecuperada;
    private Boolean itemDeMissao;
    private Integer linha;
    private Integer coluna;

    public Item(String nome, String descricao, TipoItem tipo, Double cura, Double dano, Double energiaConsumida,
                Double energiaRecuperada, Boolean itemDeMissao) {
        this.simbolo = "I";
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.cura = cura;
        this.dano = dano;
        this.energiaConsumida = energiaConsumida;
        this.energiaRecuperada = energiaRecuperada;
        this.itemDeMissao = itemDeMissao;
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

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public Double getCura() {
        return cura;
    }

    public void setCura(Double cura) {
        this.cura = cura;
    }

    public Double getDano() {
        return dano;
    }

    public void setDano(Double dano) {
        this.dano = dano;
    }

    public Double getEnergiaConsumida() {
        return energiaConsumida;
    }

    public void setEnergiaConsumida(Double energiaConsumida) {
        this.energiaConsumida = energiaConsumida;
    }

    public Double getEnergiaRecuperada() {
        return energiaRecuperada;
    }

    public void setEnergiaRecuperada(Double energiaRecuperada) {
        this.energiaRecuperada = energiaRecuperada;
    }

    public Boolean getItemDeMissao() {
        return itemDeMissao;
    }

    public void setItemDeMissao(Boolean itemDeMissao) {
        this.itemDeMissao = itemDeMissao;
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
        new ItemView().interagirComItem(scanner, mundoVirtual, personagem, this);
    }

}