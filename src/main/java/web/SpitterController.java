package web;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.Spitter;
import root.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	@Autowired
	private SpitterRepository spitterService;
	
	@RequestMapping("/register")
	public String showRegistrationForm(){
		return "registerForm";
	}
	
//	@RequestMapping(value = "/login", method=RequestMethod.POST)
//	public String doLogin(){
//		return "home";
//	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture, 
			@Valid Spitter spitter, Errors  errors, RedirectAttributes model){
		if (errors.hasErrors()){
			return "registerForm";
		}
		spitterService.save(spitter);
//		return "redirect:/spitter/" + spitter.getUsername();
		model.addAttribute("username", spitter.getUsername());
//		model.addAttribute("spitterId", "42");
		model.addFlashAttribute("spitter", spitter);
		return "redirect:/spitter/{username}";
	}
	
	
	@RequestMapping(value="/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username,
			Model model){
		if (!model.containsAttribute("spitter")){
			Spitter spi = spitterService.findByUserName(username);
			model.addAttribute(spi);
		}
		return "profile";
	}
}
