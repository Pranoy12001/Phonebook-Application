package com.pranoy.contactappdb.test;

import com.pranoy.phonebook.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Pranoy
 */
public class TestDataSource {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = context.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "INSERT INTO user(name, phone, gmail, address, loginName, password)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{"Pranoy Das", "01915", "pranoy@gamil.com", "Test", "pranoy", "1234"};
        
        jt.update(sql, params);
        System.out.println("---------SQL EXECUTED----------");
    }
    
}
