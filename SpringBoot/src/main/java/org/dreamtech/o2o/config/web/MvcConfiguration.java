package org.dreamtech.o2o.config.web;

import javax.servlet.ServletException;

import org.dreamtech.o2o.interceptor.shopadmin.ShopLoginInterceptor;
import org.dreamtech.o2o.interceptor.shopadmin.ShopPermissionInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.code.kaptcha.servlet.KaptchaServlet;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\temp\\image\\upload\\");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean(name = "viewResolver")
	public ViewResolver createViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setApplicationContext(this.applicationContext);
		viewResolver.setCache(false);
		viewResolver.setPrefix("/WEB-INF/html/");
		viewResolver.setSuffix(".html");
		return viewResolver;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		multipartResolver.setMaxUploadSize(20971520);
		multipartResolver.setMaxInMemorySize(20971520);
		return multipartResolver;
	}

	@Value("${kaptcha.border}")
	private String border;

	@Value("${kaptcha.textproducer.font.color}")
	private String fcolor;

	@Value("${kaptcha.image.width}")
	private String width;

	@Value("${kaptcha.textproducer.char.string}")
	private String cString;

	@Value("${kaptcha.image.height}")
	private String height;

	@Value("${kaptcha.textproducer.font.size}")
	private String fsize;

	@Value("${kaptcha.noise.color}")
	private String nColor;

	@Value("${kaptcha.textproducer.char.length}")
	private String clength;

	@Value("${kaptcha.textproducer.font.names}")
	private String fnames;

	@Bean
	public ServletRegistrationBean servletRegistrationBean() throws ServletException {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new KaptchaServlet(), "/Kaptcha");
		servlet.addInitParameter("kaptcha.border", border);
		servlet.addInitParameter("kaptcha.textproducer.font.color", fcolor);
		servlet.addInitParameter("kaptcha.image.width", width);
		servlet.addInitParameter("kaptcha.textproducer.char.string", cString);
		servlet.addInitParameter("kaptcha.image.height", height);
		servlet.addInitParameter("kaptcha.textproducer.font.size", fsize);
		servlet.addInitParameter("kaptcha.noise.color", nColor);
		servlet.addInitParameter("kaptcha.textproducer.char.length", clength);
		servlet.addInitParameter("kaptcha.textproducer.font.names", fnames);
		return servlet;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String interceptPath = "/shopadmin/**";
		InterceptorRegistration loginIR = registry.addInterceptor(new ShopLoginInterceptor());
		loginIR.addPathPatterns(interceptPath);
		loginIR.excludePathPatterns("/shopadmin/addshopauthmap");
		loginIR.excludePathPatterns("/shopadmin/adduserproductmap");
		loginIR.excludePathPatterns("/shopadmin/exchangeaward");
		InterceptorRegistration permissionIR = registry.addInterceptor(new ShopPermissionInterceptor());
		permissionIR.addPathPatterns(interceptPath);
		permissionIR.excludePathPatterns("/shopadmin/shoplist");
		permissionIR.excludePathPatterns("/shopadmin/getshoplist");
		permissionIR.excludePathPatterns("/shopadmin/getshopinitinfo");
		permissionIR.excludePathPatterns("/shopadmin/registershop");
		permissionIR.excludePathPatterns("/shopadmin/shopoperation");
		permissionIR.excludePathPatterns("/shopadmin/shopmanagement");
		permissionIR.excludePathPatterns("/shopadmin/getshopmanagementinfo");
		permissionIR.excludePathPatterns("/shopadmin/addshopauthmap");
		permissionIR.excludePathPatterns("/shopadmin/adduserproductmap");
		permissionIR.excludePathPatterns("/shopadmin/exchangeaward");
	}
}
