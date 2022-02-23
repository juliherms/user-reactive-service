package com.github.juliherms.userservice.service;

import com.github.juliherms.userservice.dto.TransactionRequestDTO;
import com.github.juliherms.userservice.dto.TransactionResponseDTO;
import com.github.juliherms.userservice.dto.TransactionStatus;
import com.github.juliherms.userservice.repository.UserRepository;
import com.github.juliherms.userservice.repository.UserTransactionRepository;
import com.github.juliherms.userservice.util.EntityDTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * This class responsible to implements logical business from transactions
 */
@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransactionRepository transactionRepository;

    /**
     * Method responsible to create transaction and update balance
     * @param requestDTO
     * @return
     */
    public Mono<TransactionResponseDTO> createTransaction(final TransactionRequestDTO requestDTO){
        return this.userRepository.updateUserBalance(requestDTO.getUserId(),requestDTO.getAmount())
                .filter(Boolean::booleanValue)
                .map(b -> EntityDTOUtil.toEntity(requestDTO))
                .flatMap(this.transactionRepository::save)
                .map(ut -> EntityDTOUtil.toDTO(requestDTO, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityDTOUtil.toDTO(requestDTO,TransactionStatus.DECLINED));
    }
}
