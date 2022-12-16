package com.acesso.A.web.dto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acesso.A.repository.OpRepository;
import com.acesso.A.service.OpService;

@Controller
@RequestMapping("/operation")
public class OpRegistrationController {
	private OpService opService;
	
	public OpRegistrationController(OpService opService) {
		super();
		this.opService = opService;
	}
	
	@ModelAttribute("operation")
	public OpRegistrationDto OpRegistrationDto() {
		return new OpRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("operation", new OpRegistrationDto());
		return "operation";
	}
    @GetMapping(path = "/get")
    public List<OpRegistrationDto> getOp() {
        return opService.findAll();
    }
	
}
