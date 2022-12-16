package com.acesso.A.web.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acesso.A.service.LogService;
import com.acesso.A.service.UserService;

@Controller
@RequestMapping("logistic")
public class LogRegistratonController {
	private LogService logService;;

	public LogRegistratonController(LogService logService) {
		super();
		this.logService = logService;
	}
	
	@ModelAttribute("logistics")
	public LogRegistrationDto logRegistrationDto() {
		return new LogRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("logistic", new LogRegistrationDto());
		return "logistics";
	}
}
