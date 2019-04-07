package com.pranoy.phonebook.controller;

import com.pranoy.phonebook.domain.Contact;
import com.pranoy.phonebook.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pranoy
 */
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model m){
        Contact contact = new Contact();
        m.addAttribute("command", contact);
        return "contact_form"; //JSP form view
    }
    @RequestMapping(value = "/user/save_contact")
    public String saveContact(@ModelAttribute("command") Contact c, Model m, HttpSession session){
        try {
           Integer userId = (Integer)session.getAttribute("userId");
            c.setUserId(userId);
            contactService.save(c);
        return "redirect:contact_list?act=sv"; //JSP form view 
        } catch (Exception e) {
            m.addAttribute("err", "Failed to save contact");
            return "contact_form";
        }
    }
    
    @RequestMapping(value = "/user/contact_list")
    public String contactList(Model m, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId));
        return "contact_list"; //JSP form view
    }
}
