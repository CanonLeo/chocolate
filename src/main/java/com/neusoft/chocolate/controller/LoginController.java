package com.neusoft.chocolate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class LoginController {

    @GetMapping(value = "login")
    public ModelAndView login(ModelAndView mv){
        mv.setViewName("login");
        return mv;
    }

}
