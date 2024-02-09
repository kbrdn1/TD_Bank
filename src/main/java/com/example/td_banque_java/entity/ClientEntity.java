package com.example.td_banque_java.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String numberClient;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @ManyToOne
    private BankEntity bank;

    @OneToMany(mappedBy = "client")
    private List<AccountEntity> accounts;

}
