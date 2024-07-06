package com.example.reports.reportsnovo.controller;


import com.example.reports.reportsnovo.model.Vet;
import com.example.reports.reportsnovo.service.AnimalService;
import com.example.reports.reportsnovo.service.ClientService;
import com.example.reports.reportsnovo.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vets")
public class VetController {
   private final VetService vetService;
   private final ClientService clientService;
   private final AnimalService animalService;

    public VetController(VetService vetService, ClientService clientService, AnimalService animalService) {
        this.vetService = vetService;
        this.clientService = clientService;
        this.animalService = animalService;
    }

    @GetMapping("/list")
    public String vetList(Model model){

        List<Vet> vets = vetService.vetList();

        model.addAttribute("vets", vets);

        return "vets/list";
    }

    @GetMapping("/create")
    public String createNewVet(Model model){

        model.addAttribute("vet", new Vet());
        model.addAttribute("client", clientService.clientList());
        model.addAttribute("animal", animalService.animalList());


        return "vets/create";
    }

    @PostMapping("/create")
    public String createNewVet(@ModelAttribute Vet vet){

        vetService.createNewVet(vet);

        return "redirect:/vets/list";
    }

    @DeleteMapping("/{id}")
    public String deleteVet(@PathVariable Integer id){

        vetService.deleteVet(id);

        return "redirect:/vets/list";

    }

}
