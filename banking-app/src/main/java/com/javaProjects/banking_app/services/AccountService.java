package com.javaProjects.banking_app.services;

import java.util.List;

import com.javaProjects.banking_app.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto depositAmount(Long id, Double amount);

    AccountDto updateName(Long id, String updateAccountHolderName);

    AccountDto withDrawAmount(Long id, Double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
