package com.javaProjects.banking_app.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaProjects.banking_app.dto.AccountDto;
import com.javaProjects.banking_app.entities.Account;
import com.javaProjects.banking_app.mapper.AccountMapper;
import com.javaProjects.banking_app.repositories.AccountRepository;
import com.javaProjects.banking_app.services.AccountService;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Not exists"));
        return AccountMapper.maptoAccountDto(account);
    }

    @Override
    public AccountDto depositAmount(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Not exists"));
        Double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto updateName(Long id, String updateAccountHolderName) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Not exists"));
        account.setAccountHolderName(updateAccountHolderName);
        accountRepository.save(account);
        return AccountMapper.maptoAccountDto(account);
    }

    @Override
    public AccountDto withDrawAmount(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Not exists"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        Double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.maptoAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Not exists"));
        accountRepository.deleteById(id);
    }

}
