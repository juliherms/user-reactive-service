package com.github.juliherms.userservice.repository;

import com.github.juliherms.userservice.entity.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, UUID> {

    @Modifying
    @Query("update TB_USER set balance = balance - :amount where id = :userId and balance >= :amount")
    Mono<Boolean>  updateUserBalance(UUID userId, int amount);

}
