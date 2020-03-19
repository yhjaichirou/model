package com.yhj.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyApiConfig implements WebMvcConfigurer{
	  @Autowired
	  private TokenInterceptor tokenInterceptor;
	  
	  /**
	   * 针对异步的拦截器配置，拦截异步请求
	   * @param configurer
	  */  
	  @Override
	  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		  WebMvcConfigurer.super.configureAsyncSupport(configurer);
	        //比如如下给异步服务请求添加拦截器
	        //configurer.registerCallableInterceptors((CallableProcessingInterceptor) timeInterceptor);
	  }
	    
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
	      //注册tokenInterceptor拦截器
		  InterceptorRegistration ir = registry.addInterceptor(tokenInterceptor);
		  //配置拦截路径
		  ir.addPathPatterns("/api/**");
		  //配置不拦截路径
		  ir.addPathPatterns("/admin/**");
	  }
	 	
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//			registry.addResourceHandler("/layuiadmin/**/*.js")
//			.addResourceLocations("classpath:/static/layuiadmin/");
//			.setCacheControl(CacheControl.maxAge(timeDay, timeUnit).cachePublic());
	  }
}
