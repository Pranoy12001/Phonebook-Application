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
public class TestContactDAOUpdate {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contactDAO = context.getBean(ContactDAO.class);
        
        Contact c = new Contact();
        
        c.setName("Banta");
        c.setPhone("01915");
        c.setEmail("banta@gmail.com");
        c.setAddress("Test Address");
        c.setRemarks("Best");
        c.setContactId(1);
        
        contactDAO.update(c);
    }
    
}
