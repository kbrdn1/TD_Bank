package com.example.td_banque_java.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public class OverdrawnAccount extends Account{

    private double overdrawnAutorized;

    public OverdrawnAccount(double sold, String numberAccount, Client client, Bank bank, double overdrawnAutorized) {
        super(sold, numberAccount, client, bank);
        this.overdrawnAutorized = overdrawnAutorized;
    }

}
