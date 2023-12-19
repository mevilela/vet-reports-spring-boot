package com.example.reports.reportsnovo.repository;

import com.example.reports.reportsnovo.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findClientById(Integer id);

}
