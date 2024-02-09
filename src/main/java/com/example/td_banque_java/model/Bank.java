package com.example.td_banque_java.model;

import com.example.td_banque_java.model.account.Account;
import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    private HashMap<Account, Client> accountsByClient;

    /**
     * Withdraw money from an account
     *
     * @param account
     * @param amount
     * @param client
     * @throws IllegalAccessException
     */
    public void withdraw(Account account, double amount, String client) throws IllegalAccessException {
        if(accountsByClient.get(account).getName().equals(client))
            account.debit(amount);
        else
            throw new IllegalAccessException("The customer number does not match the bank account.");
    }

    /**
     * Deposit money into an account
     *
     * @param account
     * @param amount
     * @param client
     * @throws IllegalAccessException
     */
    public void depot(Account account, double amount, String client) throws IllegalAccessException {
        if(accountsByClient.get(account).getName().equals(client))
            account.credit(amount);
    }

    /**
     * Open an account
     *
     * @param account
     * @param client
     */
    public void openAccount(Account account, Client client) {
        if (accountsByClient == null)
            accountsByClient = new HashMap<>();
        accountsByClient.put(account, client);
    }

    /**
     * Convert an amount from euro to the bank's currency
     *
     * @param account
     * @param client
     */
    public double convertFromEuro(double amount) {
        return amount * 1.1;
    }

    /**
     * Convert an amount from the bank's currency to euro
     *
     * @param account
     * @param client
     */
    public double convertToEuro(double amount) {
        return amount / 1.1;
    }

}
