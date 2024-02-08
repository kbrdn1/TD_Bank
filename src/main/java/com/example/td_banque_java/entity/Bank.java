package com.example.td_banque_java.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    private HashMap<Client,Account> accountsByClient;

    public void withdraw(String numberAccount, double amount, Client clientName) {
        if(accountsByClient.get(clientName).getNumberAccount().equals(numberAccount))
           accountsByClient.get(clientName).debit(amount);
    }

    public void depot(String numberAccount, double amount, Client clientName) {
        if(accountsByClient.get(clientName).getNumberAccount().equals(numberAccount))
            accountsByClient.get(clientName).credit(amount);
    }

    public void openAccount(Account account, Client client) {
        if(accountsByClient == null)
            accountsByClient = new HashMap<>();
        accountsByClient.put(client,account);
    }

    public double convertFromEuro(double amount) {
        return amount * 1.1;
    }

    public double convertToEuro(double amount) {
        return amount / 1.1;
    }

}
