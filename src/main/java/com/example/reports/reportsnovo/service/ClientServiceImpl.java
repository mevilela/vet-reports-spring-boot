package com.example.reports.reportsnovo.service;

import com.example.reports.reportsnovo.model.Animal;
import com.example.reports.reportsnovo.model.Client;
import com.example.reports.reportsnovo.model.Report;
import com.example.reports.reportsnovo.repository.AnimalRepository;
import com.example.reports.reportsnovo.repository.ReportRepository;
import org.springframework.stereotype.Service;
import com.example.reports.reportsnovo.repository.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) //abrir uma transação pois se houver um erro a transação faz rollback automaticamente (rollback "a anotação de rollback so se usa em testes")
public class ClientServiceImpl implements ClientService{

    private final AnimalRepository animalRepository;

    private final ClientRepository clientRepository;
    private final ReportRepository reportRepository;


    public ClientServiceImpl(AnimalRepository animalRepository, ClientRepository clientRepository, ReportRepository reportRepository) {
        this.animalRepository = animalRepository;
        this.clientRepository = clientRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Client> clientList() {

        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {

        Optional<Client> client = clientRepository.findClientById(id);
        if (client.isPresent()){
            return client.get();
        }
        throw new RuntimeException("client not found.");
     }

    @Override
    @Transactional
    public void deleteClientById(Integer id) {

        Client client = clientRepository.findClientById(id).orElseThrow();
        for (Animal animal : client.getAnimals()) {
            for (Report report : animal.getReports()) {
                reportRepository.delete(report);
                report = null;
            }
            animalRepository.delete(animal);
            animal = null;
        }

        client.setAnimals(new ArrayList<>());
        clientRepository.delete(client);



//        reportRepository.deleteById(id);
//        animalRepository.deleteById(id);
//        clientRepository.deleteById(id);

    }
}