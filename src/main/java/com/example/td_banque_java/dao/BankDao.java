package com.example.td_banque_java.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.td_banque_java.entity.BankEntity;

public interface BankDao extends CrudRepository<BankEntity, Long> {

}