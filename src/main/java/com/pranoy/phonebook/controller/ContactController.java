package com.pranoy.phonebook.controller;

import com.pranoy.phonebook.domain.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pranoy
 */
@Controller
public class ContactController {
    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model m){
        Contact contact = new Contact();
        m.addAttribute("command", contact);
        return "contact_form"; //JSP form view
    }  
}
