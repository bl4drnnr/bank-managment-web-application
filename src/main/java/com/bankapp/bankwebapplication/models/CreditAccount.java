package com.bankapp.bankwebapplication.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CreditAccount implements Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    private Long amountOfMoney;
    public Long getAmountOfMoney() { return amountOfMoney; }
    public void setAmountOfMoney(Long amountOfMoney) { this.amountOfMoney = amountOfMoney; }

    public LocalDateTime expiredAt;
    public LocalDateTime getExpiredAt() { return expiredAt; }
    public void setExpiredAt(LocalDateTime expiredAt) { this.expiredAt = expiredAt; }

    @ManyToOne
    @JoinColumn(name = "pcid")
    private PersonClient personClient;

    public Long getPersonalClientId() { return personClient.getId(); }

    @ManyToOne
    @JoinColumn(name = "ссid")
    private CompanyClient companyClient;

    public Long getCompanyClientId() { return companyClient.getId(); }

    @Override
    public void getDetails() {

    }
}
