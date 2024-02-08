package com.example.td_banque_java.model;

import lombok.*;

@Getter
@Setter
public class OverdrawnAccount extends Account{

    private double overdrawnAutorized;

    public OverdrawnAccount(double sold, String numberAccount, Client client, Bank bank, double overdrawnAutorized) {
        super(sold, numberAccount, client, bank);
        this.overdrawnAutorized = overdrawnAutorized;
    }

    @Override
   public void debit(double amount) throws IllegalAccessException {
        if(this.balance - amount < -this.overdrawnAutorized)
            throw new IllegalAccessException("Overdrawn not authorized");
        if(amount < 0)
            throw new IllegalAccessException("Debit not authorized");
        this.balance -= amount;
    }

}
