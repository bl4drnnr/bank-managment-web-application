package com.bankapp.bankwebapplication.controllers;

import com.bankapp.bankwebapplication.models.CompanyClient;
import com.bankapp.bankwebapplication.models.PersonClient;
import com.bankapp.bankwebapplication.repositories.CompanyClientRepository;
import com.bankapp.bankwebapplication.repositories.PersonalClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Bank {
    @Autowired
    PersonalClientRepository personalClientRepository;
    @Autowired
    CompanyClientRepository companyClientRepository;

    @GetMapping(path = "/")
    ModelAndView getMainPage(ModelAndView modelAndView) {
        List<PersonClient> allPersonalClients = personalClientRepository.findAll();
        List<CompanyClient> allCompanies = companyClientRepository.findAll();

        modelAndView.setViewName("index");

        modelAndView.addObject("allPersonalClients", allPersonalClients);
        modelAndView.addObject("allCompanies", allCompanies);

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


}