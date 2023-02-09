package com.learning.msaccount.dao.repository;

import com.learning.msaccount.dao.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> getAccountById(Long id);

}
