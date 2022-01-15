package com.bankapp.bankwebapplication.controllers;

import com.bankapp.bankwebapplication.models.CreditAccount;
import com.bankapp.bankwebapplication.models.DebitAccount;
import com.bankapp.bankwebapplication.repositories.CreditAccountRepository;
import com.bankapp.bankwebapplication.repositories.DebitAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    CreditAccountRepository creditAccountRepository;
    @Autowired
    DebitAccountRepository debitAccountRepository;

    @GetMapping(path = "/accounts")
    ModelAndView getAccountsPage(ModelAndView modelAndView) {
        modelAndView.setViewName("accounts");
        return modelAndView;
    }

    @GetMapping(path = "/get-all-accounts")
    ModelAndView getAllAccounts(ModelAndView modelAndView){
        List<DebitAccount> allDebitAccounts = debitAccountRepository.findAll();
        List<CreditAccount> allCreditAccounts = creditAccountRepository.findAll();

        modelAndView.setViewName("accounts");

        modelAndView.addObject("allDebitAccounts", allDebitAccounts);
        modelAndView.addObject("allCreditAccounts", allCreditAccounts);
        return modelAndView;
    }

    @RequestMapping(path = "/get-account-by-id")
    ModelAndView getAccountById(HttpServletRequest request, ModelAndView modelAndView) {
        long id = Integer.parseInt(request.getParameter("id"));
        long typeOfAccount = Integer.parseInt(request.getParameter("typeOfAccount"));
        long typeOfClient = Integer.parseInt(request.getParameter("typeOfClient"));

        if (typeOfAccount == 1) {
            List<CreditAccount> allCreditAccounts;
            if (typeOfClient == 1) {
                allCreditAccounts = creditAccountRepository.findAllBypcid(id);
            } else {
                allCreditAccounts = creditAccountRepository.findAllByccid(id);
            }
            modelAndView.setViewName("accounts");
            modelAndView.addObject("allCreditAccounts", allCreditAccounts);
            return modelAndView;
        } else {
            List<DebitAccount> allDebitAccounts;
            if (typeOfClient == 1) {
                allDebitAccounts = debitAccountRepository.findAllBypcid(id);
            } else {
                allDebitAccounts = debitAccountRepository.findAllByccid(id);
            }
            modelAndView.setViewName("accounts");
            modelAndView.addObject("allDebitAccounts", allDebitAccounts);
            return modelAndView;
        }
    }

}