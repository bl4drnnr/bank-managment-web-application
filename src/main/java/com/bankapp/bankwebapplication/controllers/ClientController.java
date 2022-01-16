package com.bankapp.bankwebapplication.controllers;

import com.bankapp.bankwebapplication.models.CompanyClient;
import com.bankapp.bankwebapplication.models.PersonClient;
import com.bankapp.bankwebapplication.repositories.CompanyClientRepository;
import com.bankapp.bankwebapplication.repositories.PersonalClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
public class ClientController {
    @Autowired
    PersonalClientRepository personalClientRepository;
    @Autowired
    CompanyClientRepository companyClientRepository;

    @GetMapping(path = "/clients")
    ModelAndView getClientsPage(ModelAndView modelAndView) {
        modelAndView.setViewName("client");
        return modelAndView;
    }

    @GetMapping(path = "/get-all-clients")
    ModelAndView getAllClients(ModelAndView modelAndView) {
        List<PersonClient> allPersonalClients = personalClientRepository.findAll();
        List<CompanyClient> allCompanies = companyClientRepository.findAll();

        modelAndView.setViewName("client");

        modelAndView.addObject("allPersonalClients", allPersonalClients);
        modelAndView.addObject("allCompanies", allCompanies);

        return modelAndView;
    }

    @RequestMapping(path = "/get-client-by-id")
    ModelAndView getClientById(HttpServletRequest request, ModelAndView modelAndView) {
        long id = Integer.parseInt(request.getParameter("id"));
        long clientTypePicker = Integer.parseInt(request.getParameter("clientTypePicker"));

        if (clientTypePicker == 1) {
            List<PersonClient> personClientById = personalClientRepository.findAllById(id);

            modelAndView.setViewName("client");
            modelAndView.addObject("allPersonalClients", personClientById);
        } else {
            List<CompanyClient> companyClientById = companyClientRepository.findAllById(id);

            modelAndView.setViewName("client");
            modelAndView.addObject("allCompanies", companyClientById);
        }

        return modelAndView;
    }

    @RequestMapping(path = "/delete-client-by-id")
    ModelAndView deleteClientById(HttpServletRequest request, ModelAndView modelAndView) {
        String companyId = request.getParameter("companyId");
        String personId = request.getParameter("personId");
        if (!Objects.equals(companyId, null)) {
            System.out.println("companyId: " + companyId);
        } else {
            System.out.println("personId: " + personId);
        }
        return getAllClients(modelAndView);
    }

}
