package com.acesso.A.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acesso.A.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	Client save(Client client);
	List<Client> findAll();

}
