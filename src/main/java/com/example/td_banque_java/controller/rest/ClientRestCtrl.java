package com.example.td_banque_java.controller.rest;


import com.example.td_banque_java.model.Client;
import com.example.td_banque_java.service.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClientRestCtrl {

    @Autowired
    private ClientService clientService;

    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping(path = "/clients")
    public String getClients() throws JsonProcessingException {
        return mapper.writeValueAsString(clientService.getAllClients());
    }

    @GetMapping(path = "/clients/{numberClient}")
    public String getClient(@PathVariable String numberClient) throws JsonProcessingException {
        return mapper.writeValueAsString(clientService.getClientByNumberClient(numberClient));
    }

    @PostMapping(path = "/clients")
    public String createClient(@RequestBody Client client) throws JsonProcessingException {
        return mapper.writeValueAsString(clientService.createClient(client));
    }
}
