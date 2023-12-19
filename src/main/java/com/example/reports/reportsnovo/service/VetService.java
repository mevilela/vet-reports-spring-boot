package com.example.reports.reportsnovo.service;

import com.example.reports.reportsnovo.model.Vet;

import java.util.List;

public interface VetService {

    List<Vet> vetList();

    Vet createNewVet(Vet vet);

    void deleteVet(Integer id);
}
