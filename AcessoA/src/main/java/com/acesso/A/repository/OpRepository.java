package com.acesso.A.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acesso.A.model.Op;
import com.acesso.A.web.dto.OpRegistrationDto;

@Repository
public interface OpRepository extends JpaRepository<Op, Long> {
	List<Op> findAll();
	Op save(Op op);
}
