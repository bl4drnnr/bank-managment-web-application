package com.bankapp.bankwebapplication.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DebitAccount implements Account {
    @Id
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Интерфейс тут кажется должен быть transient чтобы создать его.
    // Надо будет это простестировать.
    // Возможно некоторые общие методы можно будет просто вынести в интерфейс.
//     remove id setter
//    private transient Client clientId;
    @ManyToOne
    @JoinColumn(name = "pcid")
    private PersonClient client;

    public Long getPersonalClientId() { return client.getId(); }

    @ManyToOne
    @JoinColumn(name = "ссid")
    private CompanyClient client2;

//    public Long getClientId() { return clientId.getId(); }
//    public void setClientId(Client clientId) { this.clientId = clientId; }

    private Long amountOfMoney;
    public Long getAmountOfMoney() { return amountOfMoney; }
    public void setAmountOfMoney(Long amountOfMoney) { this.amountOfMoney = amountOfMoney; }

    @Override
    public void getDetails() {

    }
}
