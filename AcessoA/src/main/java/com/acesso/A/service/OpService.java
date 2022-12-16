package com.acesso.A.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acesso.A.model.Op;
import com.acesso.A.repository.OpRepository;
import com.acesso.A.web.dto.OpRegistrationDto;
@Service("opService")
public interface OpService {
	Op save(OpRegistrationDto opRegistrationDto);

	List<OpRegistrationDto> findAll();
	
}
