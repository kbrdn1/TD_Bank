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

    private Map<Account,Client> accountsByClient;
    @BeforeEach
    void setUp() {
        client = new Client("1", "client1", "address1", new Bank());
        account = new Account(1000, "1", client, new Bank());
        HashMap<Account,Client> accountsByClient = new HashMap<>(Map.of(account,client));
        bank = new Bank(accountsByClient);
    }

    @Test
    void withdraw() {
        bank.withdraw(account, 100, client.getName());
        assertEquals(900, account.getSold());
    }

    @Test
    void depot() {
        bank.depot(account, 100, client.getName());
        assertEquals(1100, account.getSold());
    }

    @Test
    void openAccount() {
        HashMap<Account,Client> accountsByClient = new HashMap<>(Map.of(account,client));
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