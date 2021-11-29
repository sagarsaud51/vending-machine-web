package io.saud.vendingmachine.service;

import io.saud.vendingmachine.dto.DisplayResponse;

public interface DisplayDevice {

    void displayMessage(DisplayResponse message);

    String orderProduct(String orderCode);
}
