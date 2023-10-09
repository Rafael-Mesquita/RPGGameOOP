package br.edu.univas.models;

import java.util.List;
import java.util.Random;

public class MundoVirtual {
    private RPG[][] mapaRPG;
    private Personagem personagem;
    private List<Inimigo> inimigos;
    private List<Item> itens;
    private List<Missao> missoes;
    private List<Habilidade> habilidades;

    public MundoVirtual(Integer x, Integer y, Personagem personagem, List<Inimigo> inimigos, List<Item> itens,
                        List<Missao> missoes, List<Habilidade> habilidades) {
        this.mapaRPG = new RPG[x][y];
        this.personagem = personagem;
        this.inimigos = inimigos;
        this.itens = itens;
        this.missoes = missoes;
        this.setHabilidades(habilidades);
        embaralharMundoVirtual();
    }

    public RPG[][] getMapaRPG() {
        return mapaRPG;
    }

    public void setMapaRPG(RPG[][] mapaRPG) {
        this.mapaRPG = mapaRPG;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public List<Inimigo> getInimigos() {
        return inimigos;
    }

    public void setInimigos(List<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<Missao> missoes) {
        this.missoes = missoes;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    private void embaralharMundoVirtual() {
        // Coloca o personagem na posição (0, 0)
        mapaRPG[0][0] = personagem;
        personagem.setLinha(0);
        personagem.setColuna(0);

        // Embaralha os inimigos, missões e itens
        for (Inimigo inimigo : inimigos) {
            Integer[] inimigoCoordenadas = posicionarAleatoriamente(inimigo);
            inimigo.setLinha(inimigoCoordenadas[0]);
            inimigo.setColuna(inimigoCoordenadas[1]);
        }
        for (Missao missao : missoes) {
            Integer[] missaoCoordenadas = posicionarAleatoriamente(missao);
            missao.setLinha(missaoCoordenadas[0]);
            missao.setColuna(missaoCoordenadas[1]);
        }
        for (Item item : itens) {
            Integer[] itemCoordenadas = posicionarAleatoriamente(item);
            item.setLinha(itemCoordenadas[0]);
            item.setColuna(itemCoordenadas[1]);
        }

        for(Habilidade habilidade : habilidades) {
            Integer[] habilidadeCoordernadas = posicionarAleatoriamente(habilidade);
            habilidade.setLinha(habilidadeCoordernadas[0]);
            habilidade.setColuna(habilidadeCoordernadas[1]);
        }
    }

    public Integer[] posicionarAleatoriamente(RPG rpg) {
        Random random = new Random();
        int linha, coluna;
        do {
            linha = random.nextInt(mapaRPG.length - 1) + 1;
            coluna = random.nextInt(mapaRPG[0].length - 1) + 1;
        } while (mapaRPG[linha][coluna] != null);
        mapaRPG[linha][coluna] = rpg;
        return new Integer[] {linha, coluna};
    }

    public void imprimirMapaVirtual() {
        System.out.print("  ");
        for (int i = 0; i < mapaRPG[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < mapaRPG.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < mapaRPG[i].length; j++) {
                if (mapaRPG[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(mapaRPG[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}