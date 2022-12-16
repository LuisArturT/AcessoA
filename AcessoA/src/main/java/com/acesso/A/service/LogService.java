package com.acesso.A.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acesso.A.model.Logistic;
import com.acesso.A.web.dto.LogRegistrationDto;
@Service("logService")
public interface LogService {
	Logistic save(LogRegistrationDto logRegistrationDto);

	List<LogRegistrationDto> findAll();
}
