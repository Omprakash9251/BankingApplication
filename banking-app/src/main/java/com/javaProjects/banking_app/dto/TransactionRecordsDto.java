package com.javaProjects.banking_app.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.javaProjects.banking_app.entities.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRecordsDto {
    private String transactionId = UUID.randomUUID().toString();
    private String transactionType;
    private String description;
    private LocalDate date;
    private Double amount;
    private Account account;
}
