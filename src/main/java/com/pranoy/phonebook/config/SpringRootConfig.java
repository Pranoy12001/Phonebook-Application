package com.pranoy.phonebook.config;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Pranoy
 */
@Configuration
@ComponentScan(basePackages = {"com.pranoy.phonebook.dao"})
public class SpringRootConfig {
    //To Do :Services, DAO, DataSource, Email Sender and other business layer beans
    
    @Bean
    public BasicDataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/phonebookappdb");
        ds.setUsername("root");
        ds.setPassword("1234");
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
}
