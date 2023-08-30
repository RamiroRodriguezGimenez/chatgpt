package com.chatgpt.repository;

import com.chatgpt.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepository extends JpaRepository<Currency, Long> {
}
