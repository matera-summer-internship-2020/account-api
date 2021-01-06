package com.matera.account.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
        account.setAccountType(accountDTO.getAccountType());
        account.setAgency(accountDTO.getAgency());
        account.setBalance(accountDTO.getBalance());
        accountRepository.save(account);
        return account;
    }

    public void deleteAccountByAccountId(UUID clientId, UUID accountId) {
        accountRepository.delete(accountRepository.findByAccountIdAndClientId(clientId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't Found Account")));

    }

}
