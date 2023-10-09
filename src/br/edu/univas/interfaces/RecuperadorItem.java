package br.edu.univas.interfaces;

import br.edu.univas.models.Item;
import br.edu.univas.models.Personagem;

public interface RecuperadorItem {
    void utilizarItem(Personagem personagem, Item item);
}