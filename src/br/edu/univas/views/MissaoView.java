package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.models.Missao;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.MissaoService;

public class MissaoView {

    private MissaoService missaoService;

    public MissaoView() {
        missaoService = new MissaoService();
    }

    public void interagirComMissao(Scanner scanner, MundoVirtual mundoVirtual, Personagem personagem, Missao missao) {
        if (missao.getStatus()) {
            if (missao.getObjetivos().size() == 0) {
                System.out.println("Parabéns, você concluiu sua missão!");
                missaoService.concluirMissao(mundoVirtual, personagem, missao);
            } else {
                System.out.println("Ainda restam " + (missao.getObjetivos().size())
                        + " inimigos('A') para resgatar suas recompensas!");
                System.out.println();
            }
        } else {
            Boolean continuar = true;
            do {
                missaoService.descreverMissao(missao);
                System.out.println("1- Começa-la");
                System.out.println("2- Ignorá-la");
                String escolha = scanner.nextLine();

                switch (escolha) {
                    case "1": {
                        missaoService.comecarMissao(mundoVirtual, personagem, missao);
                        continuar = false;
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

}