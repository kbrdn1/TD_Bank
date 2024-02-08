package com.example.td_banque_java.model.integration;

import com.example.td_banque_java.model.Account;
import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountIntegrationTest {

    private Account account;

    @BeforeEach
    void setUp() {
        Bank bank = new Bank();
        Client client = new Client("1", "client1", "address1", bank);
        account = new Account(1000, "1", client, bank);
    }

    @Test
    void integrationAccount() {

    }

}