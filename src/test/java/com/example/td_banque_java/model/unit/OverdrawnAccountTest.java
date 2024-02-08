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
    void debit() throws IllegalAccessException {
        account.debit(100);
        assertEquals(900, account.getSold());
    }

    @Test
    void debitErrorAmountNegatif() {
        assertThrows(IllegalAccessException.class, () -> {
            account.debit(-100);
        });
    }

    @Test
    void debitErrorOverdrawnAutorized() {
        account.setSold(0);
        assertThrows(IllegalAccessException.class, () -> {
            account.debit(-200);
        });
    }

    @Test
    void credit() throws IllegalAccessException {
        account.credit(100);
        assertEquals(1100, account.getSold());
    }

    @Test
    void creditError() {
        assertThrows(IllegalAccessException.class, () -> {
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