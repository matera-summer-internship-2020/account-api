package com.matera.account.account;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findClientAccountsByClientId(UUID clientId) {
        return accountRepository.findAllByClientId(clientId);
    }

    public Account findAccountByAccountId(UUID clientId, UUID accountId) {
        return accountRepository.findByAccountIdAndClientId(clientId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't Found Account"));

    }

    public Account insertClientAccountByClientId(UUID clientId, AccountDTO account) {
        return accountRepository.save(new Account(clientId, account));
    }


    public Account updateAccountByAccountId(UUID clientId, UUID accountId, AccountDTO accountDTO) {
        Account account = accountRepository.findByAccountIdAndClientId(clientId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't Found Account"));
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setAccountTypeId(accountDTO.getAccountTypeId());
        account.setAgency(accountDTO.getAgency());
        account.setBalance(accountDTO.getBalance());
        return account;
    }

    public Account patchAccountByAccountId(UUID clientId, UUID accountId, AccountDTO accountDTO) {
        Optional<Account> account = accountRepository.findByAccountIdAndClientId(clientId, accountId);
        account.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't Found Account"));
        if (StringUtils.isNotBlank(accountDTO.getAccountNumber()))
            account.get().setAccountNumber(accountDTO.getAccountNumber());
        if (accountDTO.getAccountTypeId() != null)
            account.get().setAccountTypeId(accountDTO.getAccountTypeId());
        if (StringUtils.isNotBlank(accountDTO.getAgency()))
            account.get().setAgency(accountDTO.getAgency());
        if (accountDTO.getBalance() != null)
            account.get().setBalance(accountDTO.getBalance());
        accountRepository.save(account.get());
        return account.get();
    }

    public void deleteAccountByAccountId(UUID clientId, UUID accountId) {
        accountRepository.delete(accountRepository.findByAccountIdAndClientId(clientId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't Found Account")));

    }

}
