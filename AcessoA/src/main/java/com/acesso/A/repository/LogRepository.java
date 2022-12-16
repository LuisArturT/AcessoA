package com.acesso.A.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acesso.A.model.Logistic;

@Repository
public interface LogRepository extends JpaRepository<Logistic, Long> {
	List<Logistic> findAll();
	Logistic save(Logistic logistic);
}
