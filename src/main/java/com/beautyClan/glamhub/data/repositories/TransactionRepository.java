package com.beautyClan.glamhub.data.repositories;

import com.beautyClan.glamhub.data.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
