package io.saud.vendingmachine.service;

public interface DisplayDevice {

    void displayMessage(String message);
    String orderProduct(String orderCode);
}
