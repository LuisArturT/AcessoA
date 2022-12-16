package com.acesso.A.service;

import java.util.List;

import javax.management.ServiceNotFoundException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acesso.A.model.Client;
import com.acesso.A.model.User;
import com.acesso.A.web.dto.ClientRegistrationDto;
import com.acesso.A.web.dto.FuncioRegistrationDto;
import com.acesso.A.web.dto.OpRegistrationDto;

@Service("clientService")
public interface ClientService {
	Client save(ClientRegistrationDto client);

	List<ClientRegistrationDto> findAll();
}
