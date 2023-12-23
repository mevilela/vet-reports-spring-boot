package com.example.reports.reportsnovo.service;

import com.example.reports.reportsnovo.model.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> animalList();

    List<Integer> findAnimalIdsByName(String name);

    Animal createNewAnimal(Animal animal);

    Animal findById(Integer id);

    void updateAnimal(Animal animal);

    void deleteAnimalById(Integer id);

}
