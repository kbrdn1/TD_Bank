package com.example.td_banque_java.controller.rest;


import com.example.td_banque_java.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AccountRestCtrl {

    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/accounts")
    public String getAccounts() {
        return accountService.getAllAccounts().toString();
    }

}
