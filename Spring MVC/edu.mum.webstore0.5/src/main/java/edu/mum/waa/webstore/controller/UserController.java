package edu.mum.waa.webstore.controller;

import edu.mum.waa.webstore.domain.User;
import edu.mum.waa.webstore.service.UserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author patir
 */
@Controller
//@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getAuthentication(Model model, User user, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes, @CookieValue (value="userId", defaultValue = "") String userId) {
        if (userService.authenticate(user)) {
            if(user.isRememberUserId()){
            Cookie cookie = new Cookie("userId", user.getUserId());
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);
            }else{
            Cookie cookie = new Cookie("userId", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            }
            model.addAttribute("user", user);
            request.getSession().setAttribute("user",user);
            redirectAttributes.addFlashAttribute("taglines","The one and only amazing webstore");
            System.out.println(user.isRememberUserId());
            return "redirect:/welcome";
        } else {
            throw new IllegalArgumentException("username/password error");
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(SessionStatus status, HttpServletRequest request) {
        //status.setComplete();
        request.getSession().invalidate();
        return "login";
    }

}
