package com.matera.account.accounttype;

import javax.persistence.*;

@Entity
public class AccountType {

    @Id
    public int accountTypeId;
    public String accountType;

}


