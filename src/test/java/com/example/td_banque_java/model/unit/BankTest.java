package com.example.td_banque_java.model.unit;

import com.example.td_banque_java.model.Account;
import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
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
        account = new Account(1000, "1", client, new Bank());
        HashMap<Account, Client> accountsByClient = new HashMap<>(Map.of(account, client));
        bank = new Bank(accountsByClient);
    }

    @Test
    void withdraw() throws Exception {
        bank.withdraw(account, 100, client.getNumberClient());
        assertEquals(900, account.getSold());
    }

    @Test
    void withdrawNumberClientDoesNotMatchTheBankAccount() {
        assertThrows(Exception.class, () -> bank.withdraw(
                account,
                100,
                client.getNumberClient() + "1"
        ));
    }

    @Test
    void withdrawAmountGreaterThanAccountBalance() {
        assertThrows(Exception.class, () -> bank.withdraw(
                account,
                1200,
                client.getNumberClient()
        ));
    }

    @Test
    void depot() {
        bank.depot(account, 100, client.getNumberClient());
        assertEquals(1100, account.getSold());
    }

    @Test
    void openAccount() {
        Client newClient = new Client("2", "client2", "address2", new Bank());
        Account newAccount = new Account(2000, "2", newClient, new Bank());
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
