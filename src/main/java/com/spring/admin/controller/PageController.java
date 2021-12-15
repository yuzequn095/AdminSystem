/*
 * Controller to control the page switch
 * Control .html pages
 */
package com.spring.admin.controller;

import com.spring.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    private String test_username = "admin";
    private String test_password = "admin";

    /*
     * Accept request
     * Indirect to login page
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage(){
        return "login";
    }

    /*
     * Jump to main page
     * with the post message from login
     */
    @PostMapping("/login")
    public String mainHandler(User user, HttpSession session, Model model){

        // check if username and password is empty
        //if(StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword())){
        if(test_username.equals(user.getUsername()) && test_password.equals(user.getPassword())){
            // store the user information
            session.setAttribute("login_user", user);

            // return "main";
            return "redirect:/main.html"; // no longer post /login, redirect to main page
            // return "main";
        }

        // else back to login page
        else{

            model.addAttribute("msg", "incorrect username or password");

            return "login";
        }

    }

    /*
     * Avoid refresh page
     * Repeat post request to main
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){

        // check if user is in login status
        // filter
        Object loginUser = session.getAttribute("login_user");
        if(loginUser != null){
            return "main";
        }
        // else back to login
        else{
            model.addAttribute("msg", "no user information detected");
            return "login";
        }
    }

}
