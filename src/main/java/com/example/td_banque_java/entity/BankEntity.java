package com.example.td_banque_java.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "bank")
    List<ClientEntity> clients;

    @OneToMany(mappedBy = "bank")
    List<AccountEntity> accounts;

}
