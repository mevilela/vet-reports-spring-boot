package com.example.reports.reportsnovo.service;

import com.example.reports.reportsnovo.model.Vet;
import com.example.reports.reportsnovo.repository.VetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VetServiceImpl implements VetService {

    VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }
    @Override
    public List<Vet> vetList() {
        return (List<Vet>) vetRepository.findAll();
    }

    @Override
    public Vet createNewVet(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void deleteVet(Integer id) {

        vetRepository.deleteAll();
    }
}
