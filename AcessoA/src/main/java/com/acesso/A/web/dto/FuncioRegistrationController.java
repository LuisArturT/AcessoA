package com.acesso.A.web.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acesso.A.service.UserService;

@Controller
@RequestMapping("registration")
public class FuncioRegistrationController {
	private UserService userService;

	public FuncioRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("funcionario")
	public FuncioRegistrationDto funcioRegistrationDto() {
		return new FuncioRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("funcionario", new FuncioRegistrationDto());
		return "registration";
	}
	
	
	@PostMapping
	public String registerFuncioAccount(@ModelAttribute("funcionario") FuncioRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "login";
	}
}
