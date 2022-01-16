package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.PersonClient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PersonalClientRepository extends CrudRepository<PersonClient, Long> {
    Optional<PersonClient> findById(Long id);
    List<PersonClient> findAll();
    List<PersonClient> findAllById(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE person_client" +
            " SET first_name = :firstName, last_name = :lastName, pesel = :pesel, address = :address, work_phone = :workPhone, home_phone = :homePhone " +
            " WHERE id = :id")
    void updateClientData(
            @Param("id") Long id,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("pesel") String pesel,
            @Param("address") String address,
            @Param("workPhone") String workPhone,
            @Param("homePhone") String homePhone
    );
}
