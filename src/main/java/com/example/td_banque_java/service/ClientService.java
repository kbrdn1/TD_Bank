package com.example.td_banque_java.service;

import com.example.td_banque_java.mock.ClientDataMock;
import com.example.td_banque_java.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientDataMock clientDataMock;

    public List<Client> getAllClients() {
        return clientDataMock.generateClients(100);
    }

    public Client getClientByNumberClient(String numberClient) {
        return clientDataMock.generateClients(100)
                .stream()
                .filter(it -> Objects.equals(it.getNumberClient(), numberClient))
                .toList().getFirst();
    }

    public Client createClient(Client newClient) {
        return newClient;
    }
}
