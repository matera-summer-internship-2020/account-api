package com.matera.account.dto;

import java.util.UUID;

public class CentralRegisterClientResponse {

    private UUID clientId;
    private String name;
    private MaritalStatusEntity maritalStatusEntity;

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaritalStatusEntity getMaritalStatusEntity() {
        return maritalStatusEntity;
    }

    public void setMaritalStatusEntity(MaritalStatusEntity maritalStatusEntity) {
        this.maritalStatusEntity = maritalStatusEntity;
    }
}
