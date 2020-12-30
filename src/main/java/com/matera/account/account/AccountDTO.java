package com.matera.account.account;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountDTO implements AccountProjection{

    // Properties

    private UUID accountId;

    private UUID clientId;

    private Integer accountTypeId;

    private String agency;

    private String accountNumber;

    private BigDecimal balance;

    @Override
    public UUID getAccountId() {
        return accountId;
    }

    @Override
    public UUID getClientId() {
        return clientId;
    }

    @Override
    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    @Override
    public String getAgency() {
        return agency;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

}
