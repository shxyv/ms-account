package com.learning.msaccount;

import com.learning.msaccount.dao.entity.Account;
import com.learning.msaccount.dao.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MsAccountApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsAccountApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Account account = Account.builder()
                .accountNumber("12345678")
                .accountType("SPECIAL")
                .branchAddress("address")
                .build();

        Account account2 = Account.builder()
                .accountNumber("87654321")
                .accountType("ORDINARY")
                .branchAddress("address2")
                .build();

        Account account3 = Account.builder()
                .accountNumber("12348765")
                .accountType("VIP")
                .branchAddress("address3")
                .build();

        accountRepository.saveAll(List.of(account, account2, account3));
    }
}
