package io.saud.vendingmachine.controller;


import io.saud.vendingmachine.dto.MoneyRequest;
import io.saud.vendingmachine.dto.PlaceOrderRequest;
import io.saud.vendingmachine.service.CoolVendingMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cool")
@CrossOrigin
public class CoolVendingController {

    @Autowired
    CoolVendingMachine coolVendingMachine;

    @PostMapping("load-cash")
    public ResponseEntity<Object> loadCash(@RequestBody MoneyRequest amount) {
        return coolVendingMachine.loadCash(amount.getAmount());
    }

    @PostMapping("load-coin")
    public ResponseEntity<Object> loadCoin(@RequestBody MoneyRequest amount) {
        return coolVendingMachine.loadCoins(amount.getAmount());
    }

    @GetMapping("cancel")
    public ResponseEntity<Object> cancel() {
        return coolVendingMachine.cancel();
    }

    @PostMapping("order")
    public ResponseEntity<Object> order(@RequestBody PlaceOrderRequest orderRequest) {
        return coolVendingMachine.placeOrder(orderRequest.getOrderId());
    }

    @GetMapping("all-items")
    public ResponseEntity<Object> getAllItems() {
        return coolVendingMachine.getAllItems();
    }

    @GetMapping("info")
    public ResponseEntity<Object> getInfo() {
        return coolVendingMachine.getInfo();
    }
}
