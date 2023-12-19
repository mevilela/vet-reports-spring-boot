package com.example.reports.reportsnovo.repository;

import com.example.reports.reportsnovo.model.Animal;
import com.example.reports.reportsnovo.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository <Report, Integer> {

    List<Report> findByAnimalId(Integer id);
}
