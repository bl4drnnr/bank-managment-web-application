package com.bankapp.bankwebapplication.controllers;

import com.bankapp.bankwebapplication.models.CreditAccount;
import com.bankapp.bankwebapplication.models.DebitAccount;
import com.bankapp.bankwebapplication.repositories.CreditAccountRepository;
import com.bankapp.bankwebapplication.repositories.DebitAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    CreditAccountRepository creditAccountRepository;
    @Autowired
    DebitAccountRepository debitAccountRepository;

    @GetMapping(path = "/accounts")
    ModelAndView getMainPage(ModelAndView modelAndView){
        List<DebitAccount> allDebitAccounts = debitAccountRepository.findAll();
        List<CreditAccount> allCreditAccounts = creditAccountRepository.findAll();

        modelAndView.setViewName("accounts");

        modelAndView.addObject("allDebitAccounts", allDebitAccounts);
        modelAndView.addObject("allCreditAccounts", allCreditAccounts);
        return modelAndView;
    }

}