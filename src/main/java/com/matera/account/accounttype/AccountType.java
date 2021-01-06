package com.matera.account.accounttype;

import javax.persistence.*;

@Entity
public class AccountType {

    @Id
    public int accountTypeId;
    public String accountType;

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}


