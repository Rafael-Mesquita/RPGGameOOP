package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.MissaoService;
import br.edu.univas.services.PersonagemService;

public class PersonagemView {

    private PersonagemService personagemService;

    public PersonagemView() {
        personagemService = new PersonagemService();
    }

    public void interagirComItem(Scanner scanner, Personagem personagem) {
        boolean continuar = true;
        do {
            System.out.println("1- Imprimir item(ns)");
            System.out.println("2- Usar item");
            System.out.println("3- Detalhar Item");
            System.out.println("0- Retornar");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1": {
                    personagemService.imprimirItensMap(personagem);
                    break;
                }
                case "2": {
                    personagemService.escolherItemParaUso(scanner, personagem);
                    break;
                }
                case "3": {
                    personagemService.escolherItemParaDetalhar(scanner, personagem);
                    break;
                }
                case "0": {
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

    public void interagirComHabilidade(Scanner scanner, Personagem personagem) {
        boolean continuar = true;
        do {
            System.out.println("1- Imprimir habilidade(s)");
            System.out.println("2- Usar habilidade");
            System.out.println("3- Detalhar habilidade");
            System.out.println("0- Retornar");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1": {
                    personagemService.imprimirHabilidadesMap(personagem);
                    break;
                }
                case "2": {
                    personagemService.escolherHabilidadeParaUso(scanner, personagem);
                    break;
                }
                case "3": {
                    personagemService.escolherHabilidadeParaDetalhar(scanner, personagem);
                    break;
                }
                case "0": {
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

    public void imprimirStatus(Personagem personagem) {
        personagemService.imprimirStatus(personagem);
    }

    public void caminhar(Scanner scanner, Personagem personagem, MundoVirtual mundoVirtual) {
        System.out.println("Digite o X");
        Integer x = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o Y");
        Integer y = scanner.nextInt();
        scanner.nextLine();
        personagemService.caminhar(scanner, personagem, x, y, mundoVirtual);
    }

    public void interagirComMissao(Scanner scanner, Personagem personagem) {
        boolean continuar = true;
        do {
            System.out.println("1- Detalhar Missão");
            System.out.println("0- Retornar");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1": {
                    MissaoService missaoService = new MissaoService();
                    missaoService.detalharMissao(personagem);
                    break;
                }
                case "0": {
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