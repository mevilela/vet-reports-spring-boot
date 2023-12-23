package com.example.reports.reportsnovo.service;

import com.example.reports.reportsnovo.model.Animal;
import com.example.reports.reportsnovo.repository.AnimalRepository;
import com.example.reports.reportsnovo.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;
    private ClientRepository clientRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository, ClientRepository clientRepository) {
        this.animalRepository = animalRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Animal> animalList() {

        return (List<Animal>) animalRepository.findAll();
    }

    @Override
    public List<Integer> findAnimalIdsByName(String name) {
        List<Animal> animals = animalRepository.findByName(name);

        List<Integer> animalIds = animals.stream().map(Animal::getId).collect(Collectors.toList());

        return animalIds;
    }

    @Override
    public Animal createNewAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal findById(Integer id) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()){
            return optionalAnimal.get();
        }
        throw new RuntimeException("animal not found.");
    }

    @Override
    public void updateAnimal(Animal animal) {

        animalRepository.save(animal);

    }

    @Override
    public void deleteAnimalById(Integer id) {
        animalRepository.deleteById(id);
    }


}