package com.SuperBankApplication.SuperBankApplication.model;

import java.math.BigDecimal;

public class TransferBalance {

    private Long from;
    private Long to;
    private BigDecimal amount;

    public TransferBalance(Long from, Long to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public TransferBalance(){

    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
