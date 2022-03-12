package com.github.juliherms.userservice.dto;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class TransactionRequestDTO {

    private Integer userId;
    private Integer amount;
}

