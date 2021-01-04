package com.matera.account.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Account> findAccountByAccountId(UUID clientId, UUID accountId) {
        return accountRepository.findByAccountIdAndClientId(clientId, accountId);
    }

    public Account insertClientAccountByClientId(UUID clientId, AccountDTO account) {
        return accountRepository.save(new Account(clientId, account));
    }


    public Optional<Account> updateAccountByAccountId(UUID clientId, UUID accountId, AccountDTO accountDTO) {
        Optional<Account> account = findAccountByAccountId(clientId, accountId);
        if (account.isPresent()) {
            account.get().setAccountNumber(accountDTO.getAccountNumber());
            account.get().setAccountTypeId(accountDTO.getAccountTypeId());
            account.get().setAgency(accountDTO.getAgency());
            account.get().setBalance(accountDTO.getBalance());
            account.get().setClientId(accountDTO.getClientId());
            accountRepository.save(account.get());
        }
        return account;
    }

    public void deleteAccountByAccountId(UUID clientId, UUID accountId) {
        Optional<Account> account = findAccountByAccountId(clientId, accountId);
        if (account.isPresent())
            accountRepository.delete(account.get());

    }

}
