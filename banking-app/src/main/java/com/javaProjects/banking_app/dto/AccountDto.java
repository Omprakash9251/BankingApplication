package com.javaProjects.banking_app.dto;

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
}
