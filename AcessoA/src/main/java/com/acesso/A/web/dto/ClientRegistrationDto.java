package com.acesso.A.web.dto;

import com.acesso.A.model.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class ClientRegistrationDto {
	
	private Long id;
	
	private String name;
	
	private Client client;
}
