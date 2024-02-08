package com.example.td_banque_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TdBanqueJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TdBanqueJavaApplication.class, args);
    }

}
