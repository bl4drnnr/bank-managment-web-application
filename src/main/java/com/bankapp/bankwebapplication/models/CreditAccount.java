package com.bankapp.bankwebapplication.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class CreditAccount implements Account {
    @Id
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    private Long clientId;
    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

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

    @Override
    public void getDetails() {

    }
}
