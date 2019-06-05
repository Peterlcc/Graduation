package com.peter.error;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHanlder {
	@Value("${live.errorpage.path}")
	private String errorPage="error";
	private Logger logger=LoggerFactory.getLogger(GlobalExceptionHanlder.class);
	@ExceptionHandler(Exception.class)
	public ModelAndView excepitonHandle(Exception exception)
	{
		exception.printStackTrace();
		
		logger.error("error:{}",exception.getMessage()+System.lineSeparator()+Arrays.toString(exception.getStackTrace()));
		ModelAndView modelAndView=new ModelAndView(errorPage);
		modelAndView.addObject("errormsg", exception.getMessage());
		return modelAndView;
	}
}
