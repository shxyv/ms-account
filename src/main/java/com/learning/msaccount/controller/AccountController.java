package com.learning.msaccount.controller;

import com.learning.msaccount.client.model.Card;
import com.learning.msaccount.dao.entity.Account;
import com.learning.msaccount.service.AccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    @Retry(name = "getAccountByIdRetry")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping
    @CircuitBreaker(name = "getAllAccountsBreaker")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/card/{id}")
    @RateLimiter(name = "getCardByIdLimiter")
    public Card getCardById(@PathVariable Long id) {
        return accountService.getCardById(id);
    }


}
