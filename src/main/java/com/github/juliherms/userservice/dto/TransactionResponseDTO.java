package com.github.juliherms.userservice.dto;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class TransactionResponseDTO {

    private Integer userId;
    private Integer amount;
    private TransactionStatus status;
}
