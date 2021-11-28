package io.saud.vendingmachine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendingResponse {

    private String object;
    private Double amount;
}
