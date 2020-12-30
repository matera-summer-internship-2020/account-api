package com.matera.account.account;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountProjection {

    UUID getAccountId();

    UUID getClientId();

    Integer getAccountTypeId();

    String getAgency();

    String getAccountNumber();

    BigDecimal getBalance();

}
