package com.example.td_banque_java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Account {

    protected double sold;
    protected String numberAccount;
    protected Client client;
    protected Bank bank;

    public void debit(double amount) throws IllegalAccessException {
        if(amount < 0)
            throw new IllegalAccessException("Debit not authorized");
        this.sold -= amount;
    }

    public void credit(double amount) throws IllegalAccessException {
        if(amount < 0)
            throw new IllegalAccessException("Debit not authorized");
        this.sold += amount;
    }
}
