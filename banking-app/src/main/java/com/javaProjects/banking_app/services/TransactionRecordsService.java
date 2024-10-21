package com.javaProjects.banking_app.services;

import java.time.LocalDate;
import java.util.List;

import com.javaProjects.banking_app.dto.TransactionRecordsDto;

public interface TransactionRecordsService {
    void saveTransaction(TransactionRecordsDto transactionRecordsDto);

    List<TransactionRecordsDto> getLastFiveTransactions(String accountId);

    List<TransactionRecordsDto> getTransactionByDateRange(String accountId, LocalDate startDate, LocalDate endDate);

    List<TransactionRecordsDto> getAllTransactions(String accountId);
}
