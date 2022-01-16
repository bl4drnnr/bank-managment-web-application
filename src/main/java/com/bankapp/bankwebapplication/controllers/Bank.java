package com.bankapp.bankwebapplication.controllers;

import com.bankapp.bankwebapplication.models.*;
import com.bankapp.bankwebapplication.repositories.CompanyClientRepository;
import com.bankapp.bankwebapplication.repositories.CreditAccountRepository;
import com.bankapp.bankwebapplication.repositories.DebitAccountRepository;
import com.bankapp.bankwebapplication.repositories.PersonalClientRepository;
import com.bankapp.bankwebapplication.services.CreditAccountService;
import com.bankapp.bankwebapplication.services.DebitAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Bank {
    @Autowired
    PersonalClientRepository personalClientRepository;
    @Autowired
    CompanyClientRepository companyClientRepository;
    @Autowired
    DebitAccountRepository debitAccountRepository;
    @Autowired
    CreditAccountRepository creditAccountRepository;

    @GetMapping(path = "/")
    ModelAndView getMainPage(ModelAndView modelAndView) {
        List<PersonClient> allPersonalClients = personalClientRepository.findAll();
        List<CompanyClient> allCompanies = companyClientRepository.findAll();
        List<DebitAccount> allDebitAccounts = debitAccountRepository.findAll();
        List<CreditAccount> allCreditAccounts = creditAccountRepository.findAll();

        modelAndView.setViewName("index");

        modelAndView.addObject("allPersonalClients", allPersonalClients);
        modelAndView.addObject("allCompanies", allCompanies);
        modelAndView.addObject("allDebitAccounts", allDebitAccounts);
        modelAndView.addObject("allCreditAccounts", allCreditAccounts);

        return modelAndView;
    }

    @PostMapping(path = "/person")
    String createPersonalClient(@ModelAttribute PersonClient personClient) {
        personalClientRepository.save(personClient);
        return "redirect:/";
    }

    @PostMapping(path = "/company")
    String createCompanyClient(@ModelAttribute CompanyClient companyClient) {
        companyClientRepository.save(companyClient);
        return "redirect:/";
    }

    @RequestMapping(path = "/person-debit")
    String createPersonalDebitAccount(HttpServletRequest request, @ModelAttribute DebitAccountDTO debitAccountDTO) {
        String pcid = request.getParameter("pcid");
        List<PersonClient> pc = personalClientRepository.findAllById(Long.valueOf(pcid));
        if (!pc.isEmpty()) {
            DebitAccount debitAccount = new DebitAccount();
            DebitAccountService.map(debitAccountDTO, debitAccount);
            debitAccountRepository.save(debitAccount);
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/company-debit")
    String createCompanyDebitAccount(HttpServletRequest request, @ModelAttribute DebitAccountDTO debitAccountDTO) {
        String ccid = request.getParameter("ccid");
        List<CompanyClient> cc = companyClientRepository.findAllById(Long.valueOf(ccid));
        if (!cc.isEmpty()) {
            DebitAccount debitAccount = new DebitAccount();
            DebitAccountService.map(debitAccountDTO, debitAccount);
            debitAccountRepository.save(debitAccount);
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/person-credit")
    String createPersonalCreditAccount(HttpServletRequest request, @ModelAttribute CreditAccountDTO creditAccountDTO) {
        String pcid = request.getParameter("pcid");
        List<PersonClient> pc = personalClientRepository.findAllById(Long.valueOf(pcid));
        if (!pc.isEmpty()) {
            CreditAccount creditAccount = new CreditAccount();
            CreditAccountService.map(creditAccountDTO, creditAccount);
            creditAccountRepository.save(creditAccount);
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/company-credit")
    String createCompanyCreditAccount(HttpServletRequest request, @ModelAttribute CreditAccountDTO creditAccountDTO) {
        String ccid = request.getParameter("ccid");
        List<CompanyClient> cc =companyClientRepository.findAllById(Long.valueOf(ccid));
        if (!cc.isEmpty()) {
            CreditAccount creditAccount = new CreditAccount();
            CreditAccountService.map(creditAccountDTO, creditAccount);
            creditAccountRepository.save(creditAccount);
        }
        return "redirect:/";
    }

}