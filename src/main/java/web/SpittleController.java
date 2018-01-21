package web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import config.exceptionConfig.SpittleNotFoundException;
import entity.Spittle;
import root.SpittleRepository;

@Controller
@RequestMapping("/spi")
public class SpittleController {
	
	@Autowired
	private SpittleRepository repository;
	
	
	@RequestMapping("/model")
	public String spittles(Model model) throws Exception{
//		model.addAttribute("spittleList",repository.findSpittles(Long.MAX_VALUE, 
//				20));
		model.addAttribute(repository.findSpittles(Long.MAX_VALUE, 
				20));
		if (true){
			throw new SpittleNotFoundException();
		}
		
		return "spittles";
	}
	
	
	@RequestMapping(value="/map",method=RequestMethod.GET)
	public String spittles(Map<String,Object> map){
		map.put("spittleList",repository.findSpittles(Long.MAX_VALUE, 
				20));
		return "spittles";
	}
	
	@RequestMapping(value="/param",method=RequestMethod.GET)
	public String spittles(@RequestParam(value= "max",defaultValue="230182") long max, 
			@RequestParam(value="count",defaultValue="1") int count,
			Model model){
		model.addAttribute(repository.findSpittles(Long.MAX_VALUE, 
				20));
		return "spittles";
	}
	
	@RequestMapping(value="/path/{spittleId}",method=RequestMethod.GET)
	public String spittles(@PathVariable long spittleId,
			Model model){
		model.addAttribute(repository.findSpittles(Long.MAX_VALUE, 
				20));
		return "spittles";
	}
}
