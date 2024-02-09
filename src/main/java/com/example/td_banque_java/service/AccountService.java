package com.example.td_banque_java.service;

import com.example.td_banque_java.entity.AccountEntity;
import com.example.td_banque_java.model.Bank;
import com.example.td_banque_java.model.Client;
import com.example.td_banque_java.model.account.Account;
import com.example.td_banque_java.model.account.WithoutOverdraftAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    public List<Account> getAllAccounts() {
        List<Account> accountEntities = new ArrayList<>();
        Client client = new Client("1", "Client 1","rue blabla", new Bank());
        accountEntities.add(new WithoutOverdraftAccount(1000, "123", client, new Bank()));
        accountEntities.add(new WithoutOverdraftAccount(1235.5, "1234", client, new Bank()));
        return accountEntities;
    }

}
