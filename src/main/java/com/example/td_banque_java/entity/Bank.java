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

    private HashMap<Account, Client> accountsByClient;

    public void withdraw(Account account, double amount, String client) {
        if(accountsByClient.get(account).getName().equals(client))
            account.debit(amount);
    }

    public void depot(Account account, double amount, String client) {
        if(accountsByClient.get(account).getName().equals(client))
            account.credit(amount);
    }

    public void openAccount(Account account, Client client) {
        if(accountsByClient == null)
            accountsByClient = new HashMap<>();
        accountsByClient.put(account, client);
    }

    public double convertFromEuro(double amount) {
        return amount * 1.1;
    }

    public double convertToEuro(double amount) {
        return amount / 1.1;
    }

}
