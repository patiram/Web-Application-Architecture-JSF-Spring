/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rakeshshrestha
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String start(){
        return "redirect:/welcome";
    }
    
    @RequestMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "The one and only amazing webstore");
        
        return "welcome";
    }

}
