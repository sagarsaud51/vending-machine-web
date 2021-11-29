package io.saud.vendingmachine.service.impl;


import com.google.gson.Gson;
import io.saud.vendingmachine.dto.DisplayResponse;
import io.saud.vendingmachine.service.DisplayDevice;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service(value = "companyBDisplayDevice")
public class CompanyBDisplayDeviceImpl implements DisplayDevice {


    private final SimpMessagingTemplate simpMessagingTemplate;

    public CompanyBDisplayDeviceImpl(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    @SendTo("/topic/public")
    public void displayMessage(DisplayResponse message) {
        simpMessagingTemplate.convertAndSend("/topic/public", message);
    }


    @Override
    public String orderProduct(String orderCode) {
        return orderCode;
    }
}
