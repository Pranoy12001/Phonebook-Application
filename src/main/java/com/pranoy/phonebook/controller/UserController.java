package com.pranoy.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pranoy
 */
@Controller
public class UserController {

    @RequestMapping(value = {"/", "index"})
    public String index() {
        return "index"; //JSP - WEB-INF -> view -> index.jsp
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
