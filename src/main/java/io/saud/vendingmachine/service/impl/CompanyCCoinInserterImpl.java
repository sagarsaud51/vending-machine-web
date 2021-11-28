package io.saud.vendingmachine.service.impl;


import io.saud.vendingmachine.service.abstracts.MoneyInserter;
import org.springframework.stereotype.Service;

@Service(value = "companyCCoinInserter")
public class CompanyCCoinInserterImpl extends MoneyInserter {

    //for exchange rate 1 = 1
    @Override
    public Double getAmount(Double amount) {
        if (amount == null || amount <= 0) {
            return 0.0;
        }
        if (denoCount.containsKey(amount)) {
            denoCount.put(amount, denoCount.get(amount) + 1);
        } else {
            denoCount.put(amount, 1);
        }
        balance += amount;
        return amount;
    }


}
