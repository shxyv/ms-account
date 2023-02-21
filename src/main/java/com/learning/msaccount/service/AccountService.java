package com.learning.msaccount.service;

import com.learning.msaccount.client.CardClient;
import com.learning.msaccount.client.model.Card;
import com.learning.msaccount.dao.entity.Account;
import com.learning.msaccount.dao.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CardClient cardClient;

    public Account getAccountById(Long id) {
        return accountRepository.getAccountById(id)
                .orElseThrow();
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardClient.getCardById(id);
    }

}
