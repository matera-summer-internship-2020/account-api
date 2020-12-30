package com.matera.account.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    // List all Accounts
    public List<Account> getAll() {
        return accountService.findAll();
    }

    @GetMapping("/clients/{clientId}/accounts")
    // List all Accounts for a specific client
    public List<Account> getAccountsByClientId(@PathVariable("clientId") UUID clientId) {
        return accountService.findClientAccountsByClientId(clientId);
    }

    @GetMapping("/clients/{clientId}/accounts/{accountId}")
    // Find Account by accountId
    public Account getAccountByAccountId(@PathVariable("clientId") UUID clientId, @PathVariable("accountId") UUID accountId) {
        return accountService.findAccountByAccountId(clientId, accountId); //fix
    }

    @PostMapping("/client/{clientId}/accounts")
    // Create account for specific client
    public Account insertAccount(@PathVariable("clientId") UUID clientId, @RequestBody @Valid AccountDTO account) {
        return accountService.insertClientAccountByClientId(clientId, account);
    }

    @PutMapping("/clients/{clientId}/accounts/{accountId}")
    // Update Account properties by accountId
    public Account putAccountByAccountId(@PathVariable("clientId") UUID clientId, @PathVariable("accountId") UUID accountId,
                                         @RequestBody @Valid AccountDTO accountDTO) {
        return accountService.updateAccountByAccountId(clientId, accountId, accountDTO);
    }

    @DeleteMapping("/clients/{clientId}/accounts/{accountId}")
    // Delete Account by accountId
    public void deleteAccountByAccountId(@PathVariable("clientId") UUID clientId, @PathVariable("accountId") UUID accountId) {
        accountService.deleteAccountByAccountId(clientId, accountId);
    }
}
