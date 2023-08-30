package com.chatgpt.repository;

import com.chatgpt.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBalanceRepository extends JpaRepository<Balance, Long> {
}
