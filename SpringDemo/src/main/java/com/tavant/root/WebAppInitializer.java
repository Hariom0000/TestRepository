package com.tavant.root;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.tavant.hibernate.config.HibernateConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		  AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		  rootContext.register(HibernateConfig.class);
		  ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
		  container.addListener(contextLoaderListener);
	}
	
	/*@Override
	public void onStartup(ServletContext container) throws ServletException {
		  AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		  rootContext.register(HibernateConfig.class);
		  ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
		  container.addListener(contextLoaderListener);
		  container.setInitParameter("contextInitializerClasses", "com.tavant.root");
		  AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		  webContext.register(MvcConfiguration.class);
		  DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
		  ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
		  dispatcher.addMapping("/");
		
	}*/

}
