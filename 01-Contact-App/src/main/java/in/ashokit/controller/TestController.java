package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		
		
		//Setting data in model to send to UI
		model.addAttribute("msg","Welcome To Java mini project");
		
		//Returning Logical View name
		return "index";
	}

}
