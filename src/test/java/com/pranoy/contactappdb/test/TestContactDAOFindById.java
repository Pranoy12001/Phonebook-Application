package com.pranoy.contactappdb.test;

import com.pranoy.phonebook.config.SpringRootConfig;
import com.pranoy.phonebook.dao.ContactDAO;
import com.pranoy.phonebook.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Pranoy
 */
public class TestContactDAOFindById {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contactDAO = context.getBean(ContactDAO.class);
        
        Contact c = contactDAO.findById(1);
        System.out.println("--------Show data--------");
        System.out.println(c.getContactId());
        System.out.println(c.getUserId());
        System.out.println(c.getName());
        System.out.println(c.getPhone());
        System.out.println(c.getEmail());
        System.out.println(c.getAddress());
        System.out.println(c.getRemarks());
    }
    
}
