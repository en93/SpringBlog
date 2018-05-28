package springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String showRegistration() {
		return "registerForm";
	}
}
