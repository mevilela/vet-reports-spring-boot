package com.example.reports.reportsnovo.service;

import com.example.reports.reportsnovo.model.Report;

import java.util.List;

public interface ReportService {

    List<Report> reportList();

    Report createNewReport(Report report);

    Report getReportById(Integer id);

    void deleteReport(Report report);

    List<Report> getReportByAnimalId(Integer id);

}
