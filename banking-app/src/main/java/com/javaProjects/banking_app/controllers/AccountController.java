package com.javaProjects.banking_app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaProjects.banking_app.dto.AccountDto;
import com.javaProjects.banking_app.services.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@Validated @RequestBody AccountDto accountDto) {
        if (accountDto.getBalance() == null) {
            accountDto.setBalance(0.0);
        }
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        if (accountDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<?> depositAmount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");

        if (amount == null || amount <= 0.0) {
            return ResponseEntity
                    .badRequest()
                    .body("Amount should be greater than 0");
        }

        AccountDto accountDto = accountService.depositAmount(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/updateName")
    public ResponseEntity<AccountDto> updateAccountHolderName(@PathVariable Long id,
            @RequestBody Map<String, String> request) {
        String updateAccountHolderName = request.get("updateAccountHolderName");
        AccountDto updatedAccount = accountService.updateName(id, updateAccountHolderName);
        return ResponseEntity.ok(updatedAccount);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<?> withDrawAmount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");

        if (amount == null || amount <= 0.0) {
            return ResponseEntity
                    .badRequest()
                    .body("Amount should be greater than 0");
        }

        AccountDto accountDto = accountService.withDrawAmount(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted successfully");
    }

}
