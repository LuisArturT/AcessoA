package com.acesso.A.web.dto;

import com.acesso.A.model.Logistic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class LogRegistrationDto {
	private Long id;
	
	private String name;
	
	private Logistic logistic;

}
