package com.pranoy.phonebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Pranoy
 */
@Configuration
@ComponentScan(basePackages = {"com.pranoy"})
@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter{

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //to do
   }
   @Bean 
   public ViewResolver viewResolver(){
       InternalResourceViewResolver vr = new InternalResourceViewResolver();
       vr.setViewClass(JstlView.class);
       vr.setPrefix("/WEB-INF/view/");
       vr.setSuffix(".jsp");
       return vr;
   } 
}
