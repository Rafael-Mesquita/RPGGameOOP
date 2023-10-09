package br.edu.univas.services;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.univas.models.Inimigo;
import br.edu.univas.models.Item;
import br.edu.univas.models.Missao;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;

public class MissaoService {

    public void descreverMissao(Missao missao) {
        System.out.println("Título: " + missao.getTitulo());
        System.out.println("Descrição: " + missao.getDescricao());
        System.out.println("Recompensas: " + (missao.getRecompensas().stream().map(Item::getNome).collect(Collectors.joining(", "))));
        System.out.println("Objetivos (Inimigos): " + (missao.getObjetivos().stream().map(Inimigo::getNome).collect(Collectors.joining(", "))));
        System.out.println("Status: " + (missao.getStatus() ? "Ativada" : "Desativada"));
        System.out.println();
    }

    public void detalharMissao(Personagem personagem) {
        Missao missao = personagem.getMissao();
        if(missao == null) {
            System.out.println("Você não possuí nenhuma missão ativa!");
            System.out.println();
            return;
        } else {
            System.out.println("Título: " + missao.getTitulo());
            System.out.println("Descrição: " + missao.getDescricao());
            System.out.println("Recompensas: " + (missao.getRecompensas().stream().map(Item::getNome).collect(Collectors.joining(", "))));
            System.out.println("Objetivos (Inimigos): " + (missao.getObjetivos().stream().map(Inimigo::getNome).collect(Collectors.joining(", "))));
            System.out.println("Status: Ainda restam " + (missao.getObjetivos().size()) + " inimigos('A') para aniquilar!");
            System.out.println();
        }
    }

    public void comecarMissao(MundoVirtual mundoVirtual, Personagem personagem, Missao missao) {
        Missao missaoPersonagem = personagem.getMissao();
        if(missaoPersonagem != null) {
            System.out.println("Personagem já possuí uma missão ativa!");
            System.out.println();
            return;
        } else {
            personagem.setMissao(missao);
            missao.setStatus(true);
            for(Inimigo inimigoMissao : missao.getObjetivos()) {
                Integer[] inimigoCoordenadas = mundoVirtual.posicionarAleatoriamente(inimigoMissao);
                inimigoMissao.setLinha(inimigoCoordenadas[0]);
                inimigoMissao.setColuna(inimigoCoordenadas[1]);
            }
            System.out.println("Seus objetivos estão espalhados pelo mundo, após derrota-los, retorne para receber suas recompensas!");
            System.out.println();
        }

    }

    public void concluirMissao(MundoVirtual mundoVirtual, Personagem personagem, Missao missao) {
        List<Item> recompensas = missao.getRecompensas();
        for(Item recompensa : recompensas) {
            new ItemService().receberRecompensa(personagem, recompensa);
        }
        personagem.setMissao(null);
        mundoVirtual.getMissoes().remove(missao);
        mundoVirtual.getMapaRPG()[personagem.getLinha()][personagem.getColuna()] = null;
        mundoVirtual.getMapaRPG()[missao.getLinha()][missao.getColuna()] = null;
        mundoVirtual.getMapaRPG()[missao.getLinha()][missao.getColuna()] = personagem;
        personagem.setLinha(missao.getLinha());
        personagem.setColuna(missao.getColuna());
        System.out.println("Recompensas em sua mochila, busque novas aventuras!");
        System.out.println();
    }


}