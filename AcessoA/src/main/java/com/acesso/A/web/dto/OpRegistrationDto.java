package com.acesso.A.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class OpRegistrationDto {
	private Long id;
	
	private String placa;
	private String logName;
	private String clientName;
	private int tara;
	private boolean entry;
	private boolean eCopies;
	private int peso;
	private boolean endWO;
	
		
}
