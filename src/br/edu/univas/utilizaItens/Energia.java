package br.edu.univas.utilizaItens;

import br.edu.univas.interfaces.RecuperadorItem;
import br.edu.univas.models.Habilidade;
import br.edu.univas.models.Item;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.HabilidadeService;

public class Energia implements RecuperadorItem {

    @Override
    public void utilizarItem(Personagem personagem, Item item) {
        HabilidadeService habilidadeService = new HabilidadeService();
        Habilidade habilidade = habilidadeService.retornarHabilidadeAtiva(personagem);
        if (habilidade == null) {
            Double energia = personagem.getEnergia() + item.getEnergiaRecuperada();
            if (energia > 100D) {
                personagem.setEnergia(100D);
            } else {
                personagem.setEnergia(energia);
            }
            personagem.getItens().remove(item);
            System.out.println("Seu personagem recuperou as energias. Sua energia atual: " + personagem.getEnergia());
        } else {
            Double percentualDeEnergia = (habilidade.getPercentualEnergia() / 100D);
            Double energiaComPercentual = personagem.getEnergia()
                    + (item.getEnergiaRecuperada() + (item.getEnergiaRecuperada() * percentualDeEnergia));
            if (energiaComPercentual > 100D) {
                personagem.setEnergia(100D);
            } else {
                personagem.setEnergia(energiaComPercentual);
            }
            personagem.getItens().remove(item);
            System.out.println("Seu personagem recuperou as energias. Sua energia atual: " + personagem.getEnergia());
        }

    }

}