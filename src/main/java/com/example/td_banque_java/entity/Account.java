package com.example.td_banque_java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private double sold;
    private String numberAccount;
    private Client client;
    private Bank bank;

    public void debit(double amount) {
        this.sold -= amount;
    }

    public void credit(double amount) {
        this.sold += amount;
    }
}
