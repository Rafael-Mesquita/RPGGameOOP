package br.edu.univas.interfaces;

import br.edu.univas.models.Inimigo;
import br.edu.univas.models.Item;
import br.edu.univas.models.Personagem;

public interface AtaqueItem {
    void atacarInimigo(Personagem personagem, Inimigo inimigo, Item item);
    void atacarPersonagem(Personagem personagem, Inimigo inimigo);
}