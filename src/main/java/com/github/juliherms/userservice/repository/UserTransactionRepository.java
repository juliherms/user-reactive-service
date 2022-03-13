package com.github.juliherms.userservice.repository;

import com.github.juliherms.userservice.entity.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, Integer> {

    /**
     * List transactions by userId
     * @param userId
     * @return
     */
    Flux<UserTransaction> findByUserId(int userId);
}
