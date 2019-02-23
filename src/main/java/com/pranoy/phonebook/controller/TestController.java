package com.pranoy.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pranoy
 */
@Controller
public class TestController {
   @RequestMapping("test/hello")
   public String helloWorld(){
       return "hello";// -> WEB-INF > view > hello.jsp
   } 
}
