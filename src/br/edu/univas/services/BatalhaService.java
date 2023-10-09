package br.edu.univas.services;

import java.util.Scanner;

import br.edu.univas.enums.TipoItem;
import br.edu.univas.models.Inimigo;
import br.edu.univas.models.Item;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;

public class BatalhaService {
    private PersonagemService personagemService;
    private InimigoService inimigoService;

    public BatalhaService() {
        this.personagemService = new PersonagemService();
        this.inimigoService = new InimigoService();
    }

    public void imprimirStatus(Personagem personagem) {
        personagemService.imprimirStatus(personagem);
    }

    public void imprimirStatus(Inimigo inimigo) {
        inimigoService.imprimirStatus(inimigo);
    }

    public void iniciarBatalha(Personagem personagem, Inimigo inimigo) {
        atacarInimigo(personagem, inimigo);
        atacarPersonagem(personagem, inimigo);
    }

    public void finalizarBatalha(MundoVirtual mundoVirtual, Personagem personagem, Inimigo inimigo) {
        mundoVirtual.getMapaRPG()[personagem.getLinha()][personagem.getColuna()] = null;
        mundoVirtual.getMapaRPG()[inimigo.getLinha()][inimigo.getColuna()] = null;
        mundoVirtual.getMapaRPG()[inimigo.getLinha()][inimigo.getColuna()] = personagem;
        personagem.setLinha(inimigo.getLinha());
        personagem.setColuna(inimigo.getColuna());
        personagem.setNivel(personagem.getNivel() + 1);
        System.out.println("Você derrotou o inimigo!");
        System.out.println();
    }

    public void atacarInimigo(Personagem personagem, Inimigo inimigo) {
        personagemService.imprimirItensIndex(personagem);
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual item deseja usar?");
        Integer index = scanner.nextInt();
        Item item = personagem.getItens().get(index - 1);
        if (item.getTipo().equals(TipoItem.Dano)) {
            personagemService.atacar(personagem, inimigo, index);
        } else {
            personagemService.usarItem(personagem, index);
        }
    }

    public void atacarPersonagem(Personagem personagem, Inimigo inimigo) {
        inimigoService.atacar(personagem, inimigo);
    }
}