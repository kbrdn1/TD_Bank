package com.example.td_banque_java.model.account;

import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithoutOverdraftAccount extends Account {

    /**
     * Constructor
     *
     * @param sold
     * @param numberAccount
     * @param client
     * @param bank
     */
    public WithoutOverdraftAccount(double sold, String numberAccount, Client client, Bank bank) {
        super(sold, numberAccount, client, bank);
    }

    /**
     * Debit money from an account
     *
     * @param amount
     * @throws IllegalArgumentException
     */
    @Override
    public void debit(double amount) throws IllegalArgumentException {
        if(amount < 0)
            throw new IllegalArgumentException("Negative amount not authorized.");
        if(this.balance - amount < 0)
            throw new IllegalArgumentException("Not enough money in the account.");
        this.balance -= amount;
    }
}
