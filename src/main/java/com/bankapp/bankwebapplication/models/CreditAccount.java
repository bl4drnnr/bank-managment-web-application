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

    public Long getPersonalClient() { return personClient.getId(); }
    public void setPersonClient(PersonClient personClient) { this.personClient = personClient; }

    @ManyToOne
    @JoinColumn(name = "ссid")
    private CompanyClient companyClient;

    public Long getCompanyClient() { return companyClient.getId(); }
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
