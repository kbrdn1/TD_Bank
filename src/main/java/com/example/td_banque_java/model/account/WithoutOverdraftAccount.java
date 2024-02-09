package com.example.td_banque_java.model.account;

import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithoutOverdraftAccount extends Account {

    public WithoutOverdraftAccount(double sold, String numberAccount, Client client, Bank bank) {
        super(sold, numberAccount, client, bank);
    }


    @Override
    public void debit(double amount) throws IllegalArgumentException {
        if(amount < 0)
            throw new IllegalArgumentException("Negative amount not authorized.");
        if(this.balance - amount < 0)
            throw new IllegalArgumentException("Not enough money in the account.");
        this.balance -= amount;
    }
}
