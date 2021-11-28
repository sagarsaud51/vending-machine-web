package io.saud.vendingmachine.service;


import io.saud.vendingmachine.constants.MessageConstants;
import io.saud.vendingmachine.exception.VendingMachineException;
import io.saud.vendingmachine.service.abstracts.VendingMachineService;

import java.util.Scanner;

public class VendingProcessor {

    VendingMachineService vendingMachineService;
    Scanner scanner = new Scanner(System.in);

    //initialize vending machine with the items
//    public void init() {
//        vendingMachine = new WowVendingMachine();
////        ItemInitializer.addItemsInVendingMachine(vendingMachine);
//        handleUserInput();
//    }

    //handle user input
    private void handleUserInput() {
        //flag to check if user wants to exit
        boolean exit = false;
        while (!exit) {
            displayMenu();
            String userInput = scanner.nextLine();
            try {
                switch (userInput) {
                    case "1":
                        vendingMachineService.displayDevice.displayMessage("Enter amount to add cash");
                        vendingMachineService.loadCash(validateAmount(scanner.nextDouble()));
                        break;
                    case "2":
                        vendingMachineService.displayDevice.displayMessage("Enter the coin to add");
                        vendingMachineService.loadCoins(validateAmount(scanner.nextDouble()));
                        break;
                    case "3":
                        vendingMachineService.displayDevice.displayMessage("Enter the item code");
                        vendingMachineService.placeOrder(scanner.nextLine().trim().toUpperCase());

                        break;
                    case "4":
                        vendingMachineService.cancel();
                        break;
                    case "5":
                        if (vendingMachineService.getBalance() > 0) {
                            vendingMachineService.cancel();
                        }
                        exit = true;
                        terminateVendingMachine();
                    default:
                        vendingMachineService.displayDevice.displayMessage("Please enter a valid option");
                        break;
                }
            } catch (Exception e) {
                vendingMachineService.displayDevice.displayMessage("Please enter a valid input");
            }
            scanner = new Scanner(System.in); //to flush the scanner
            sleepForFewSeconds();

        }
    }

    //waiting for few seconds to display the message
    void sleepForFewSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //display menu
    private void displayMenu() {
        for (int i = 0; i < 500; i++) {
            vendingMachineService.displayDevice.displayMessage("\n");
        }
        vendingMachineService.displayDevice.displayMessage("--------------------------------------------------------");
        vendingMachineService.displayDevice.displayMessage(String.format("|            " + MessageConstants.WELCOME_MESSAGE + "           |"));
        vendingMachineService.displayDevice.displayMessage("--------------------------------------------------------");
        final StringBuilder[] itemMenu = {new StringBuilder("       ")};
        final StringBuilder[] qtyMenu = {new StringBuilder("       ")};
        final StringBuilder[] priceMenu = {new StringBuilder("      ")};
        final StringBuilder[] codeMenu = {new StringBuilder("       ")};
        final int[] i = {0};
        vendingMachineService.getCodeItemMapper().keySet().forEach(item -> {
            itemMenu[0].append(vendingMachineService.getCodeItemMapper().get(item).getName()).append("       ");
            qtyMenu[0].append("   ").append(vendingMachineService.getCodeItemMapper().get(item).getStock()).append("       ");
            priceMenu[0].append(" ").append(vendingMachineService.getCodeItemMapper().get(item).getAmount().toString()).append("      ");
            codeMenu[0].append(" ").append(item).append("       ");
            i[0]++;
            if (i[0] % 3 == 0) {
                vendingMachineService.displayDevice.displayMessage(itemMenu[0].toString());
                vendingMachineService.displayDevice.displayMessage(priceMenu[0].toString());
                vendingMachineService.displayDevice.displayMessage(qtyMenu[0].toString());
                vendingMachineService.displayDevice.displayMessage(codeMenu[0].toString());
                vendingMachineService.displayDevice.displayMessage("--------------------------------------------------------");
                itemMenu[0] = new StringBuilder("       ");
                priceMenu[0] = new StringBuilder("      ");
                qtyMenu[0] = new StringBuilder("      ");
                codeMenu[0] = new StringBuilder("       ");
            }
        });
        if (vendingMachineService.getBalance() > 0) {
            vendingMachineService.displayDevice.displayMessage("Balance:" + vendingMachineService.getBalance());
        }

        vendingMachineService.displayDevice.displayMessage("Press (1) to add cash (2) to add coins (3) to Place order (4) to refund (5) to terminate");
    }

    //check if double is 0 or less than zero
    private Double validateAmount(double amount) {
        if (amount > 0) return amount;
        else throw new VendingMachineException("Invalid amount");
    }

    private void terminateVendingMachine(){
        System.out.print("Terminating Vending Machine");
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("\nVending Machine Terminated");
        System.exit(-1);
    }
}
