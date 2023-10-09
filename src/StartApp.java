
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.univas.enums.TipoItem;
import br.edu.univas.models.Habilidade;
import br.edu.univas.models.Inimigo;
import br.edu.univas.models.Item;
import br.edu.univas.models.Missao;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;
import br.edu.univas.views.PersonagemView;

public class StartApp {
    public static void main(String[] args) {

        Habilidade habilidadePersonagem = new Habilidade("Energetico",
                "Essa habilidade lhe concede um percentual de 25% de dano extra!", 10D, 0D, 0.025, 0D);
        List<Habilidade> habilidadePersonagemList = new ArrayList<>();
        habilidadePersonagemList.add(habilidadePersonagem);

        Item itemPersonagem = new Item("Espada Celestial", "Espada benzida pelo papa!", TipoItem.Dano, 0D, 25D, 10D, 0D,
                false);
        Item itemPersonagem2 = new Item("Cura Celestial", "cura benzida pelo papa!", TipoItem.Cura, 45D, 0D, 10D, 0D,
                false);
        Item itemInimigo = new Item("Espada Celestial", "Espada benzida pelo papa!", TipoItem.Dano, 0D, 10D, 10D, 0D,
                false);
        List<Item> itemPersonagemList = new ArrayList<>();
        itemPersonagemList.add(itemPersonagem);
        itemPersonagemList.add(itemPersonagem2);
        Personagem personagem = new Personagem("Rafael", habilidadePersonagemList, itemPersonagemList);

        List<Inimigo> inimigoMundoList = new ArrayList<>();
        Inimigo inimigoMundo = new Inimigo("Zombie", 1, 100D, itemInimigo);
        inimigoMundoList.add(inimigoMundo);

        List<Missao> missaoList = new ArrayList<>();
        Missao missao = new Missao("Caverna", "Mate os inimigos próximos a caverna", itemPersonagemList,
                inimigoMundoList);
        missaoList.add(missao);

        MundoVirtual mundoVirtual = new MundoVirtual(10, 10, personagem, inimigoMundoList, itemPersonagemList,
                missaoList, habilidadePersonagemList);

        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);
        do {
            mundoVirtual.imprimirMapaVirtual();
            System.out.println();
            System.out.println("1 - Caminhar");
            System.out.println("2 - Status (Nível, Saúde, Energia)");
            System.out.println("3 - Meus Itens");
            System.out.println("4 - Minhas Habilidades");
            System.out.println("5 - Detalhes da Missão");
            System.out.println("0 - Desistir");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1": {
                    new PersonagemView().caminhar(scanner, personagem, mundoVirtual);
                    break;
                }
                case "2": {
                    new PersonagemView().imprimirStatus(personagem);
                    break;
                }
                case "3": {
                    new PersonagemView().interagirComItem(scanner, personagem);
                    break;
                }
                case "4": {
                    new PersonagemView().interagirComHabilidade(scanner, personagem);
                    break;
                }
                case "5": {
                    new PersonagemView().interagirComMissao(scanner, personagem);
                    break;
                }
                case "0": {
                    continuar = false;
                    break;
                }
                default: {
                    System.out.println("Escolha errada!");
                    break;
                }
            }

        } while (continuar);
        scanner.close();
    }
}