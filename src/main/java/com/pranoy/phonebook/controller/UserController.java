package com.pranoy.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pranoy
 */
@Controller
public class UserController {
    
    @RequestMapping(value = {"/","index"})
    public String index(){
        return "index"; //JSP - WEB-INF -> view -> index.jsp
    }
}
