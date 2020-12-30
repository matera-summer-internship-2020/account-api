package com.matera.account.account;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.*;

@Entity
public class Account implements AccountProjection{

    // Constructor's

    public Account(){}

    public Account(UUID clientId, AccountDTO accountDTO) {
        this.accountId = accountDTO.getAccountId();
        this.clientId = clientId;
        this.accountTypeId = accountDTO.getAccountTypeId();
        this.agency = accountDTO.getAgency();
        this.accountNumber = accountDTO.getAccountNumber();
        this.balance = accountDTO.getBalance();
    }


    // Properties

    @Id
    @Column(name = "ACCOUNT_ID")
    private UUID accountId;

    @Column(name = "CLIENT_ID")
    private UUID clientId;

    @Column(name = "ACCOUNT_TYPE_ID")
    private Integer accountTypeId;

    @Column(name = "AGENCY")
    private String agency;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    // Methods

    @PrePersist
    public void prePersist() {              // Auto Generate UUID before save in DB
        this.accountId = UUID.randomUUID();
    }

    // Getter's & Setter's

    @Override
    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    @Override
    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    @Override
    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Override
    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
