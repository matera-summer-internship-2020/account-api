package com.matera.account.account;

import com.matera.account.accounttype.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountProjection {

    UUID getAccountId();

    UUID getClientId();

    AccountType getAccountTypeId();

    String getAgency();

    String getAccountNumber();

    BigDecimal getBalance();

}
