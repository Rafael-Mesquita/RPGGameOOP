package br.edu.univas.utilizaItens;

import br.edu.univas.interfaces.AtaqueItem;
import br.edu.univas.models.Habilidade;
import br.edu.univas.models.Inimigo;
import br.edu.univas.models.Item;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.HabilidadeService;

public class Dano implements AtaqueItem {

    @Override
    public void atacarInimigo(Personagem personagem, Inimigo inimigo, Item item) {
        Double energia = personagem.getEnergia() - item.getEnergiaConsumida();
        if (energia < 0) {
            System.out.println("Você não pode usar esse item pois, está sem energia!");
            System.out.println();
        } else {
            HabilidadeService habilidadeService = new HabilidadeService();
            Habilidade habilidade = habilidadeService.retornarHabilidadeAtiva(personagem);
            if (habilidade == null) {
                Double saudeInimigo = inimigo.getSaude() - item.getDano();
                if (item.getDano() > saudeInimigo) {
                    inimigo.setSaude(0D);
                    Double energiaPersonagem = personagem.getEnergia() - item.getEnergiaConsumida();
                    personagem.setEnergia(energiaPersonagem);
                } else {
                    inimigo.setSaude(saudeInimigo);
                    Double energiaPersonagem = personagem.getEnergia() - item.getEnergiaConsumida();
                    personagem.setEnergia(energiaPersonagem);
                }
                System.out.println("Você atacou o inimigo e o desferiu um dano de " + item.getDano() + " !");
                System.out.println();
            } else {
                Double percentualDeDano = (habilidade.getPercentualDano() / 100);
                Double danoComPercentual = item.getDano() + (item.getDano() * (percentualDeDano));
                if (danoComPercentual > inimigo.getSaude()) {
                    inimigo.setSaude(0D);
                    Double energiaPersonagem = personagem.getEnergia() - item.getEnergiaConsumida();
                    personagem.setEnergia(energiaPersonagem);
                } else {
                    Double saudeComPercentual = inimigo.getSaude() + danoComPercentual;
                    inimigo.setSaude(saudeComPercentual);
                    Double energiaPersonagem = personagem.getEnergia() - item.getEnergiaConsumida();
                    personagem.setEnergia(energiaPersonagem);
                }
                System.out.println("Você atacou o inimigo e o desferiu um ataque que causou " + item.getDano() + (item.getDano() * (habilidade.getPercentualDano() / 100)) + " de dano!");
                System.out.println();
            }
        }
    }

    @Override
    public void atacarPersonagem(Personagem personagem, Inimigo inimigo) {
        Double saudePersonagem = personagem.getSaude() - inimigo.getItem().getDano();
        if(inimigo.getItem().getDano() > personagem.getSaude()) {
            personagem.setSaude(0D);
        } else {
            personagem.setSaude(saudePersonagem);
        }
        System.out.println("O inimigo contra-atacou e o desferiu um ataque que lhe causou " + inimigo.getItem().getDano() + " de dano!");
        System.out.println();
    }
}