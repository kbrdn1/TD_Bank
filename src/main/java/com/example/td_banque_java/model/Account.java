package com.example.td_banque_java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    protected double sold;
    protected String numberAccount;
    protected Client client;
    protected Bank bank;

    public void debit(double amount) throws Exception {
        if(amount < 0 || this.sold - amount < 0)
            throw new Exception("Debit not authorized");
        this.sold -= amount;
    }

    public void credit(double amount) {
        if(amount < 0)
            throw new RuntimeException("Debit not authorized");
        this.sold += amount;
    }
}
