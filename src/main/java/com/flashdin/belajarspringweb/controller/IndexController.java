/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.dao.UserDAO;
import com.flashdin.belajarspringweb.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Fajar
 */
@Controller
public class IndexController {
    @Autowired
    private UserDAO userDAO;
    
    @GetMapping(path = "/")
    public String login() {
        return "/user/login";
    }

    @PostMapping(value = "/login")
    public String login(User param) {
        List<User> data = userDAO.login(param);
        if (data.size() <= 0) {
            return "redirect:/?failed";
        } else {
            return "redirect:/home";
        } 
    }
    
    @GetMapping(path = "/home")
    public String home() {
        return "/index";
    }
}
