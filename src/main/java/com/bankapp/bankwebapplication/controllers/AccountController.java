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
import java.util.Objects;

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
        String type = "List of all accounts:";

        modelAndView.setViewName("accounts");

        modelAndView.addObject("allDebitAccounts", allDebitAccounts);
        modelAndView.addObject("allCreditAccounts", allCreditAccounts);
        modelAndView.addObject("type", type);
        return modelAndView;
    }

    @RequestMapping(path = "/get-account-by-id")
    ModelAndView getAccountById(HttpServletRequest request, ModelAndView modelAndView) {
        long id = Integer.parseInt(request.getParameter("id"));
        long typeOfAccount = Integer.parseInt(request.getParameter("typeOfAccount"));
        long typeOfClient = Integer.parseInt(request.getParameter("typeOfClient"));

        if (typeOfAccount == 1) {
            List<CreditAccount> allCreditAccounts;
            String type = "";
            if (typeOfClient == 1) {
                type = "List of credit accounts for personal clients:";
                allCreditAccounts = creditAccountRepository.findAllBypcid(id);
            } else {
                type = "List of credit accounts for company clients:";
                allCreditAccounts = creditAccountRepository.findAllByccid(id);
            }
            modelAndView.setViewName("accounts");
            modelAndView.addObject("allCreditAccounts", allCreditAccounts);
            modelAndView.addObject("type", type);
        } else {
            List<DebitAccount> allDebitAccounts;
            String type = "";
            if (typeOfClient == 1) {
                type = "List of debit accounts for personal clients:";
                allDebitAccounts = debitAccountRepository.findAllBypcid(id);
            } else {
                type = "List of debit accounts for company clients:";
                allDebitAccounts = debitAccountRepository.findAllByccid(id);
            }
            modelAndView.setViewName("accounts");
            modelAndView.addObject("allDebitAccounts", allDebitAccounts);
            modelAndView.addObject("type", type);
        }
        return modelAndView;
    }

    @RequestMapping(path = "/delete-account-by-id")
    ModelAndView deleteAccountById(HttpServletRequest request, ModelAndView modelAndView) {
        String debitId = request.getParameter("debitId");
        String creditId = request.getParameter("creditId");

        if (!Objects.equals(debitId, null)) {
            debitAccountRepository.deleteById((long) Integer.parseInt(debitId));
        } else {
            creditAccountRepository.deleteById((long) Integer.parseInt(creditId));
        }

        return getAllAccounts(modelAndView);
    }

}