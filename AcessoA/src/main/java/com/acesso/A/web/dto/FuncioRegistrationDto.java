package com.acesso.A.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class FuncioRegistrationDto {
	private Long id;
	private String username;

	private String email;
	
	private String CPF;
	
	private String name;

	private String password;	
}
