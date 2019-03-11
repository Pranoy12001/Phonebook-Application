package com.pranoy.phonebook.controller;

import com.pranoy.phonebook.command.LoginCommand;
import com.pranoy.phonebook.domain.User;
import com.pranoy.phonebook.exception.UserBlockedException;
import com.pranoy.phonebook.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Pranoy
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/", "index"})
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index"; //JSP - WEB-INF -> view -> index.jsp
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m) {
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
            if(loggedInUser == null){
                //Failed
                //add error message and go back to login form
                m.addAttribute("err", "Login Failed. Please Enter Valid Credentials.");
                return "index"; //JSP - WEB-INF -> view -> index.jsp  
            }else{
                //Success
                //check the role and redirect to the valid dashboard
                if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)){
                    return "redirect:admin/dashboard";
                }else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
                    return "redirect:user/dashboard";
                }else{
                    //add error message and go back to login form
                    m.addAttribute("err", "Login Failed. Invalid User Role.");
                    return "index"; //JSP - WEB-INF -> view -> index.jsp 
                }
            }
        } catch (UserBlockedException ex) {
            //add error message and go back to login form
            m.addAttribute("err", ex.getMessage());
            return "index"; //JSP - WEB-INF -> view -> index.jsp
        }
    }

    @RequestMapping(value = {"/user/dashboard"})
    public String userDashBoard() {
        return "dashboard_user"; //JSP - WEB-INF -> view -> dashboard_user.jsp
    }

    @RequestMapping(value = "/admin/dashboard")
    public String adminDashBoard() {
        return "dashboard_admin"; //JSP - WEB-INF -> view -> dashboard_admin.jsp
    }
}
