package com.example.td_banque_java.mock;

import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import com.example.td_banque_java.model.account.Account;
import com.example.td_banque_java.model.account.WithoutOverdraftAccount;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class ClientDataMock {

    private Faker faker = new Faker(new Locale("fr"));

    /**
     * Generates as many fake clients as passed as a parameter.
     *
     * @param numberOfClients desired number of clients
     * @return generated clients
     */
    public List<Client> generateClients(int numberOfClients) {

        List<Client> clientEntities = new ArrayList<>();
        Bank bank = new Bank();

        for (int i = 0; i < numberOfClients; i++) {
            clientEntities.add(new Client(
                    Integer.toString(i + 1),
                    faker.name().fullName(),
                    faker.address().fullAddress(),
                    bank
            ));
        }

        return clientEntities;
    }

}
