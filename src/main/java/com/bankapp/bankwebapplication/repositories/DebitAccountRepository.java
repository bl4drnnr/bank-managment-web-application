package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.DebitAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DebitAccountRepository extends CrudRepository<DebitAccount, Long> {
    Optional<DebitAccount> findById(Long id);
}
