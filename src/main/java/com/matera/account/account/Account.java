package com.matera.account.account;

import com.matera.account.accounttype.AccountType;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Account implements AccountProjection{

    // Constructor's

    public Account(){}

    public Account(UUID clientId, AccountDTO accountDTO) {
        this.accountId = accountDTO.getAccountId();
        this.clientId = clientId;
        this.accountType = accountDTO.getAccountType();
        this.agency = accountDTO.getAgency();
        this.accountNumber = accountDTO.getAccountNumber();
        this.balance = accountDTO.getBalance();
    }


    // Properties

    @Id
    private UUID accountId;

    private UUID clientId;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    private String agency;

    private String accountNumber;

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
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
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
