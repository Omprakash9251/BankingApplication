package com.javaProjects.banking_app.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaProjects.banking_app.entities.TransactionRecords;

public interface TransactionRepository extends JpaRepository<TransactionRecords, String> {
    List<TransactionRecords> getLastFiveTransactions(String accountId);

    List<TransactionRecords> getTransactionsBetweenRange(String accountId, LocalDate startDate, LocalDate enDate);

    List<TransactionRecords> getAllTransactions(String accountId);
}
