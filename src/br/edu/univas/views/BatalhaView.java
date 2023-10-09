package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.models.Inimigo;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.BatalhaService;

public class BatalhaView {

    private BatalhaService batalhaService;

    public BatalhaView() {
        this.batalhaService = new BatalhaService();
    }

    public void batalhar(Scanner scanner, MundoVirtual mundoVirtual, Personagem personagem, Inimigo inimigo) {
        boolean continuar = true;
        do {
            boolean continuarBatalhando = true;

            if (inimigo.getSaude() <= 0D) {
                batalhaService.finalizarBatalha(mundoVirtual, personagem, inimigo);
                continuarBatalhando = false;
                continuar = false;
            }

            while (personagem.getSaude() > 0D && inimigo.getSaude() > 0D && continuarBatalhando) {

                imprimirMenuDeBatalha();
                String escolha = scanner.nextLine();

                switch (escolha) {
                    case "1": {
                        batalhaService.iniciarBatalha(personagem, inimigo);
                        break;
                    }
                    case "2": {
                        batalhaService.imprimirStatus(personagem);
                        break;
                    }
                    case "3": {
                        batalhaService.imprimirStatus(inimigo);
                        break;
                    }
                    case "4": {
                        continuar = false;
                        continuarBatalhando = false;
                        System.out.println("Você desistiu da batalha");
                        System.out.println();
                        break;
                    }
                    default: {
                        System.out.println("Escolha incorreta!");
                        System.out.println();
                    }
                }

            }
        } while (continuar);

    }

    private void imprimirMenuDeBatalha() {
        System.out.println("1 - Atacar");
        System.out.println("2 - Meu Status");
        System.out.println("3 - Status Inimigo");
        System.out.println("4 - Desistir");
        System.out.println();
    }
}