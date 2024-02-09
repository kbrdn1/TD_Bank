package com.example.td_banque_java.model.unit;

import com.example.td_banque_java.model.account.Account;
import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import com.example.td_banque_java.model.account.OverdrawnAccount;
import com.example.td_banque_java.model.account.WithoutOverdraftAccount;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BankTest {

    private Bank bank;
    private Client client;
    private Account withoutOverdraftAccount;
    private Account overdrawnAccount;

    @BeforeEach
    void setUp() {
        bank = new Bank();

        client = new Client("1", "client1", "address1", bank);

        withoutOverdraftAccount = new WithoutOverdraftAccount(1000, "1", client, bank);
        overdrawnAccount = new OverdrawnAccount(1000, "2", client, bank, 300);

        HashMap<Account,Client> accountsByClient = new HashMap<>(Map.of(withoutOverdraftAccount,client));
        accountsByClient.put(overdrawnAccount,client);

        bank.setAccountsByClient(accountsByClient);
    }

    @Test
    void withdrawFromAnAccountWithoutAuthorizedOverdraft() throws IllegalAccessException {
        bank.withdraw(withoutOverdraftAccount, 100, client.getName());
        assertEquals(900, withoutOverdraftAccount.getBalance());
    }

    @Test
    void withdrawFromAnAccountWithAuthorizedOverdraft() throws IllegalAccessException {
        bank.withdraw(overdrawnAccount, 1200, client.getName());
        assertEquals(-200, overdrawnAccount.getBalance());
    }

    @Test
    void withdrawNumberClientDoesNotMatchTheBankAccount() {
        assertThrows(IllegalAccessException.class, () -> bank.withdraw(
                withoutOverdraftAccount,
                100,
                client.getNumberClient() + "1"
        ));
    }

    @Test
    void withdrawAmountGreaterThanAuthorized() {
        assertThrows(IllegalAccessException.class, () -> bank.withdraw(
                withoutOverdraftAccount,
                1200,
                client.getNumberClient()
        ));

        assertThrows(IllegalAccessException.class, () -> bank.withdraw(
                overdrawnAccount,
                1400,
                client.getNumberClient()
        ));
    }

    @Test
    void depot() throws IllegalAccessException {
        bank.depot(withoutOverdraftAccount, 100, client.getName());
        assertEquals(1100, withoutOverdraftAccount.getBalance());
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
