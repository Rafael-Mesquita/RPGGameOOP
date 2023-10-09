package br.edu.univas.utilizaItens;

import br.edu.univas.interfaces.RecuperadorItem;
import br.edu.univas.models.Habilidade;
import br.edu.univas.models.Item;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.HabilidadeService;

public class Cura implements RecuperadorItem {

    @Override
    public void utilizarItem(Personagem personagem, Item item) {
        Double energia = personagem.getEnergia() - item.getEnergiaConsumida();
        if (energia < 0) {
            System.out.println("Você não pode usar esse item pois, está sem energia!");
            System.out.println();
        } else {
            HabilidadeService habilidadeService = new HabilidadeService();
            Habilidade habilidade = habilidadeService.retornarHabilidadeAtiva(personagem);
            if (habilidade == null) {
                Double saude = personagem.getSaude() + item.getCura();
                if (saude > 100) {
                    personagem.setSaude(100D);
                } else {
                    personagem.setSaude(saude);
                }
                personagem.setEnergia(energia);
                personagem.getItens().remove(item);
                System.out.println("Seu personagem foi curado. Sua saúde atual: " + personagem.getSaude());
                System.out.println();
            } else {
                Double percentualDeCura = (habilidade.getPercentualCura() / 100D);
                Double saudeComPercentual = personagem.getSaude()
                        + (item.getCura() + (item.getCura() * percentualDeCura));
                if(saudeComPercentual > 100) {
                    personagem.setSaude(100D);
                } else {
                    personagem.setSaude(saudeComPercentual);
                }
                personagem.setEnergia(energia);
                personagem.getItens().remove(item);
                System.out.println("Seu personagem foi curado. Sua saúde atual: " + personagem.getSaude());
                System.out.println();
            }
        }

    }

}