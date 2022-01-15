package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.DebitAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DebitAccountRepository extends CrudRepository<DebitAccount, Long> {
    Optional<DebitAccount> findById(Long id);
    List<DebitAccount> findAll();
    List<DebitAccount> findAllById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM debit_account da WHERE da.ccid = :ccid")
    List<DebitAccount> findAllByccid(
            @Param("ccid") Long ccid
    );

    @Query(nativeQuery = true, value = "SELECT * FROM debit_account da WHERE da.pcid = :pcid")
    List<DebitAccount> findAllBypcid(
            @Param("pcid") Long pcid
    );
}
