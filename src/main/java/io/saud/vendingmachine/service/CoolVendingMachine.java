package io.saud.vendingmachine.service;

import io.saud.vendingmachine.constants.MessageConstants;
import io.saud.vendingmachine.dto.AllItemsResponse;
import io.saud.vendingmachine.dto.DisplayResponse;
import io.saud.vendingmachine.dto.VendingResponse;
import io.saud.vendingmachine.exception.VendingMachineException;
import io.saud.vendingmachine.model.Item;
import io.saud.vendingmachine.model.Transaction;
import io.saud.vendingmachine.repo.ItemRepo;
import io.saud.vendingmachine.repo.TransactionRepo;
import io.saud.vendingmachine.service.abstracts.MoneyInserter;
import io.saud.vendingmachine.service.abstracts.VendingMachineService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CoolVendingMachine extends VendingMachineService {


    private final ItemRepo itemRepo;
    private final TransactionRepo transactionRepo;

    public CoolVendingMachine(@Qualifier("companyABillInserter") MoneyInserter billInserter, @Qualifier("companyCCoinInserter") MoneyInserter coinInserter, @Qualifier("companyBDisplayDevice") DisplayDevice displayDevice, ItemRepo itemRepo, TransactionRepo transactionRepo) {
        super(billInserter, coinInserter, displayDevice);
        this.transactionRepo = transactionRepo;
        setMachineName("Cool Vending Machine");
        this.itemRepo = itemRepo;
    }

    @Override
    public ResponseEntity<Object> placeOrder(String orderCode) {
        String userOrder = displayDevice.orderProduct(orderCode);
        Item item = itemRepo.findItemByCodeEquals(userOrder);
        if (getBalance() == 0D) {
            displayDevice.displayMessage(new DisplayResponse("Sorry! You do not have sufficient credit \nPlease add more coins/cash", getBalance(), false));
            return ResponseEntity.badRequest().build();
        }

        if (item == null) {
            displayDevice.displayMessage(new DisplayResponse("Order code " + orderCode + " is not found", getBalance(), false));
            return ResponseEntity.badRequest().build();
        }

        if (getBalance() < item.getAmount()) {
            displayDevice.displayMessage(new DisplayResponse("Sorry! You do not have sufficient credit \nPlease add more coins/cash", getBalance(), false));
            return ResponseEntity.badRequest().build();
        }

        if (item.getStock() == 0) {
            displayDevice.displayMessage(new DisplayResponse("Sorry! " + item.getName() + " is out of stock", getBalance(), false));
            return ResponseEntity.badRequest().build();
        }

        if (getBalance() >= item.getAmount()) {
            reduceBalance(item.getAmount());
        }
        transactionRepo.save(new Transaction(item));
        VendingResponse response = new VendingResponse(item.getName(), refund(getBalance()));
        displayDevice.displayMessage(new DisplayResponse("Thank you for your order! Please collect your " + item.getName(), getBalance(), true));

        item.setStock(item.getStock() - 1);
        itemRepo.save(item);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> loadCash(Double balance) {
        validateAmount(balance);
        addBalance(billInserter.getAmount(balance));
        displayDevice.displayMessage(new DisplayResponse("Your available balance is now " + getBalance(), getBalance(), true));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Object> loadCoins(Double balance) {
        validateAmount(balance);
        addBalance(billInserter.getAmount(balance));
        displayDevice.displayMessage(new DisplayResponse("Your available balance is now " + getBalance(), getBalance(), true));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Object> cancel() {
        log.info("Canceling the order!");
        VendingResponse vendingResponse = new VendingResponse();
        if (getBalance() != 0D) {
            vendingResponse.setAmount(getBalance());
            refund(getBalance());
            resetBalance();
        }
        displayDevice.displayMessage(new DisplayResponse(String.format(MessageConstants.CANCEL_MESSAGE, getMachineName()), getBalance(), false));
        return ResponseEntity.ok().body(vendingResponse);
    }

    @Override
    public ResponseEntity<Object> getAllItems() {
        var res = itemRepo.findAll();
        List<AllItemsResponse> allItemsResponseList = new ArrayList<>(res.size());
        res.forEach(item -> allItemsResponseList.add(new AllItemsResponse(item.getName(), item.getAmount(), item.getStock(), item.getCode())));
        return ResponseEntity.ok(allItemsResponseList);
    }

    @Override
    public Double refund(Double amount) {
        if (amount > 0) {
            displayDevice.displayMessage(new DisplayResponse(String.format(MessageConstants.RETURN_MESSAGE, amount), getBalance(), true));
        }
        resetBalance();
        return amount;
    }

    private void validateAmount(Double amount) {
        if (amount <= 0) {
            displayDevice.displayMessage(new DisplayResponse("Invalid Amount Response", getBalance(), false));
            throw new VendingMachineException("Invalid amount");
        }
    }

}
