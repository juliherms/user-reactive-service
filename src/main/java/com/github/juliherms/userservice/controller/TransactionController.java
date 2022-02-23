package com.github.juliherms.userservice.controller;

import com.github.juliherms.userservice.dto.TransactionRequestDTO;
import com.github.juliherms.userservice.dto.TransactionResponseDTO;
import com.github.juliherms.userservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * This method responsible to create transaction
     * @param requestDTOMono
     * @return
     */
    @PostMapping
    public Mono<TransactionResponseDTO> createTransaction(@RequestBody Mono<TransactionRequestDTO> requestDTOMono){
        return requestDTOMono.flatMap(this.transactionService::createTransaction);
    }
}
