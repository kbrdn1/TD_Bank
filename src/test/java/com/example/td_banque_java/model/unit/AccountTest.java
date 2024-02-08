package com.example.td_banque_java.model.unit;

import com.example.td_banque_java.model.Account;
import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        Bank bank = new Bank();
        Client client = new Client("1", "client1", "address1", bank);
        account = new Account(1000, "1", client, bank);
    }

    @Test
    void debit() {
        account.debit(100);
        assertEquals(900, account.getSold());
    }

    @Test
    void debitError() {
        assertThrows(RuntimeException.class, () -> {
            account.debit(-100);
        });
    }

    @Test
    void credit() {
        account.credit(100);
        assertEquals(1100, account.getSold());
    }

    @Test
    void creditError() {
        assertThrows(RuntimeException.class, () -> {
            account.credit(-100);
        });
    }

    @Test
    void getSold() {
        assertEquals(1000, account.getSold());
    }

    @Test
    void getNumberAccount() {
        assertEquals("1", account.getNumberAccount());
    }

    @Test
    void getClient() {
        assertEquals("1", account.getClient().getNumberClient());
    }

    @Test
    void getBank() {
        assertNotNull(account.getBank());
    }

    @Test
    void setSold() {
        account.setSold(2000);
        assertEquals(2000, account.getSold());
    }

    @Test
    void setNumberAccount() {
        account.setNumberAccount("2");
        assertEquals("2", account.getNumberAccount());
    }

    @Test
    void setClient() {
        Client client = new Client("2", "client2", "address2", new Bank());
        account.setClient(client);
        assertEquals(client, account.getClient());
    }

    @Test
    void setBank() {
        Bank bank = new Bank();
        account.setBank(bank);
        assertEquals(bank, account.getBank());
    }
}