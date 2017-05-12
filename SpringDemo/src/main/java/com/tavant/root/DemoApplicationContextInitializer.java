package com.tavant.root;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author hariom.singh This class execute before creation of spring context
 */
public class DemoApplicationContextInitializer implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext ac) {
		ConfigurableEnvironment appEnvironment = ac.getEnvironment();
		appEnvironment.addActiveProfile("demo");

	}
}
