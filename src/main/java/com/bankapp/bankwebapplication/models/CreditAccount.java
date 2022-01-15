package com.bankapp.bankwebapplication.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CreditAccount implements Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @ManyToOne
    @JoinColumn(name = "pcid")
    private PersonClient personClient;

    public PersonClient getPersonalClient() {
        if (personClient != null) {
            return personClient;
        } else {
            return null;
        }
    }
    public void setPersonalClient(PersonClient personClient) { this.personClient = personClient; }

    @ManyToOne
    @JoinColumn(name = "ccid")
    private CompanyClient companyClient;

    public CompanyClient getCompanyClient() {
        if (companyClient != null) {
            return companyClient;
        } else {
            return null;
        }
    }
    public void setCompanyClient(CompanyClient companyClient) { this.companyClient = companyClient; }

    private Long amountOfMoney;
    public Long getAmountOfMoney() { return amountOfMoney; }
    public void setAmountOfMoney(Long amountOfMoney) { this.amountOfMoney = amountOfMoney; }

    public LocalDate expiredAt;
    public LocalDate getExpiredAt() { return expiredAt; }
    public void setExpiredAt(LocalDate expiredAt) { this.expiredAt = expiredAt; }

    @Override
    public void getDetails() {

    }
}
