package com.github.juliherms.userservice.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@ToString
@Table("TB_USER")
public class User {

    @Id
    private UUID id;
    private String name;
    private Integer balance;
}
