package com.matera.account.transfer;

import com.matera.account.account.Account;
import com.matera.account.account.AccountRepository;
import com.matera.account.account.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class TransferService {

    private final AccountService accountService;
    private final AccountRepository accountRepository;

    public TransferService(AccountService accountService, AccountRepository accountRepository){
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    public Transfer cashTransfer(UUID clientId, Transfer transfer) {
        List<Account> accounts_1 = accountService.findClientAccountsByClientId(clientId);
        List<Account> accounts_2 = accountService.findClientAccountsByClientId(transfer.getClientId());
        Account account_sent = accounts_1.get(0);
        Account account_receiver = accounts_2.get(0);
        if (account_sent.getBalance().compareTo(transfer.getValue()) >= 0) {
            account_sent.setBalance(account_sent.getBalance().subtract(transfer.getValue()));
            account_receiver.setBalance(account_receiver.getBalance().add(transfer.getValue()));
            transfer.setTransferDate(Calendar.getInstance());
            transfer.setAgencySent(account_sent.getAgency());
            transfer.setAccountNumberSent(account_sent.getAccountNumber());
            transfer.setAgencyReceiver(account_receiver.getAgency());
            transfer.setAccountNumberReceiver(account_receiver.getAccountNumber());
            accountRepository.save(account_sent);
            accountRepository.save(account_receiver);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo Insuficiente");
        }
        return transfer;
    }
}
