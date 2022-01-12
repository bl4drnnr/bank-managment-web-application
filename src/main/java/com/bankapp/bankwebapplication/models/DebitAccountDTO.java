package com.bankapp.bankwebapplication.models;

public class DebitAccountDTO {

    private Long pcid;
    public Long getPcid() { return pcid; }
    public void setPcid(Long pcid) { this.pcid = pcid; }

    private Long ccid;
    public Long getCcid() { return ccid; }
    public void setCcid(Long ccid) { this.ccid = ccid; }


    private Long amountOfMoney;
    public Long getAmountOfMoney() { return amountOfMoney; }
    public void setAmountOfMoney(Long amountOfMoney) { this.amountOfMoney = amountOfMoney; }

}
