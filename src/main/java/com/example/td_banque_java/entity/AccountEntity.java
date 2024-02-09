package com.example.td_banque_java.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PositiveOrZero
    private double balance;

    @NotBlank
    private String numberAccount;

    @ManyToOne
    private ClientEntity client;

    @ManyToOne
    private BankEntity bank;

}
