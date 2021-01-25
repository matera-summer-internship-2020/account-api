package com.matera.account.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController (TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/{clientId}")
    public Transfer insertCashTransfer(@PathVariable UUID clientId, @RequestBody Transfer transfer){
        return transferService.cashTransfer(clientId, transfer);
    }
}
