package com.example.td_banque_java.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.td_banque_java.entity.AccountEntity;

public interface AccountDao extends CrudRepository<AccountEntity, Long> {

}