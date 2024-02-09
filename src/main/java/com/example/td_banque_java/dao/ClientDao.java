package com.example.td_banque_java.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.td_banque_java.entity.ClientEntity;

public interface ClientDao extends CrudRepository<ClientEntity, Long> {

}