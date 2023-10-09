package br.edu.univas.services;

import br.edu.univas.models.Habilidade;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;

public class HabilidadeService {

    public void pegarHabilidade(MundoVirtual mundoVirtual, Personagem personagem, Habilidade habilidade) {
        personagem.getHabilidades().add(habilidade);
        System.out.println("Você obteve a habilidade: " + habilidade.getNome());
        mundoVirtual.getMapaRPG()[personagem.getLinha()][personagem.getColuna()] = null;
        mundoVirtual.getMapaRPG()[habilidade.getLinha()][habilidade.getColuna()] = null;
        mundoVirtual.getMapaRPG()[habilidade.getLinha()][habilidade.getColuna()] = personagem;
        personagem.setLinha(habilidade.getLinha());
        personagem.setColuna(habilidade.getColuna());
    }

    public Habilidade retornarHabilidadeAtiva(Personagem personagem) {
        for(Habilidade habilidade : personagem.getHabilidades()) {
            if(habilidade.getStatus()) {
                return habilidade;
            }
        }
        return null;
    }

    public void descreverHabilidade(Habilidade habilidade, String descricao) {
        System.out.println("Você " + descricao + " a habilidade: " + habilidade.getNome());
        System.out.println("Sobre a habilidade:" + habilidade.getDescricao());
        System.out.println("Custo de Energia: " + habilidade.getCustoEnergia());
        System.out.println("Percentual de Dano: " + habilidade.getPercentualDano());
        System.out.println("Percentual de Cura: " + habilidade.getPercentualCura());
        System.out.println("Percentual Energia: " + habilidade.getPercentualEnergia());
        System.out.println("Status: " + (habilidade.getStatus() ? "Ativada" : "Desativado"));
        System.out.println();
    }

}