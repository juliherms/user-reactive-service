package com.github.juliherms.userservice.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
@Table("TB_USER_TRANSACTION")
public class UserTransaction {

    @Id
    private UUID id;
    private UUID userId;
    private Integer amount;
    private LocalDateTime transactionDate;
}
