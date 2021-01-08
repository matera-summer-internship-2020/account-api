package com.matera.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.matera.account.account.Account;

import java.util.List;

@JsonPropertyOrder({"client", "accounts"})
public class ClientAccountsResponse {

    private CentralRegisterClientResponse centralRegisterClientResponse;
    private List<Account> accountList;

    public ClientAccountsResponse(final CentralRegisterClientResponse centralRegisterClientResponse, final List<Account> accountList) {
        this.centralRegisterClientResponse = centralRegisterClientResponse;
        this.accountList = accountList;
    }

    @JsonProperty("client")
    public CentralRegisterClientResponse getClientResponse() {
        return centralRegisterClientResponse;
    }

    public void setClientResponse(CentralRegisterClientResponse centralRegisterClientResponse) {
        this.centralRegisterClientResponse = centralRegisterClientResponse;
    }

    @JsonProperty("acccounts")
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
