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
        long clientTypePicker = Integer.parseInt(request.getParameter("clientTypePicker"));
        if (clientTypePicker == 1) {
            List<CreditAccount> creditAccountById = creditAccountRepository.findAllById(id);

            modelAndView.setViewName("accounts");
            modelAndView.addObject("allCreditAccounts", creditAccountById);
        } else {
            List<DebitAccount> debitAccountById = debitAccountRepository.findAllById(id);

            modelAndView.setViewName("accounts");
            modelAndView.addObject("allDebitAccounts", debitAccountById);
        }
        return modelAndView;
    }

}