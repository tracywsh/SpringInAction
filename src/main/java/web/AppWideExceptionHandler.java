package web;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import config.exceptionConfig.SpittleNotFoundException;

@ControllerAdvice
public class AppWideExceptionHandler {
	
	@ExceptionHandler(SpittleNotFoundException.class)
	public String handleSpittleNotFound(){
		return "home";
	}
}
