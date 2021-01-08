package com.matera.account.centralregister;

import com.matera.account.dto.CentralRegisterClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.UUID;

@Service
public class CentralRegisterService {

    private final RestTemplate restTemplate;

    @Autowired
    public CentralRegisterService(@Value("${central-register.url}") String centralRegisterUrl,
                                  final RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder
                .uriTemplateHandler(new DefaultUriBuilderFactory(centralRegisterUrl))
                .build();
    }

    public CentralRegisterClientResponse findClient(final UUID clientId) {
        try {
            return this.restTemplate.getForObject("/clients/{clientId}", CentralRegisterClientResponse.class, clientId);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage());
        }
    }
}
