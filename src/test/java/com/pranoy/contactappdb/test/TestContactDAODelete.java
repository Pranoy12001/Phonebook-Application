package com.pranoy.contactappdb.test;

import com.pranoy.phonebook.config.SpringRootConfig;
import com.pranoy.phonebook.dao.ContactDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Pranoy
 */
public class TestContactDAODelete {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contactDAO = context.getBean(ContactDAO.class);
        
        contactDAO.delete(2);
    }
    
}
