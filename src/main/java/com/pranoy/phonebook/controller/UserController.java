package com.pranoy.phonebook.controller;

import com.pranoy.phonebook.command.LoginCommand;
import com.pranoy.phonebook.command.UserCommand;
import com.pranoy.phonebook.domain.User;
import com.pranoy.phonebook.exception.UserBlockedException;
import com.pranoy.phonebook.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
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
                    //add user details in session
                    addUserInSession(loggedInUser, session);
                    return "redirect:admin/dashboard";
                }else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
                    //add user details in session
                    addUserInSession(loggedInUser, session);
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
    
    @RequestMapping(value = {"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=lo"; //JSP
    }

    @RequestMapping(value = {"/user/dashboard"})
    public String userDashBoard() {
        return "dashboard_user"; //JSP - WEB-INF -> view -> dashboard_user.jsp
    }

    @RequestMapping(value = "/admin/dashboard")
    public String adminDashBoard() {
        return "dashboard_admin"; //JSP - WEB-INF -> view -> dashboard_admin.jsp
    }
    
    @RequestMapping(value = "/admin/users")
    public String getUserList(Model m) {
        m.addAttribute("userList", userService.getUserList());
        return "users"; //JSP - WEB-INF -> view -> users.jsp
    }
    
    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m){
        UserCommand cmd = new UserCommand();
        m.addAttribute("command", cmd);
        return "reg_form"; //JSP 
    }
    
    @RequestMapping(value = "/register")
    public String registrationForm(@ModelAttribute("command") UserCommand cmd,Model m){
        try {
            User u = cmd.getUser();
            u.setRole(UserService.ROLE_USER);
            u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userService.register(u);
            return "redirect:index?act=reg";
        } catch (DuplicateKeyException ex) {
            ex.printStackTrace();
            m.addAttribute("err", "Username is already taken. Please select another username");
            return "reg_form";
        }
    }
    
    private void addUserInSession(User u, HttpSession session){
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }
    
    @RequestMapping(value = "/admin/change_status")
    @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus){
        try {
            userService.changeLoginStatus(userId, loginStatus);
            return "SUCCESS: Status Changed.";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: Unable to change status.";
        }
    }
}
