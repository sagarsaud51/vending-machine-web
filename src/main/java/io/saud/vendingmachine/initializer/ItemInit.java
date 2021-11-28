package io.saud.vendingmachine.initializer;

import io.saud.vendingmachine.model.Item;

import java.util.List;

public class ItemInit {

//    "001",
//             Item("Coke",20D,5);
//        vendingMachine.addItem("002", new ItemDTO("FANTA",20D,5));
//        vendingMachine.addItem("003", new ItemDTO("SPRITE",20D,5));
//        vendingMachine.addItem("004", new ItemDTO("LAYS",20D,5));
//        vendingMachine.addItem("005", new ItemDTO("BEER",50D,5));
//        vendingMachine.addItem("006", new ItemDTO("MILK",20D,5));
//        vendingMachine.addItem("007", new ItemDTO("CHIPS",20D,5));
//        vendingMachine.addItem("008", new ItemDTO("Wine",20D,5));
//        vendingMachine.addItem("009", new ItemDTO("Banana",20D,5));
//        vendingMachine.addItem("010", new ItemDTO("CANDLE",20D,5));

    public static List<Item> itemSeeders() {
        return List.of(
                new Item("001", "Coke", 20D, 5),
                new Item("002", "FANTA", 20D, 5),
                new Item("003", "SPRITE", 20D, 5),
                new Item("004", "LAYS", 20D, 5),
                new Item("005", "BEER", 50D, 5),
                new Item("006", "MILK", 20D, 5),
                new Item("007", "CHIPS", 20D, 5),
                new Item("008", "Wine", 75D, 5),
                new Item("009", "Banana", 5D, 5),
                new Item("010", "CANDLE", 2D, 5)
        );
    }
}
