package com.example.reports.reportsnovo.repository;

import com.example.reports.reportsnovo.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

    List<Animal> findByName(String name);

    void deleteById(Integer Id);
}
