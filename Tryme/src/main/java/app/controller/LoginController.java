package app.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.dto.UserDto;
import app.dto.UserInfoDto;
import app.service.UserService;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;

	@GetMapping({"/","/login"})
	public String loginPage(Model model) {
		logger.info("Login Page");
		model.addAttribute("user", new UserDto());
		return "Login";
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/")
	public String loginPageValidation(@ModelAttribute UserDto user, RedirectAttributes redirectAttrs, Model model) {
		Map checkMap = userService.checkUser(user);
		
		if(!(Boolean) checkMap.get("isAuthenticate")) {
			return "redirect:/login";
		}
		redirectAttrs.addFlashAttribute("userInfo", (UserInfoDto) checkMap.get("userInfo"));
		return "redirect:/dashboard";
	}

}
