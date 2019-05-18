package com.peter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.peter.mapper")
@ServletComponentScan("com.peter.listener")
//@ImportResource(locations= {"classpath:mykaptcha.xml"})
public class LiveApplication extends SpringBootServletInitializer{

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LiveApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LiveApplication.class, args);
	}

}
