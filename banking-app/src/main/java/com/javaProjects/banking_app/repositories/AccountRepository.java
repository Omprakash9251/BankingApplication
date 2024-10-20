package com.javaProjects.banking_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaProjects.banking_app.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
