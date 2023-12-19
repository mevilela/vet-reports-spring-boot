package com.example.reports.reportsnovo.service;

import com.example.reports.reportsnovo.model.Report;
import com.example.reports.reportsnovo.repository.ReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Report> reportList() {
        return (List<Report>) reportRepository.findAll();
    }

    @Override
    public Report createNewReport(Report report) {
        return reportRepository.save(report);
    }


    @Override
    public Report getReportById(Integer id) {

        Optional<Report> report = reportRepository.findById(id);
        if (report.isPresent()){
            return report.get();
        }
        throw new RuntimeException("report not found.");
    }

    @Override
    public void deleteReport(Report report) {
        reportRepository.delete(report);
    }

    @Override
    public List<Report> getReportByAnimalId(Integer id) {
        List<Report> reportByAnimal = reportRepository.findByAnimalId(id);

        if (reportByAnimal.isEmpty()) {
            throw new RuntimeException("no reports found.");
        }

        return reportByAnimal;
    }
}


