package com.peter.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.peter.mapper.MajorMapper;

@WebListener
public class ApplicationListener implements ServletContextListener{

	@Autowired
	private MajorMapper majorMapper;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);
		sce.getServletContext().setAttribute("allMajors", majorMapper.selectAll());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		ServletContextListener.super.contextDestroyed(sce);
	}

}
