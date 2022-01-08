package com.bankapp.bankwebapplication.models;

import javax.persistence.*;

@Entity
public class PersonClient implements Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    private String firstName;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    private String lastName;

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    private String pesel;

    public String getPesel() { return pesel; }
    public void setPesel(String pesel) { this.pesel = pesel; }

    private String address;

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    private String workPhone;

    public String getWorkPhone() { return workPhone; }
    public void setWorkPhone(String workPhone) { this.workPhone = workPhone; }

    private String homePhone;

    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }

    @Override
    public void getDetails() {

    }
}
