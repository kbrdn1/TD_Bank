package com.example.td_banque_java.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Client {

    private String numberClient;
    private String name;
    private String address;
    private Bank bank;

}
