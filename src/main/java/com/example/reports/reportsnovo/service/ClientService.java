package com.example.reports.reportsnovo.service;

import com.example.reports.reportsnovo.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> clientList();

    Client getClientById(Integer id);

    void deleteClientById(Integer id);

    Client createNewClient(Client client);
}
