package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.PersonClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalClientRepository extends CrudRepository<PersonClient, Long> {
    Optional<PersonClient> findById(Long id);

//    @Query(nativeQuery = true, value = "SELECT * FROM person_client;")
    List<PersonClient> findAll();
}
