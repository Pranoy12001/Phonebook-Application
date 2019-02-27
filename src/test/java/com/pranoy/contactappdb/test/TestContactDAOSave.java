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
public class TestContactDAOSave {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contactDAO = context.getBean(ContactDAO.class);
        
        Contact c = new Contact();
        
        c.setName("Rifat");
        c.setUserId(6);
        c.setPhone("01720");
        c.setEmail("rifat@gmail.com");
        c.setAddress("Test Addesss");
        c.setRemarks("Good");
        
        contactDAO.save(c);
    }
    
}
