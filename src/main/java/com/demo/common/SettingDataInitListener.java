package com.demo.common;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

@Component
public class SettingDataInitListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		// 将 ApplicationContext 转化为 WebApplicationContext
		WebApplicationContext webApplicationContext =
				(WebApplicationContext)contextRefreshedEvent.getApplicationContext();
		// 从 webApplicationContext 中获取  servletContext
		ServletContext servletContext = webApplicationContext.getServletContext();
		// servletContext设置值
		servletContext.setAttribute("key", "value");
	}
}