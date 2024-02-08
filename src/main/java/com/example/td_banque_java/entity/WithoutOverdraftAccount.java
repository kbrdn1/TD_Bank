package com.example.td_banque_java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public class WithoutOverdraftAccount extends Account {

    public WithoutOverdraftAccount(double sold, String numberAccount, Client client, Bank bank) {
        super(sold, numberAccount, client, bank);
    }

}
