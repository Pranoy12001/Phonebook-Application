package com.pranoy.contactappdb.test;

import com.pranoy.phonebook.config.SpringRootConfig;
import com.pranoy.phonebook.dao.ContactDAO;
import com.pranoy.phonebook.domain.Contact;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Pranoy
 */
public class TestContactDAOFindAll {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contactDAO = context.getBean(ContactDAO.class);
        
        List<Contact> contacts = contactDAO.findAll();
        
        System.out.println("------Showing Data-------");
        
        for(Contact c : contacts){
            System.out.println(c.getContactId());
            System.out.println(c.getUserId());
            System.out.println(c.getName());
            System.out.println(c.getPhone());
            System.out.println(c.getEmail());
            System.out.println(c.getAddress());
            System.out.println(c.getRemarks());
        }
    }
    
}
