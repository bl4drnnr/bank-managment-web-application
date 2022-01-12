package com.bankapp.bankwebapplication.services;

import com.bankapp.bankwebapplication.models.DebitAccount;
import com.bankapp.bankwebapplication.models.DebitAccountDTO;
import com.bankapp.bankwebapplication.repositories.CompanyClientRepository;
import com.bankapp.bankwebapplication.repositories.PersonalClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DebitAccountService {
    private static PersonalClientRepository personalClientRepository;
    private static CompanyClientRepository companyClientRepository;

    @Autowired
    public DebitAccountService(PersonalClientRepository personalClientRepository, CompanyClientRepository companyClientRepository) {
        DebitAccountService.personalClientRepository = personalClientRepository;
        DebitAccountService.companyClientRepository = companyClientRepository;
    }

    public static void map(DebitAccountDTO debitAccountDTO, DebitAccount debitAccount) {
        debitAccount.setAmountOfMoney(debitAccountDTO.getAmountOfMoney());

        if (debitAccountDTO.getPcid() != null) {
            debitAccount.setPersonalClient(personalClientRepository.findById(debitAccountDTO.getPcid()).get());
            debitAccount.setCompanyClient(null);
        } else {
            debitAccount.setPersonalClient(null);
            debitAccount.setCompanyClient(companyClientRepository.findById(debitAccountDTO.getCcid()).get());
        }
    }
}
