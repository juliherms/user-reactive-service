package com.github.juliherms.userservice.service;

import com.github.juliherms.userservice.dto.UserDTO;
import com.github.juliherms.userservice.repository.UserRepository;
import com.github.juliherms.userservice.util.EntityDTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<UserDTO> all() {
        return this.userRepository.findAll()
                .map(EntityDTOUtil::toDTO);
    }

    public Mono<UserDTO> getUserById(final UUID userId){
        return this.userRepository.findById(userId)
                .map(EntityDTOUtil::toDTO);
    }

    public Mono<UserDTO> createUser(Mono<UserDTO> userDTOMono){
        return userDTOMono
                .map(EntityDTOUtil::toEntity)
                .flatMap(this.userRepository::save)
                .map(EntityDTOUtil::toDTO);
    }

    public Mono<UserDTO> updateUser(UUID id, Mono<UserDTO> userDTOMono){
        return this.userRepository.findById(id)
                .flatMap(u -> userDTOMono
                        .map(EntityDTOUtil::toEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(this.userRepository::save)
                .map(EntityDTOUtil::toDTO);
    }

    public Mono<Void> deleteUser(UUID id){
        return this.userRepository.deleteById(id);
    }
}
