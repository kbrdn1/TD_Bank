package com.example.td_banque_java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    protected double sold;
    protected String numberAccount;
    protected Client client;
    protected Bank bank;

    public void debit(double amount) {
        if(amount < 0)
            throw new RuntimeException("Debit not authorized");
        this.sold -= amount;
    }

    public void credit(double amount) {
        if(amount < 0)
            throw new RuntimeException("Debit not authorized");
        this.sold += amount;
    }
}
