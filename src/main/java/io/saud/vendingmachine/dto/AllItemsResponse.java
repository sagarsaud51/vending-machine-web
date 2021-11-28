package io.saud.vendingmachine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllItemsResponse {

    private String name;
    private Double amount;
    private Integer stock;
    private String code;
}
