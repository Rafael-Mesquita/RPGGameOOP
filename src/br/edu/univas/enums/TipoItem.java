package br.edu.univas.enums;

import br.edu.univas.interfaces.AtaqueItem;
import br.edu.univas.interfaces.RecuperadorItem;
import br.edu.univas.utilizaItens.Dano;
import br.edu.univas.utilizaItens.Cura;
import br.edu.univas.utilizaItens.Energia;

public enum TipoItem {
    Dano(new Dano()), Cura(new Cura()), Energia(new Energia());

    private RecuperadorItem tipoItem;
    private AtaqueItem ataque;

    TipoItem(AtaqueItem ataque) {
        this.setAtaque(ataque);
    }

    TipoItem(RecuperadorItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public RecuperadorItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(RecuperadorItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public AtaqueItem getAtaque() {
        return ataque;
    }

    public void setAtaque(AtaqueItem ataque) {
        this.ataque = ataque;
    }
}