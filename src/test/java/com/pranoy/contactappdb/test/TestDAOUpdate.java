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
public class TestDAOUpdate {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userDAO = context.getBean(UserDAO.class);
        
        User u = new User();
        
        u.setName("Pranoy");
        u.setPhone("01915");
        u.setEmail("pranoy@orbund.com");
        u.setAddress("Test Address");
        u.setRole(2);
        u.setLoginStatus(2);
        u.setUserId(1);
        
        userDAO.update(u);
        
        System.out.println("-------------Data Updated---------");
    }
    
}
