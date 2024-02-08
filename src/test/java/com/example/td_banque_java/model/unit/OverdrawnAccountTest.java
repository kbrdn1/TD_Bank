package com.example.td_banque_java.model.unit;

import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import com.example.td_banque_java.model.OverdrawnAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OverdrawnAccountTest {

    private OverdrawnAccount account;
    @BeforeEach
    void setUp() {
        Bank bank = new Bank();
        Client client = new Client("1", "client1", "address1", bank);
        account = new OverdrawnAccount(1000, "1", client, bank, 100);
    }

    @Test
    void getOverdrawnAutorized() {
        assertEquals(100, account.getOverdrawnAutorized());
    }

    @Test
    void setOverdrawnAutorized() {
        account.setOverdrawnAutorized(200);
        assertEquals(200, account.getOverdrawnAutorized());
    }

    @Test
    void debit() {
        account.debit(100);
        assertEquals(900, account.getSold());
    }

    @Test
    void debitErrorAmountNegatif() {
        assertThrows(RuntimeException.class, () -> {
            account.debit(-100);
        });
    }

    @Test
    void debitErrorOverdrawnAutorized() {
        account.setSold(0);
        assertThrows(RuntimeException.class, () -> {
            account.debit(-200);
        });
    }


}