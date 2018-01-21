package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

import javax.servlet.ServletRegistration;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"web"})
public class WebConfig extends WebMvcConfigurerAdapter {
	
	//视图解析器
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = 
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer 
			configurer) {
		configurer.enable();
	}
	
	/**
	 * 配置multipart解析器
	 * @return
	 */
	@Bean
	public MultipartResolver multipartResolver() throws IOException{
		return new StandardServletMultipartResolver();
	}
	
}
