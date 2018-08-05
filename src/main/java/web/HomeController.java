package web;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import root.A;
import root.B;
import root.Dao;
import root.SpitterUserService;

@Controller
@RequestMapping("/web")
public class HomeController implements InitializingBean{
	
	@Autowired
	private Dao dao;
	
	@Resource
	private A a;
	
	@Resource
	private B b;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		dao.addAnnotation();
		System.out.println("test");
		System.out.println(b.getStr());
		
		return "home";
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("************:" + HomeController.class.getResource("/").getFile());
		System.out.println("asdf");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(){
		dao.add();
		return "home";
	}
	
}
