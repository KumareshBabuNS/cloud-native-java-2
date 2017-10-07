package com.aljumaro.configtest.classic;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classic-context.xml");
	}

	public void setConfigurationProjectName(String projectName) {
		LogFactory.getLog(getClass()).info("the configuration project name is " + projectName);
	}
}
