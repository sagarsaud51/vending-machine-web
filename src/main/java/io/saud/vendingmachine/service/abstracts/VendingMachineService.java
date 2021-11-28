package io.saud.vendingmachine.service.abstracts;


import io.saud.vendingmachine.dto.VendingResponse;
import io.saud.vendingmachine.model.Item;
import io.saud.vendingmachine.service.DisplayDevice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public abstract class VendingMachineService {


    public final MoneyInserter billInserter;
    public final MoneyInserter coinInserter;
    public final DisplayDevice displayDevice;
    private String machineName = "";
    private Double balance = 0D;


    private final Map<String, Item> codeItemMapper = new HashMap<>();

    public VendingMachineService(MoneyInserter billInserter, MoneyInserter coinInserter, DisplayDevice displayDevice) {
        this.billInserter = billInserter;
        this.coinInserter = coinInserter;
        this.displayDevice = displayDevice;
    }


    public abstract ResponseEntity<Object> placeOrder(String orderCode);

    public abstract ResponseEntity<Object> loadCash(Double balance);

    public abstract ResponseEntity<Object> loadCoins(Double balance);

    public abstract ResponseEntity<Object> cancel();

    public abstract ResponseEntity<Object> getAllItems();

    public abstract Double refund(Double amount);


    public void resetBalance() {
        this.balance = 0D;
        this.billInserter.resetBalance();
        this.coinInserter.resetBalance();
    }

    public Map<String, Item> getCodeItemMapper() {
        return codeItemMapper;
    }

    public Double getBalance() {
        return balance;
    }

    public void addBalance(Double balance) {
        this.balance += balance;
    }

    public void reduceBalance(Double balance) {
        this.balance -= balance;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public ResponseEntity<Object> getInfo() {
        return ResponseEntity.ok(new VendingResponse(this.machineName, this.balance));
    }

}
