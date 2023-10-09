package br.edu.univas.services;

import br.edu.univas.models.Inimigo;
import br.edu.univas.models.Item;
import br.edu.univas.models.Personagem;

public class InimigoService {
    public void atacar(Personagem personagem, Inimigo inimigo) {
        Item itemInimigo = inimigo.getItem();
        itemInimigo.getTipo().getAtaque().atacarPersonagem(personagem, inimigo);
    }

    public void imprimirStatus(Inimigo inimigo) {
        System.out.println("Nível: " + inimigo.getNivel());
        System.out.println("Saúde: " + inimigo.getSaude());
        System.out.println();
    }

    public void descreverInimigo(Inimigo inimigo) {
        System.out.println("Nome: " + inimigo.getNome());
        System.out.println("Nível: " + inimigo.getNivel());
        System.out.println("Saúde: " + inimigo.getSaude());
        System.out.println("Item empunhado: " + inimigo.getItem().getNome());
        System.out.println();
    }
}