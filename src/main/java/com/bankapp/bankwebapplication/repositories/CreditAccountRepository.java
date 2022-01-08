package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.CreditAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CreditAccountRepository extends CrudRepository<CreditAccount, Long> {
    Optional<CreditAccount> findById(Long id);
}
