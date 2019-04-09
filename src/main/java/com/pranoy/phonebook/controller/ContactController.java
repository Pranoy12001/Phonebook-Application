package com.pranoy.phonebook.controller;

import com.pranoy.phonebook.domain.Contact;
import com.pranoy.phonebook.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(value = "/user/edit_contact")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId){
        session.setAttribute("aContactId", contactId);
        Contact c = contactService.findByContactId(contactId);
        m.addAttribute("command", c);
        return "contact_form"; //JSP form view
    }
    
    @RequestMapping(value = "/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session){
        Integer contactId = (Integer) session.getAttribute("aContactId");
        if(contactId == null){
            //Save Opertaion
            try {
                Integer userId = (Integer)session.getAttribute("userId");
                c.setUserId(userId);
                contactService.save(c);
                return "redirect:contact_list?act=sv"; //JSP form view 
            } catch (Exception e) {
                m.addAttribute("err", "Failed to save contact");
                return "contact_form";
            }
        }else{
            //Update Opertaion
            try {
                c.setContactId(contactId);
                contactService.update(c);
                session.removeAttribute("aContactId");
                return "redirect:contact_list?act=edit"; //JSP form view 
             } catch (Exception e) {
                m.addAttribute("err", "Failed to edit contact");
                return "contact_form";
             }
        }
    }
    
    @RequestMapping(value = "/user/contact_list")
    public String contactList(Model m, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId));
        return "contact_list"; //JSP form view
    }
    
    @RequestMapping(value = "/user/contact_search")
    public String contactList(Model m, HttpSession session, @RequestParam("freeText") String freeText){
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId, freeText));
        return "contact_list"; //JSP form view
    }
    
    @RequestMapping(value = "//user/del_contact")
    public String deleteConatact(@RequestParam("cid") Integer contactId){
        contactService.delete(contactId);
        return "redirect:contact_list?act=del"; //JSP form view
    }
}
