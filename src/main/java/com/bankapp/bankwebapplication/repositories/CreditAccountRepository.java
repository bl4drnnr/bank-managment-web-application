package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.CreditAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CreditAccountRepository extends CrudRepository<CreditAccount, Long> {
    Optional<CreditAccount> findById(Long id);
    List<CreditAccount> findAll();
    List<CreditAccount> findAllById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM credit_account cred WHERE cred.ccid = :ccid")
    List<CreditAccount> findAllByccid(
            @Param("ccid") Long ccid
    );

    @Query(nativeQuery = true, value = "SELECT * FROM credit_account cred WHERE cred.pcid = :pcid")
    List<CreditAccount> findAllBypcid(
            @Param("pcid") Long pcid
    );
}
