package com.bankapp.bankwebapplication.models;

public interface Account {

    Long getId();
    void setId(Long id);

    PersonClient getPersonalClient();
    void setPersonalClient(PersonClient personClient);

    CompanyClient getCompanyClient();
    void setCompanyClient(CompanyClient companyClient);

    Long getAmountOfMoney();
    void setAmountOfMoney(Long amountOfMoney);

    void getDetails();
}
