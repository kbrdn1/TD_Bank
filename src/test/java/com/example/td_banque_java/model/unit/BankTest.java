package com.example.td_banque_java.model.unit;

import com.example.td_banque_java.model.account.Account;
import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import com.example.td_banque_java.model.account.WithoutOverdraftAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private Client client;
    private Account account;

    @BeforeEach
    void setUp() {
        client = new Client("1", "client1", "address1", new Bank());
        account = new WithoutOverdraftAccount(1000, "1", client, new Bank());
        HashMap<Account,Client> accountsByClient = new HashMap<>(Map.of(account,client));
        bank = new Bank(accountsByClient);
    }

    @Test
    void withdraw() throws IllegalAccessException {
        bank.withdraw(account, 100, client.getName());
        assertEquals(900, account.getBalance());
    }

    @Test
    void depot() throws IllegalAccessException {
        bank.depot(account, 100, client.getName());
        assertEquals(1100, account.getBalance());
    }

    @Test
    void openAccount() {
        Client newClient = new Client("2", "client2", "address2", new Bank());
        Account newAccount = new WithoutOverdraftAccount(2000, "2", newClient, new Bank());
        bank.openAccount(newAccount, newClient);

        assertTrue(bank.getAccountsByClient().containsKey(newAccount));
    }

    @Test
    void convertFromEuro() {
        assertEquals(110, bank.convertFromEuro(100), 0.001);
        assertEquals(0, bank.convertFromEuro(0), 0.001);
    }

    @Test
    void convertToEuro() {
        assertEquals(100, bank.convertToEuro(110), 0.001);
        assertEquals(0, bank.convertToEuro(0), 0.001);
    }
}
