package com.acesso.A.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acesso.A.model.User;
import com.acesso.A.web.dto.FuncioRegistrationDto;
@Service("userService")
public interface UserService extends UserDetailsService{
	User save(FuncioRegistrationDto funcioRegistrationDto);
	User loadUserByUsername(String username)throws UsernameNotFoundException;
}
