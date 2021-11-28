package io.saud.vendingmachine.service.impl;


import io.saud.vendingmachine.service.DisplayDevice;
import org.springframework.stereotype.Service;

@Service(value = "companyBDisplayDevice")
public class CompanyBDisplayDeviceImpl implements DisplayDevice {
    @Override
    public void displayMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }


    @Override
    public String orderProduct(String orderCode) {
        return orderCode;
    }
}
