package com.example.td_banque_java.model;

import com.example.td_banque_java.model.account.Account;
import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    private HashMap<Account, Client> accountsByClient;

    public void withdraw(Account account, double amount, String client) throws IllegalAccessException {
        if(accountsByClient.get(account).getName().equals(client))
            account.debit(amount);
        else
            throw new IllegalAccessException("The customer number does not match the bank account.");
    }

    public void depot(Account account, double amount, String client) throws IllegalAccessException {
        if(accountsByClient.get(account).getName().equals(client))
            account.credit(amount);
    }

    public void openAccount(Account account, Client client) {
        if (accountsByClient == null)
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
