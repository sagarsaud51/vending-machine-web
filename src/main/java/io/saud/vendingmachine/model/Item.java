package io.saud.vendingmachine.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Double amount;
    @Column
    private Integer stock;
    @Column
    private String code;
    @Column
    private Boolean active = true;

    public Item(String code, String name, double amount, int stock) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.stock = stock;
    }


    public void updateStock(Integer stock) {
        this.stock += stock;
    }
}
