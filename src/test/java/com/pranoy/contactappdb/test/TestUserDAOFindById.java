package com.pranoy.contactappdb.test;

import com.pranoy.phonebook.config.SpringRootConfig;
import com.pranoy.phonebook.dao.UserDAO;
import com.pranoy.phonebook.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Pranoy
 */
public class TestUserDAOFindById {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userDAO = context.getBean(UserDAO.class);
        
        User u = userDAO.findById(5);
        
        System.out.println("-----User Details------");
        System.out.println(u.getUserId());
        System.out.println(u.getPhone());
        System.out.println(u.getEmail());
        System.out.println(u.getAddress());
        System.out.println(u.getLoginName());
        System.out.println(u.getRole());
        System.out.println(u.getLoginStatus());
    }
    
}
