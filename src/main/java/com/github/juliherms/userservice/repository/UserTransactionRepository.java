package com.github.juliherms.userservice.repository;

import com.github.juliherms.userservice.entity.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, UUID> {

}
