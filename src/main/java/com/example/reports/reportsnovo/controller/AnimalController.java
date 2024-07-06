package com.example.reports.reportsnovo.controller;

import com.example.reports.reportsnovo.model.Animal;
import com.example.reports.reportsnovo.service.AnimalService;
import com.example.reports.reportsnovo.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;
    private final ClientService clientService;

    public AnimalController(AnimalService animalService, ClientService clientService) {
        this.animalService = animalService;
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public String animalList(Model model){

        List<Animal> animals = animalService.animalList();

        model.addAttribute("animals", animals);

        return "animals/list";
    }

    @GetMapping("/create")
    public String createNewAnimal(Model model){

        model.addAttribute("animal", new Animal()); // Corrected attribute name to "animal"
        model.addAttribute("clients", clientService.clientList());

        return "animals/create";
    }

    @PostMapping("/create")
    public String createNewAnimal(@ModelAttribute Animal animal){

        animalService.createNewAnimal(animal);

        return "redirect:/animals/list";
    }

    @GetMapping("/edit/{id}")
    public String editAnimalForm(@PathVariable Integer id, Model model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        model.addAttribute("clients", clientService.clientList());
        return "animals/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAnimal(@PathVariable Integer id, @ModelAttribute Animal updatedAnimal) {
        Animal animal = animalService.findById(id);

        // Atualizar os atributos do animal com base nos dados do formulário
        animal.setName(updatedAnimal.getName());
        animal.setType(updatedAnimal.getType());
        animal.setMicrochip(updatedAnimal.getMicrochip());
        animal.setClient(updatedAnimal.getClient());

        animalService.updateAnimal(animal);

        return "redirect:/animals/list";
    }
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Integer id){

        animalService.deleteAnimalById(id);

        return "redirect:/animals/list";
    }

}
