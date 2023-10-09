package br.edu.univas.services;

import br.edu.univas.models.Item;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;

public class ItemService {

    public void pegarItem(MundoVirtual mundoVirtual, Personagem personagem, Item item) {
        if (item.getItemDeMissao()) {
            personagem.getItens().add(item);
            descreverItem(item, "pegou");
        } else {
            personagem.getItens().add(item);
            System.out.println("Você pegou o item: " + item.getNome());
            mundoVirtual.getMapaRPG()[personagem.getLinha()][personagem.getColuna()] = null;
            mundoVirtual.getMapaRPG()[item.getLinha()][item.getColuna()] = null;
            mundoVirtual.getMapaRPG()[item.getLinha()][item.getColuna()] = personagem;
            personagem.setLinha(item.getLinha());
            personagem.setColuna(item.getColuna());
        }
    }

    public void receberRecompensa(Personagem personagem, Item item) {
        personagem.getItens().add(item);
        System.out.println("Você recebeu a recompensa: " + item.getNome());
    }

    public void descreverItem(Item item, String descricao) {
        System.out.println("Você " + descricao + " o item: " + item.getNome());
        System.out.println("Sobre o item:" + item.getDescricao());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Dano: " + item.getDano());
        System.out.println("Cura: " + item.getCura());
        System.out.println("Energia consumida: " + item.getEnergiaConsumida());
        System.out.println("Energia recuperada: " + item.getEnergiaRecuperada());
        System.out.println();
    }
}