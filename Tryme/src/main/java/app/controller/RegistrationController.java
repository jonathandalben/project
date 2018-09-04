package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.dto.UserDto;
import app.dto.UserInfoDto;

@Controller
public class RegistrationController {
	
	@GetMapping("/register")
	public String register(Model model){
		model.addAttribute("user", new UserDto());
		model.addAttribute("userInfo", new UserInfoDto());
		return "Register";
	}
	
	@PostMapping("/register")
	public String validateRegister(@ModelAttribute UserDto user, @ModelAttribute UserInfoDto userInfo, Model model){
		model.addAttribute("user", new UserDto());
		model.addAttribute("userInfo", new UserInfoDto());
		
		System.out.println(user);
		System.out.println(userInfo);
		return "Register";
	}
}
