package com.example.td_banque_java.service;

import com.example.td_banque_java.Mock.AccountDataMock;
import com.example.td_banque_java.model.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDataMock accountData;

    public List<Account> getAllAccounts() {
        return accountData.generateData();
    }

}
