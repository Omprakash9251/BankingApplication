package com.javaProjects.banking_app.dto;

import java.util.List;
import com.javaProjects.banking_app.entities.TransactionRecords;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long Id;
    private String accountHolderName;
    private Double balance = 0.0;
    private List<TransactionRecords> transactionRecords;
}
