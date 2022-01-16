package com.bankapp.bankwebapplication.repositories;

import com.bankapp.bankwebapplication.models.CompanyClient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CompanyClientRepository extends CrudRepository<CompanyClient, Long> {
    Optional<CompanyClient> findById(Long id);
    List<CompanyClient> findAll();
    List<CompanyClient> findAllById(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE company_client" +
            " SET nip = :nip, company_name = :companyName, company_phone = :companyPhone, company_address = :companyAddress " +
            " WHERE id = :id")
    void updateCompanyData(
            @Param("id") Long id,
            @Param("nip") String nip,
            @Param("companyName") String companyName,
            @Param("companyAddress") String companyAddress,
            @Param("companyPhone") String companyPhone
    );
}
