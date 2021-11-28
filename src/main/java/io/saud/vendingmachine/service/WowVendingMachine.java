package io.saud.vendingmachine.service;


//@Log4j2
//@Service
//@SuppressWarnings("all")
//public class WowVendingMachine extends VendingMachine {
public class WowVendingMachine {



//    private final String MACHINE_NAME = "WoW";
//
//    //Vending Machine with different Devices initialization
//    public WowVendingMachine() {
////        super(new CompanyABillInserterImpl(), new CompanyCCoinInserterImpl(), new CompanyBDisplayDeviceImpl());
//        machineName = MACHINE_NAME;
//    }
//
////
//    //add item to the vending machine
//    public void addItem(String code, Item item) {
//        if (doesCodeExists(code)) {
//            log.error("Item with code " + code + "already  exists for item" + getCodeItemMapper().get(code).getName());
//            return;
//        }
//        getCodeItemMapper().put(code.toUpperCase(), item);
//        log.info("Item " + item.getName() + " has been added with CODE: " + code);
//    }
//
//
//    public void addItem(Item item) {
//
//    }
//
//
//    //adding existing item stock to the vending machine
//    public void addExistingItem(String code, Integer quantity) {
//        if (!doesCodeExists(code)) {
//            log.error("Item with code " + code + "does not exists! Please add the item first!");
//            return;
//        }
//        getCodeItemMapper().get(code).updateStock(quantity);
//        log.info("Item " + getCodeItemMapper().get(code).getName() + " Stock has been updated");
//    }
//
//
//    //update the item price
//    public void updateItemPrice(String code, Double amount) {
//        if (!doesCodeExists(code)) {
//            log.error("Item with code " + code + "does not exists! Please add the item first!");
//            return;
//        }
//        getCodeItemMapper().get(code).setAmount(amount);
//        log.info("Item " + getCodeItemMapper().get(code).getName() + " Price has been updated");
//    }
//
//
//    //place order
//    public void placeOrder(String orderCode) {
//        String userOrder = displayDevice.orderProduct(orderCode);
//
//        if (getBalance() == 0D) {
//            displayDevice.displayMessage("Sorry! You do not have sufficient credit \nPlease add more coins/cash");
//            return;
//        }
//
//
//        if (!doesCodeExists(userOrder)) {
//            displayDevice.displayMessage("Order code " + orderCode + " is not found");
//            return;
//        }
//
//        if (getBalance() < getCodeItemMapper().get(userOrder).getAmount()) {
//            displayDevice.displayMessage("Sorry! You do not have sufficient credit \nPlease add more coins/cash");
//            return;
//        }
//
//        if (getCodeItemMapper().get(userOrder).getStock() == 0) {
//            displayDevice.displayMessage("Sorry! " + getCodeItemMapper().get(userOrder).getName() + " is out of stock");
//            return;
//        }
//
//        displayDevice.displayMessage("Thank you for your order!\nPlease collect your " + getCodeItemMapper().get(userOrder).getName());
//        if (getBalance() > getCodeItemMapper().get(userOrder).getAmount()) {
//            reduceBalance(getCodeItemMapper().get(userOrder).getAmount());
//        }
//        TransactionLogUtils.logTransactions(new Transaction(getCodeItemMapper().get(userOrder)));
//        refund(getBalance());
//        getCodeItemMapper().get(userOrder).setStock(getCodeItemMapper().get(userOrder).getStock() - 1);
//    }
//
//
//    //add cash to balance
//    public void loadCash(Double amount) {
//        addBalance(billInserter.getAmount(amount));
//        displayDevice.displayMessage("Your available balance is now " + getBalance());
//    }
//
//
//    public void loadCoins(Double amount) {
//        addBalance(billInserter.getAmount(amount));
//        displayDevice.displayMessage("Your available balance is now " + getBalance());
//    }
//
//
//    public void cancel() {
//        log.info("Canceling the order!");
//        if (getBalance() != 0D) {
//            refund(getBalance());
//            resetBalance();
//        }
//        displayDevice.displayMessage(String.format(MessageConstants.CANCEL_MESSAGE, MACHINE_NAME));
//    }
//
//
//    public void refund(Double amount) {
//        displayDevice.displayMessage(String.format(MessageConstants.RETURN_MESSAGE, amount));
//    }
//
//
//    private Boolean doesCodeExists(String code) {
//        return getCodeItemMapper().containsKey(code);
//    }
}
