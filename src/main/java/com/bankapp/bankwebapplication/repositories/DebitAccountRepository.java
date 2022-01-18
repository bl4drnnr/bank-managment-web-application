package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.DebitAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface DebitAccountRepository extends CrudRepository<DebitAccount, Long> {
    Optional<DebitAccount> findById(Long id);
    List<DebitAccount> findAll();
    List<DebitAccount> findAllById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM debit_account WHERE ccid = :ccid")
    List<DebitAccount> findAllByccid(
            @Param("ccid") Long ccid
    );

    @Query(nativeQuery = true, value = "SELECT * FROM debit_account WHERE pcid = :pcid")
    List<DebitAccount> findAllBypcid(
            @Param("pcid") Long pcid
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM debit_account WHERE ccid = :ccid")
    void deleteAllByccid(
            @Param("ccid") Long ccid
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM debit_account WHERE pcid = :pcid")
    void deleteAllBypcid(
            @Param("pcid") Long pcid
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE debit_account" +
            " SET amount_of_money = :amountOfMoney, pcid = :pcid, ccid = :ccid" +
            " WHERE id = :id")
    void updateDebitAccount(
            @Param("id") Long id,
            @Param("pcid") Long pcid,
            @Param("ccid") Long ccid,
            @Param("amountOfMoney") Long amountOfMoney
    );

    @Query(nativeQuery = true, value = "SELECT * FROM debit_account WHERE" +
            " amount_of_money = (SELECT max(amount_of_money) FROM debit_account WHERE" +
            " pcid is not null)")
    List<DebitAccount> findDebitPersonWithMaxAmounts();

    @Query(nativeQuery = true, value = "SELECT * FROM debit_account WHERE" +
            " amount_of_money = (SELECT max(amount_of_money) FROM debit_account WHERE" +
            " ccid is not null)")
    List<DebitAccount> findDebitCompanyWithMaxAmounts();
}
