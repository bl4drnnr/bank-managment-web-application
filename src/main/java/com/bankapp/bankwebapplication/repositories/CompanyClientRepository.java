package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.CompanyClient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyClientRepository extends CrudRepository<CompanyClient, Long> {
    Optional<CompanyClient> findById(Long id);

//    @Query(nativeQuery = true, value = "SELECT * FROM company_client;")
    List<CompanyClient> findAll();
}
