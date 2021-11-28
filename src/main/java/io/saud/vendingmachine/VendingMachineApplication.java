package io.saud.vendingmachine;

import io.saud.vendingmachine.initializer.ItemInit;
import io.saud.vendingmachine.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendingMachineApplication {


    public static void main(String[] args) {

        SpringApplication.run(VendingMachineApplication.class, args);

    }

}
