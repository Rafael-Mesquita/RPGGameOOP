package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.models.Habilidade;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.HabilidadeService;

public class HabilidadeView {

    private HabilidadeService habilidadeService;

    public HabilidadeView() {
        habilidadeService = new HabilidadeService();
    }

    public void interagirComHabilidade(Scanner scanner, MundoVirtual mundoVirtual, Personagem personagem, Habilidade habilidade) {
        Boolean continuar = true;
        do {
            habilidadeService.descreverHabilidade(habilidade, "encontrou");
            System.out.println("1- Pegá-la");
            System.out.println("2- Ignorá-la");
            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1": {
                    habilidadeService.pegarHabilidade(mundoVirtual, personagem, habilidade);
                    break;
                }
                case "2": {
                    continuar = false;
                    break;
                }
                default: {
                    System.out.println("Escolha incorreta!");
                    System.out.println();
                }
            }
        } while (continuar);

    }
}