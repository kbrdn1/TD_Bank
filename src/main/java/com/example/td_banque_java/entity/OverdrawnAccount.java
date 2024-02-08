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

    @Override
   public void debit(double amount) {
        if(this.sold - amount < -this.overdrawnAutorized)
            throw new RuntimeException("Overdrawn not authorized");
        if(amount < 0)
            throw new RuntimeException("Debit not authorized");
        this.sold -= amount;
    }

}
