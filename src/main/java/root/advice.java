package root;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class advice {
	
	@Before("execution(** web.HomeController.home(..))")
	public void beforeHome(){
		System.out.println("before home");
	}
	
	@Pointcut("@annotation(entity.Action)")
	public void annotationPointCut(){};
	
	@After("annotationPointCut()")
	public void after(){
		System.out.println("调用之后");
	}
}
