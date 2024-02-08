package com.example.td_banque_java.entity;

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
}