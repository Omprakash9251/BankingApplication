package com.javaProjects.banking_app.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaProjects.banking_app.dto.TransactionRecordsDto;
import com.javaProjects.banking_app.entities.TransactionRecords;
import com.javaProjects.banking_app.repositories.TransactionRepository;
import com.javaProjects.banking_app.services.TransactionRecordsService;

public class TransactionRecordServiceImpl implements TransactionRecordsService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionRecordsDto transactionRecordsDto) {
        TransactionRecords transactionRecords = new TransactionRecords();
        transactionRecords.setTransactionId(transactionRecordsDto.getTransactionId());
        transactionRecords.setTransactionType(transactionRecordsDto.getTransactionType());
        transactionRecords.setDescription(transactionRecordsDto.getDescription());
        transactionRecords.setDate(transactionRecordsDto.getDate());
        transactionRecords.setAmount(transactionRecordsDto.getAmount());
        transactionRecords.setAccount(transactionRecordsDto.getAccount());
    }

    @Override
    public List<TransactionRecordsDto> getLastFiveTransactions(String accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastFiveTransactions'");
    }

    @Override
    public List<TransactionRecordsDto> getTransactionByDateRange(String accountId, LocalDate startDate,
            LocalDate endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransactionByDateRange'");
    }

    @Override
    public List<TransactionRecordsDto> getAllTransactions(String accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllTransactions'");
    }

}
