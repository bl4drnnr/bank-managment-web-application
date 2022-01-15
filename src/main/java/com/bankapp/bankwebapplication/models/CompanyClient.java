package com.bankapp.bankwebapplication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyClient implements Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    private String companyName;

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    private String nip;

    public String getNip() { return nip; }
    public void setNip(String nip) { this.nip = nip; }

    private String companyAddress;
    public String getAddress() { return companyAddress; }
    public void setAddress(String companyAddress) { this.companyAddress = companyAddress; }

    private String companyPhone;
    public String getCompanyPhone() { return companyPhone; }
    public void setCompanyPhone(String companyPhone) { this.companyPhone = companyPhone; }


    @Override
    public void getDetails() {

    }
}