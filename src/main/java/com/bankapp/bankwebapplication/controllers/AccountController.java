package com.bankapp.bankwebapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @GetMapping(path = "/accounts")
    ModelAndView getMainPage(ModelAndView modelAndView){

        modelAndView.setViewName("accounts");
        return modelAndView;
    }

}