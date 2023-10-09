package br.edu.univas.services;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.edu.univas.enums.TipoItem;
import br.edu.univas.models.Habilidade;
import br.edu.univas.models.Inimigo;
import br.edu.univas.models.Item;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;
import br.edu.univas.models.RPG;

public class PersonagemService {

    public void caminhar(Scanner scanner, Personagem personagem, Integer novaLinha, Integer novaColuna,
                         MundoVirtual mundoVirtual) {

        // Verifique se o movimento é válido (não mais do que 1 linha/coluna de
        // distância)
        if (Math.abs(personagem.getLinha() - novaLinha) > 1 || Math.abs(personagem.getColuna() - novaColuna) > 1) {
            System.out.println("Movimento inválido!");
            return;
        }

        // Verifique se a nova posição está dentro dos limites do mapa
        if (novaLinha < 0 || novaLinha >= mundoVirtual.getMapaRPG().length || novaColuna < 0
                || novaColuna >= mundoVirtual.getMapaRPG()[0].length) {
            System.out.println("Movimento fora dos limites do mapa!");
            return;
        }

        // Verifique se a nova posição está ocupada
        RPG objetoNaNovaPosicao = mundoVirtual.getMapaRPG()[novaLinha][novaColuna];
        if (objetoNaNovaPosicao != null) {
            objetoNaNovaPosicao.interagirCom(scanner, mundoVirtual, personagem);
        } else {
            // Mova o personagem para a nova posição
            mundoVirtual.getMapaRPG()[personagem.getLinha()][personagem.getColuna()] = null;
            mundoVirtual.getMapaRPG()[novaLinha][novaColuna] = personagem;
            personagem.setLinha(novaLinha);
            personagem.setColuna(novaColuna);
        }

    }

    public void imprimirItensMap(Personagem personagem) {
        List<Item> itens = personagem.getItens();
        String itensNomes = itens.stream().map(Item::getNome).collect(Collectors.joining(", "));

        System.out.println("Seu(s) item(ns): " + itensNomes);
        System.out.println();
    }

    public void imprimirItensIndex(Personagem personagem) {
        List<Item> itens = personagem.getItens();
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + " - " + itens.get(i).getNome());
        }
        System.out.println();
    }

    public void imprimirHabilidadesMap(Personagem personagem) {
        List<Habilidade> habilidades = personagem.getHabilidades();
        String habilidadesNomes = habilidades.stream().map(Habilidade::getNome).collect(Collectors.joining(", "));

        System.out.println("Sua(s) habilidade(s): " + habilidadesNomes);
        System.out.println();
    }

    public void imprimirHabilidadesIndex(Personagem personagem) {
        List<Habilidade> habilidades = personagem.getHabilidades();
        for (int i = 0; i < habilidades.size(); i++) {
            System.out.println((i + 1) + " - " + habilidades.get(i).getNome());
        }
        System.out.println();
    }

    public void usarItem(Personagem personagem, Integer index) {
        List<Item> itens = personagem.getItens();
        Item itemEscolhido = itens.get(index - 1);
        if(itemEscolhido.getTipo().equals(TipoItem.Dano)) {
            System.out.println("Você não pode utilizar um item do tipo Dano!");
            System.out.println();
            return;
        }
        itemEscolhido.getTipo().getTipoItem().utilizarItem(personagem, itemEscolhido);
    }

    public void atacar(Personagem personagem, Inimigo inimigo, Integer index) {
        List<Item> itens = personagem.getItens();
        Item itemEscolhido = itens.get(index - 1);
        itemEscolhido.getTipo().getAtaque().atacarInimigo(personagem, inimigo, itemEscolhido);
    }

    public void detalharItem(Personagem personagem, Integer index) {
        List<Item> itens = personagem.getItens();
        Item itemEscolhido = itens.get(index - 1);
        ItemService itemService = new ItemService();
        itemService.descreverItem(itemEscolhido, "detalhou");
    }

    public void detalharHabilidade(Personagem personagem, Integer index) {
        List<Habilidade> habilidades = personagem.getHabilidades();
        Habilidade habilidadeEscolhida = habilidades.get(index - 1);
        HabilidadeService habilidadeService = new HabilidadeService();
        habilidadeService.descreverHabilidade(habilidadeEscolhida, "detalhou");
    }

    public void usarHabilidade(Scanner scanner, Personagem personagem, Integer index) {
        HabilidadeService habilidadeService = new HabilidadeService();
        Habilidade habilidadeAtivada = habilidadeService.retornarHabilidadeAtiva(personagem);
        if (habilidadeAtivada != null) {
            System.out.println("Você possui à habilidade ativa: " + habilidadeAtivada.getNome());
            System.out.println("Deseja substituir pela nova habilidade? (S/N)");
            String escolha = scanner.nextLine();
            if (escolha.equalsIgnoreCase("S")) {
                List<Habilidade> habilidades = personagem.getHabilidades();
                Habilidade habilidadeEscolhida = habilidades.get(index - 1);
                for (Habilidade habilidade : habilidades) {
                    if (habilidade.equals(habilidadeEscolhida)) {
                        habilidade.setStatus(true);
                        break;
                    }
                }
                System.out.println("Você ativou a habilidade: " + habilidadeEscolhida.getNome() + "!");
                System.out.println();
            } else {
                System.out.println("Você manteve a habilidade: " + habilidadeAtivada.getNome() + " ativada!");
                System.out.println();
                return;
            }
        } else {
            List<Habilidade> habilidades = personagem.getHabilidades();
            Habilidade habilidadeEscolhida = habilidades.get(index - 1);
            for (Habilidade habilidade : habilidades) {
                if (habilidade.equals(habilidadeEscolhida)) {
                    habilidade.setStatus(true);
                    break;
                }
            }
            System.out.println("Você ativou a habilidade: " + habilidadeEscolhida.getNome() + "!");
            System.out.println();
        }
    }

    public void escolherItemParaUso(Scanner scanner, Personagem personagem) {
        imprimirItensIndex(personagem);
        System.out.println("Qual item deseja usar?");
        Integer index = scanner.nextInt();
        scanner.nextLine();
        usarItem(personagem, index);
    }

    public void escolherItemParaDetalhar(Scanner scanner, Personagem personagem) {
        imprimirItensIndex(personagem);
        System.out.println("Qual item deseja detalhar?");
        Integer index = scanner.nextInt();
        scanner.nextLine();
        detalharItem(personagem, index);
    }

    public void escolherHabilidadeParaUso(Scanner scanner, Personagem personagem) {
        imprimirHabilidadesIndex(personagem);
        System.out.println("Qual habilidade deseja usar?");
        Integer index = scanner.nextInt();
        scanner.nextLine();
        usarHabilidade(scanner, personagem, index);
    }

    public void escolherHabilidadeParaDetalhar(Scanner scanner, Personagem personagem) {
        imprimirHabilidadesIndex(personagem);
        System.out.println("Qual habilidade deseja detalhar?");
        Integer index = scanner.nextInt();
        scanner.nextLine();
        detalharHabilidade(personagem, index);
    }

    public void imprimirStatus(Personagem personagem) {
        System.out.println("Nível: " + personagem.getNivel());
        System.out.println("Saúde: " + personagem.getSaude());
        System.out.println("Energia: " + personagem.getEnergia());
        System.out.println();
    }

}