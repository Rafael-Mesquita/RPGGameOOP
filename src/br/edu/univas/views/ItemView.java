package br.edu.univas.views;

import java.util.Scanner;

import br.edu.univas.models.Item;
import br.edu.univas.models.MundoVirtual;
import br.edu.univas.models.Personagem;
import br.edu.univas.services.ItemService;

public class ItemView {

    private ItemService itemService;

    public ItemView() {
        itemService = new ItemService();
    }

    public void interagirComItem(Scanner scanner, MundoVirtual mundoVirtual, Personagem personagem, Item item) {
        Boolean continuar = true;

        do {
            itemService.descreverItem(item, "encontrou");
            System.out.println("1- Pegá-lo");
            System.out.println("2- Ignorá-lo");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1": {
                    itemService.pegarItem(mundoVirtual, personagem, item);
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