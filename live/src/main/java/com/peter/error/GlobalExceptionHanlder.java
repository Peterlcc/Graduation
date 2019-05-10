package com.peter.error;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHanlder {
	@Value("${live.errorpage.path}")
	private String errorPage="error";
	
	@ExceptionHandler(Exception.class)
	public ModelAndView excepitonHandle(Exception exception)
	{
		exception.printStackTrace();
		ModelAndView modelAndView=new ModelAndView(errorPage);
		modelAndView.addObject("errormsg", exception.getMessage());
		System.out.println("****************");
		return modelAndView;
	}
}
