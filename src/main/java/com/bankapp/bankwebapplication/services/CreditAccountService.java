package com.bankapp.bankwebapplication.services;

import com.bankapp.bankwebapplication.models.CreditAccount;
import com.bankapp.bankwebapplication.models.CreditAccountDTO;
import com.bankapp.bankwebapplication.repositories.CompanyClientRepository;
import com.bankapp.bankwebapplication.repositories.PersonalClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditAccountService {
    private static PersonalClientRepository personalClientRepository;
    private static CompanyClientRepository companyClientRepository;

    @Autowired
    public CreditAccountService(PersonalClientRepository personalClientRepository, CompanyClientRepository companyClientRepository) {
        CreditAccountService.personalClientRepository = personalClientRepository;
        CreditAccountService.companyClientRepository = companyClientRepository;
    }

    public static void map(CreditAccountDTO creditAccountDTO, CreditAccount creditAccount) {
        creditAccount.setAmountOfMoney(creditAccountDTO.getAmountOfMoney());
        creditAccount.setExpiredAt(creditAccountDTO.getExpiredAt());

        if (creditAccountDTO.getPcid() != null) {
            creditAccount.setPersonalClient(personalClientRepository.findById(creditAccountDTO.getPcid()).get());
            creditAccount.setPersonalClient(null);
        } else {
            creditAccount.setPersonalClient(null);
            creditAccount.setCompanyClient(companyClientRepository.findById(creditAccountDTO.getCcid()).get());
        }
    }
}
