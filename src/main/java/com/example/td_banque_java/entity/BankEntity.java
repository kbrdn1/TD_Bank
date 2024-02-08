package com.example.td_banque_java.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "bank")
    List<ClientEntity> clients;

    @OneToMany(mappedBy = "bank")
    List<AccountEntity> accounts;
}
