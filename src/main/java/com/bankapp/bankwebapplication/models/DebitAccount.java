package com.bankapp.bankwebapplication.models;

import javax.persistence.*;

@Entity
public class DebitAccount implements Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @ManyToOne
    @JoinColumn(name = "pcid")
    private PersonClient personClient;

    public Long getPersonalClient() {
        if (personClient != null) {
            return personClient.getId();
        } else {
            return null;
        }
    }
    public void setPersonalClient(PersonClient personClient) { this.personClient = personClient; }

    @ManyToOne
    @JoinColumn(name = "ссid")
    private CompanyClient companyClient;

    public Long getCompanyClient() {
        if (companyClient != null) {
            return companyClient.getId();
        } else {
            return null;
        }
    }
    public void setCompanyClient(CompanyClient companyClient) {this.companyClient = companyClient;}

    private Long amountOfMoney;
    public Long getAmountOfMoney() { return amountOfMoney; }
    public void setAmountOfMoney(Long amountOfMoney) { this.amountOfMoney = amountOfMoney; }

    @Override
    public void getDetails() {

    }
}
