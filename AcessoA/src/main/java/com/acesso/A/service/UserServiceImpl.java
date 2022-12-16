package com.acesso.A.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.acesso.A.model.Role;
import com.acesso.A.model.User;
import com.acesso.A.repository.UserRepository;
import com.acesso.A.web.dto.FuncioRegistrationDto;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**Cria usuário baseado na info enviada a classe service
	*@param user
	*@return representação DTO do usuario
	*/



	@Override
	public User save(FuncioRegistrationDto funcioRegistrationDto) {

		User user = populateRegistrationDto(funcioRegistrationDto);
		return userRepository.save(user);
	}
	
	private User populateRegistrationDto(FuncioRegistrationDto funcioRegistrationDto) {	
		User user = new User();
		user.setCPF(funcioRegistrationDto.getCPF());
		user.setName(funcioRegistrationDto.getName());		
		user.setUsername(funcioRegistrationDto.getUsername());
		user.setPassword(passwordEncoder.encode(funcioRegistrationDto.getPassword()));
		user.setEmail(funcioRegistrationDto.getEmail());
		user.setAuthorities(new HashSet<Role>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
	
		{
			new Role("aut_func");
		}});
		return user;

		
	}

	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuário ou senha inválidos.");
		}
		return user;
	}	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
}
