package com.bankapp.bankwebapplication.controllers;

import com.bankapp.bankwebapplication.models.CompanyClient;
import com.bankapp.bankwebapplication.models.PersonClient;
import com.bankapp.bankwebapplication.repositories.CompanyClientRepository;
import com.bankapp.bankwebapplication.repositories.CreditAccountRepository;
import com.bankapp.bankwebapplication.repositories.DebitAccountRepository;
import com.bankapp.bankwebapplication.repositories.PersonalClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    DebitAccountRepository debitAccountRepository;
    @Autowired
    CreditAccountRepository creditAccountRepository;

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
            try {
                companyClientRepository.deleteById(Long.parseLong(companyId));
            } catch (Exception err) {
                creditAccountRepository.deleteAllByccid(Long.parseLong(companyId));
                debitAccountRepository.deleteAllByccid(Long.parseLong(companyId));
                companyClientRepository.deleteById(Long.parseLong(companyId));
            }
        } else {
            try {
                personalClientRepository.deleteById(Long.parseLong(personId));
            } catch (Exception err) {
                debitAccountRepository.deleteAllBypcid(Long.parseLong(personId));
                creditAccountRepository.deleteAllBypcid(Long.parseLong(personId));
                personalClientRepository.deleteById(Long.parseLong(personId));
            }
        }

        return getAllClients(modelAndView);
    }

    @RequestMapping(path = "/change-person-data")
    ModelAndView changePersonData(HttpServletRequest request, ModelAndView modelAndView) {
        Long id = Long.valueOf(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String pesel = request.getParameter("pesel");
        String address = request.getParameter("address");
        String workPhone = request.getParameter("workPhone");
        String homePhone = request.getParameter("homePhone");

        personalClientRepository.updateClientData(
                id, firstName, lastName, pesel, address, workPhone, homePhone
        );

        return getAllClients(modelAndView);
    }

    @RequestMapping(path = "/change-company-data")
    ModelAndView changeCompanyData(HttpServletRequest request, ModelAndView modelAndView) {
        return getAllClients(modelAndView);
    }

}
