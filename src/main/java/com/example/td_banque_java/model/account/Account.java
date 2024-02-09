package com.example.td_banque_java.model.account;

import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Account {

    protected double balance;
    protected String numberAccount;
    protected Client client;
    protected Bank bank;

    public abstract void debit(double amount) throws IllegalArgumentException;

    public void credit(double amount) throws IllegalArgumentException {
        if(amount < 0)
            throw new IllegalArgumentException("Debit not authorized");
        this.balance += amount;
    }
}
