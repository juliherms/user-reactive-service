package com.github.juliherms.userservice.util;

import com.github.juliherms.userservice.dto.TransactionRequestDTO;
import com.github.juliherms.userservice.dto.TransactionResponseDTO;
import com.github.juliherms.userservice.dto.TransactionStatus;
import com.github.juliherms.userservice.dto.UserDTO;
import com.github.juliherms.userservice.entity.User;
import com.github.juliherms.userservice.entity.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class EntityDTOUtil {

    public static UserDTO toDTO(User user){
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user,dto);
        return dto;
    }

    public static User toEntity(UserDTO dto){
        User user = new User();
        BeanUtils.copyProperties(dto,user);
        return user;
    }

    public static UserTransaction toEntity(TransactionRequestDTO requestDTO){
        UserTransaction ut = new UserTransaction();
        ut.setUserId(requestDTO.getUserId());
        ut.setAmount(requestDTO.getAmount());
        ut.setTransactionDate(LocalDateTime.now());
        return ut;
    }

    public static  TransactionResponseDTO toDTO(TransactionRequestDTO requestDTO, TransactionStatus status){
        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setAmount(requestDTO.getAmount());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setStatus(status);
        return responseDTO;
    }
}
