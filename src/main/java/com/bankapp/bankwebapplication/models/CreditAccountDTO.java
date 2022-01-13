package com.bankapp.bankwebapplication.models;

import java.time.LocalDateTime;

public class CreditAccountDTO {

    private Long pcid;
    public Long getPcid() { return pcid; }
    public void setPcid(Long pcid) { this.pcid = pcid; }

    private Long ccid;
    public Long getCcid() { return ccid; }
    public void setCcid(Long ccid) { this.ccid = ccid; }

    private Long amountOfMoney;
    public Long getAmountOfMoney() { return amountOfMoney; }
    public void setAmountOfMoney(Long amountOfMoney) { this.amountOfMoney = amountOfMoney; }

    private LocalDateTime expiredAt;
    public LocalDateTime getExpiredAt() { return expiredAt; }
    public void setExpiredAt(LocalDateTime expiredAt) { this.expiredAt = expiredAt; }
}
