package com.acesso.A.web.dto;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acesso.A.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientRegistrationController {
	@Resource(name = "clientService")
	private ClientService clientService;

	public ClientRegistrationController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	@ModelAttribute("client")
	public ClientRegistrationDto clientRegistrationDto() {
		return new ClientRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("client", new ClientRegistrationDto());
		return "client";
	}
	

}
