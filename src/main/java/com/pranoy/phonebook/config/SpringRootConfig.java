package com.pranoy.phonebook.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Pranoy
 */
@Configuration
@ComponentScan(basePackages = {"com.pranoy"})
public class SpringRootConfig {
    //To Do :Services, DAO, DataSource, Email Sender and other business layer beans
}
