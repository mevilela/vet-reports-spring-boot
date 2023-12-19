package com.example.reports.reportsnovo.repository;

import com.example.reports.reportsnovo.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Integer>{
}
