package com.doj.citypages.web;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.config.BeanIds;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.doj.citypages.config.MailConfig.MailConfig;
import com.doj.citypages.web.config.CityPagesMvcConfig;
import com.doj.citypages.web.security.config.CityPageSecurityConfig;

/**
 * @author Dinesh.Rajput
 *
 */
public class CityPagesWebApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		 AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	        rootContext.register(CityPageSecurityConfig.class,CityPagesMvcConfig.class);
	        servletContext.addListener(new ContextLoaderListener(rootContext));
	       // AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
	       // dispatcherServlet.register(CityPagesMvcConfig.class);
	             
	        // Register and map the dispatcher servlet
	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
		//registerListener(servletContext);
		//registerDispatcherServlet(servletContext);
		registerSpringSecurityFilterChain(servletContext);
		registerOpenEntityManagerInViewFilter(servletContext);
	}
	
	/*private void registerListener(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext= new AnnotationConfigWebApplicationContext();
		rootContext.register(CityPageSecurityConfig.class,MailConfig.class);
    //    rootContext = createContext(CityPageSecurityConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
     //   servletContext.addListener(new RequestContextListener());

    }
	
	private void registerDispatcherServlet(ServletContext servletContext) {
		 AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		 dispatcherServlet.register(CityPagesMvcConfig.class);
		 ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
		WebApplicationContext dispatcherContext = createContext(CityPagesMvcConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}
	
	 *//**
     * Factory method to create {@link AnnotationConfigWebApplicationContext} instances. 
     * @param annotatedClasses
     * @return
     *//*
    private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(annotatedClasses);
        return context;
    }
*/    
    private void registerSpringSecurityFilterChain(ServletContext servletContext) {
		FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter(
				BeanIds.SPRING_SECURITY_FILTER_CHAIN, new DelegatingFilterProxy());
		springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
	}
    
    private void registerOpenEntityManagerInViewFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic registration = servletContext.addFilter("openEntityManagerInView",
				new OpenEntityManagerInViewFilter());
		registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false,
				"*.htm");
		registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false,
				"/j_spring_security_check");
	}
}
