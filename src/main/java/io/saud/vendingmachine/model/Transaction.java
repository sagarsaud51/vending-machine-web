package io.saud.vendingmachine.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TRANSACTION_LOG")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private UUID uuid;
    @Column
    private String item;
    @Column
    private Double amount;
    @Column
    private LocalDateTime transactionDate;

    public Transaction() {
    }

    public Transaction(Item dto) {
        this.uuid = UUID.randomUUID();
        this.item = dto.getName();
        this.amount = dto.getAmount();
        this.transactionDate = LocalDateTime.now();
    }

    public Transaction(UUID uuid, String item, Double amount, LocalDateTime transactionDate) {
        this.uuid = uuid;
        this.item = item;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }
}
