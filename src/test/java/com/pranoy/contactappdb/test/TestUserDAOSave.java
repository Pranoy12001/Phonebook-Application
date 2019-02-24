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
public class TestUserDAOSave {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userDAO = context.getBean(UserDAO.class);
        
        User u = new User();
        
        u.setName("Pranoy Das");
        u.setPhone("01915906490");
        u.setEmail("pranoy@orbund.com");
        u.setAddress("Test Address");
        u.setLoginName("Pranoy12001");
        u.setPassword("1234");
        u.setRole(1);
        u.setLoginStatus(1);
        
        userDAO.save(u);
        
        System.out.println("------Data Saved-----");
    }
    
}
