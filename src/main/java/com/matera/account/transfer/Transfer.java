package com.matera.account.transfer;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.UUID;

public class Transfer {

    // Attributes

    private String agencySent;
    private String accountNumberSent;
    private UUID clientId;
    private String agencyReceiver;
    private String accountNumberReceiver;
    private BigDecimal value;
    private Calendar transferDate;

    // Constructor's

    public Transfer(UUID clientId, BigDecimal value) {
        this.clientId = clientId;
        this.value = value;
    }

    // Getter's & Setter's

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Calendar getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Calendar transferDate) {
        this.transferDate = transferDate;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getAgencySent() {
        return agencySent;
    }

    public void setAgencySent(String agencySent) {
        this.agencySent = agencySent;
    }

    public String getAccountNumberSent() {
        return accountNumberSent;
    }

    public void setAccountNumberSent(String accountNumberSent) {
        this.accountNumberSent = accountNumberSent;
    }

    public String getAgencyReceiver() {
        return agencyReceiver;
    }

    public void setAgencyReceiver(String agencyReceiver) {
        this.agencyReceiver = agencyReceiver;
    }

    public String getAccountNumberReceiver() {
        return accountNumberReceiver;
    }

    public void setAccountNumberReceiver(String accountNumberReceiver) {
        this.accountNumberReceiver = accountNumberReceiver;
    }

}
