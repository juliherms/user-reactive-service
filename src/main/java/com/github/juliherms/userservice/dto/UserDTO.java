package com.github.juliherms.userservice.dto;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class UserDTO {

    private UUID id;
    private String name;
    private Integer balance;
}
