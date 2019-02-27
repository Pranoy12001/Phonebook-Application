package com.pranoy.contactappdb.test;

import com.pranoy.phonebook.config.SpringRootConfig;
import com.pranoy.phonebook.dao.UserDAO;
import com.pranoy.phonebook.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Pranoy
 */
public class TestUserDAOFindByAll {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userDAO = context.getBean(UserDAO.class);
        
        List<User> users = userDAO.findAll();
        for(User u : users){
            System.out.println(u.getUserId());
            System.out.println(u.getPhone());
            System.out.println(u.getEmail());
            System.out.println(u.getAddress());
            System.out.println(u.getLoginName());
            System.out.println(u.getRole());
            System.out.println(u.getLoginStatus());
        }
    }
    
}
