package com.matera.account.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public List<Account> findClientAccountsByClientId(UUID clientId) {
        List<Account> allAccounts = accountRepository.findAll();
        return allAccounts.stream()
                .filter(account -> account.getClientId().equals(clientId))
                .collect(Collectors.toList());
    }

    public Account findAccountByAccountId(UUID clientId, UUID accountId) {
        List<Account> allAccounts = findClientAccountsByClientId(clientId);
        return allAccounts.stream()
                .filter(account -> account.getAccountId().equals(accountId))
                .findFirst()
                .orElse(null);
    }

    public Account insertClientAccountByClientId(UUID clientId, AccountDTO account) {
        return accountRepository.save(new Account(clientId, account));
    }


    public Account updateAccountByAccountId(UUID clientId, UUID accountId, AccountDTO accountDTO) {
        Account account = findAccountByAccountId(clientId, accountId);
        if (account != null) {
            account.setAccountNumber(accountDTO.getAccountNumber());
            account.setAccountTypeId(accountDTO.getAccountTypeId());
            account.setAgency(accountDTO.getAgency());
            account.setBalance(accountDTO.getBalance());
            account.setClientId(accountDTO.getClientId());
            accountRepository.save(account);
        }
        return account;
    }

    public void deleteAccountByAccountId(UUID clientId, UUID accountId) {
        accountRepository.delete(findAccountByAccountId(clientId, accountId));
    }
}
