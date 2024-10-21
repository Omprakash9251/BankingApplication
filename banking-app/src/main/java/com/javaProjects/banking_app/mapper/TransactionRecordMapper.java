package com.javaProjects.banking_app.mapper;

import com.javaProjects.banking_app.dto.TransactionRecordsDto;
import com.javaProjects.banking_app.entities.TransactionRecords;

public class TransactionRecordMapper {

    public static TransactionRecords mapToTransactionRecord(TransactionRecordsDto dto) {
        TransactionRecords transactionRecord = new TransactionRecords();
        transactionRecord.setTransactionId(dto.getTransactionId());
        transactionRecord.setTransactionType(dto.getTransactionType());
        transactionRecord.setDescription(dto.getDescription());
        transactionRecord.setDate(dto.getDate());
        transactionRecord.setAmount(dto.getAmount());
        transactionRecord.setAccount(dto.getAccount());
        return transactionRecord;
    }

    public static TransactionRecordsDto mapToTransactionRecordsDto(TransactionRecords transactionRecord) {
        return new TransactionRecordsDto(
                transactionRecord.getTransactionId(),
                transactionRecord.getTransactionType(),
                transactionRecord.getDescription(),
                transactionRecord.getDate(),
                transactionRecord.getAmount(),
                transactionRecord.getAccount());
    }
}
