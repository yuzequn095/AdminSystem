/*
 * Controller to control the page switch
 * Control .html pages
 */
package com.spring.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

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
    public String mainHandler(String username, String password){
        // return "main";
        return "redirect:/main.html"; // no longer post /login, redirect to main page
    }

    /*
     * Avoid refresh page
     * Repeat post request to main
     */
    @GetMapping("/main.html")
    public String mainPage(){
        return "main";
    }

}
