package com.example.td_banque_java.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithoutOverdraftAccount extends Account {

    public WithoutOverdraftAccount(double sold, String numberAccount, Client client, Bank bank) {
        super(sold, numberAccount, client, bank);
    }


}
