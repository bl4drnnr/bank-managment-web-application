package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.CreditAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CreditAccountRepository extends CrudRepository<CreditAccount, Long> {
    Optional<CreditAccount> findById(Long id);
    List<CreditAccount> findAll();
    List<CreditAccount> findAllById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM credit_account WHERE ccid = :ccid")
    List<CreditAccount> findAllByccid(
            @Param("ccid") Long ccid
    );

    @Query(nativeQuery = true, value = "SELECT * FROM credit_account WHERE pcid = :pcid")
    List<CreditAccount> findAllBypcid(
            @Param("pcid") Long pcid
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM credit_account WHERE ccid = :ccid")
    void deleteAllByccid(
            @Param("ccid") Long ccid
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM credit_account WHERE pcid = :pcid")
    void deleteAllBypcid(
            @Param("pcid") Long pcid
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE credit_account" +
            " SET amount_of_money = :amountOfMoney, expired_at = :expiredAt, pcid = :pcid, ccid = :ccid" +
            " WHERE id = :id")
    void updateCreditAccount(
            @Param("id") Long id,
            @Param("pcid") Long pcid,
            @Param("ccid") Long ccid,
            @Param("amountOfMoney") Long amountOfMoney,
            @Param("expiredAt") LocalDate expiredAt
    );

    @Query(nativeQuery = true, value = "SELECT * FROM credit_account WHERE" +
            " amount_of_money = (SELECT max(amount_of_money) FROM credit_account WHERE" +
            " pcid is not null)")
    List<CreditAccount> findCreditPersonWithMaxAmounts();

    @Query(nativeQuery = true, value = "SELECT * FROM credit_account WHERE" +
            " amount_of_money = (SELECT max(amount_of_money) FROM credit_account WHERE" +
            " ccid is not null)")
    List<CreditAccount> findCreditCompanyWithMaxAmounts();
}
