package com.finance.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finance.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByTransactionDateBetweenOrderByTtansactionDateDesc(LocalDateTime start, LocalDateTime end);

    @Query("SELECT t.category.name, SUM(t.amount) " + 
        "FROM Transaction t "+
        "WHERE t.transactionDate BETWEEN :start AND :end "+
        "AND t.category.type = 'EXPENSE' "+
        "GROUP BY t.category.name"
    )
    List<Object[]> getExpensesByCategory(
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end
    );



}
