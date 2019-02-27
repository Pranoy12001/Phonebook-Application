package com.pranoy.contactappdb.test;

import com.pranoy.phonebook.config.SpringRootConfig;
import com.pranoy.phonebook.domain.User;
import com.pranoy.phonebook.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Pranoy
 */
public class TestUserServiceResgister {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserService userService = context.getBean(UserService.class);
        
        User u = new User();
        
        u.setName("Pinki Saha");
        u.setPhone("01960");
        u.setEmail("pinki@gmail.com");
        u.setAddress("Test Address");
        u.setLoginName("Pinki");
        u.setPassword("1234");
        u.setRole(UserService.ROLE_ADMIN);
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        
        userService.register(u);
        
        System.out.println("------ Registration done successfully -----");
    }
    
}
