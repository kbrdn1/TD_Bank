package com.example.td_banque_java.model.unit;

import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;
    @BeforeEach
    void setUp() {
        client = new Client("1", "client1", "address1", new Bank());
    }

    @Test
    void getNumberClient() {
        assertEquals("1", client.getNumberClient());
    }

    @Test
    void getName() {
        assertEquals("client1", client.getName());
    }

    @Test
    void getAddress() {
        assertEquals("address1", client.getAddress());
    }

    @Test
    void getBank() {
        assertNotNull(client.getBank());
    }

    @Test
    void setNumberClient() {
        client.setNumberClient("2");
        assertEquals("2", client.getNumberClient());
    }

    @Test
    void setName() {
        client.setName("client2");
        assertEquals("client2", client.getName());
    }

    @Test
    void setAddress() {
        client.setAddress("address2");
        assertEquals("address2", client.getAddress());
    }

    @Test
    void setBank() {
        Bank bank = new Bank();
        client.setBank(bank);
        assertEquals(bank, client.getBank());
    }

}