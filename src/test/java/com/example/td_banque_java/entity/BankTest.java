package com.example.td_banque_java.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private Client client;
    private Account account;

    private Map<Client,Account> accountsByClient;
    @BeforeEach
    void setUp() {
        client = new Client("1", "client1", "address1", new Bank());
        account = new Account(1000, "1", client, new Bank());
        HashMap<Client,Account> accountsByClient = new HashMap<>(Map.of(client, account));
        bank = new Bank(accountsByClient);
    }

    @Test
    void withdraw() {
        bank.withdraw("1", 100, client);
        assertEquals(900, bank.getAccountsByClient().get(client).getSold());
    }

    @Test
    void depot() {
        bank.depot("1", 100, client);
        assertEquals(1100, bank.getAccountsByClient().get(client).getSold());
    }

    @Test
    void openAccount() {
        HashMap<Client,Account> accountsByClient = new HashMap<>(Map.of(client, account));
        bank.openAccount(account, client);
        assertEquals(accountsByClient.size(), bank.getAccountsByClient().size());
    }

    @Test
    void convertFromEuro() {
        assertEquals(110.00000000000001, bank.convertFromEuro(100));
    }

    @Test
    void convertToEuro() {
        assertEquals(99.99999999999999, bank.convertToEuro(110));
    }
}