package com.example.reports.reportsnovo.controller;

import com.example.reports.reportsnovo.model.Animal;
import com.example.reports.reportsnovo.model.Client;
import com.example.reports.reportsnovo.model.Report;
import com.example.reports.reportsnovo.service.AnimalService;
import com.example.reports.reportsnovo.service.ClientService;
import com.example.reports.reportsnovo.service.ReportService;
import com.example.reports.reportsnovo.service.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final Logger logger = LoggerFactory.getLogger(ReportController.class);

    private final ReportService reportService;

    private final ClientService clientService;
    private final AnimalService animalService;
    private final VetService vetService;

    public ReportController(ReportService reportService, ClientService clientService, AnimalService animalService, VetService vetService) {
        this.reportService = reportService;
        this.clientService = clientService;
        this.animalService = animalService;
        this.vetService = vetService;
    }

    @GetMapping("/list")
    public String reportList(Model model){

        List<Report> reports = reportService.reportList();

        model.addAttribute("reports", reports);

        return "reports/list";
    }

    @GetMapping("/create")
    public String getReportCreateForm(Model model){


            model.addAttribute("clients", clientService.clientList());
            model.addAttribute("animals", animalService.animalList());
            model.addAttribute("vets", vetService.vetList());
            model.addAttribute("report", new Report());

            return "reports/create";
    }


    @PostMapping("/create")
    public String submitNewReport(@ModelAttribute Report report) {


        reportService.createNewReport(report);

        return "redirect:/reports/list";

    }


    @GetMapping("/details/{id}")
    public String getReportDetails (Model model, @PathVariable Integer id) {

        Report reportDetails = reportService.getReportById(id);

        model.addAttribute("reportDetails", reportDetails);

        return "reports/details";
    }

    @GetMapping("/list/{id}")
    public String reportsByAnimalId(@PathVariable Integer id, Model model) {

        List<Report> reportsByAnimal = reportService.getReportByAnimalId(id);

        model.addAttribute("reports", reportsByAnimal);

        return "reports/list";
    }

    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Integer id) {
        logger.info("Iniciando deleteReport. ID: {}", id);

        Report report = reportService.getReportById(id);
        reportService.deleteReport(report);

        logger.info("deleteReport concluído com sucesso.");

        return "redirect:/reports/list";

    }
}

