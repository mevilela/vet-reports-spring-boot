package com.example.reports.reportsnovo.controller;

import com.example.reports.reportsnovo.model.Animal;
import com.example.reports.reportsnovo.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.reports.reportsnovo.service.ClientService;

import java.util.List;
//Controller, Service, Model, Repository

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public String clientList(Model model) {
        List<Client> clients = clientService.clientList();
        model.addAttribute("clients", clients);
        return "clients/list";
    }

    @GetMapping("/details/{id}")
    public String getClientDetails(Model model, @PathVariable Integer id) {

        Client clientDetails = clientService.getClientById(id);

        model.addAttribute("clientDetails", clientDetails);

        return "clients/details";
    }

    @GetMapping("/create")
    public String createNewClient(Model model){

        model.addAttribute("client", new Client()); //

        return "clients/create";
    }

    @PostMapping("/create")
    public String createNewClient(@ModelAttribute Client client){

        clientService.createNewClient(client);

        return "redirect:/clients/list";
    }


    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Integer id) {

        clientService.deleteClientById(id);

        return "redirect:/clients/list";
    }
}
