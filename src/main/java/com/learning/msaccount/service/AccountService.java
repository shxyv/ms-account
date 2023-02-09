package com.learning.msaccount.service;

import com.learning.msaccount.dao.entity.Account;
import com.learning.msaccount.dao.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccountById(Long id) {
        return accountRepository.getAccountById(id)
                .orElseThrow();
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}
