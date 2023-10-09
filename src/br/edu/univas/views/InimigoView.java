package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.models.Inimigo;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.InimigoService;

public class InimigoView {

    private InimigoService inimigoService;
    private BatalhaView batalhaView;

    public InimigoView() {
        inimigoService = new InimigoService();
        batalhaView = new BatalhaView();
    }

    public void interagirComInimigo(Scanner scanner, MundoVirtual mundoVirtual, Personagem personagem, Inimigo inimigo) {
        Boolean continuar = true;

        do {
            if (inimigo.getSaude() <= 0D) {
                continuar = false;
            } else {
                inimigoService.descreverInimigo(inimigo);
                System.out.println("1- Batalhar");
                System.out.println("2- Ignorá-lo");
                String escolha = scanner.nextLine();
                switch (escolha) {
                    case "1": {
                        batalhaView.batalhar(scanner, mundoVirtual, personagem, inimigo);
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
            }
        } while (continuar);
    }
}