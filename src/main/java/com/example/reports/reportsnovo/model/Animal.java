package com.example.reports.reportsnovo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    private String type;

    private Integer microchip;

    //correlacionar com o cliente
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Report> reports;

    public Animal(){

    }

    public Animal(String name, String type, Integer microchip) {
        this.name = name;
        this.type = type;
        this.microchip = microchip;
    }


    public Animal(String name, String type, Integer microchip, Client client) {
        this.name = name;
        this.type = type;
        this.microchip = microchip;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMicrochip() {
        return microchip;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public void setMicrochip(Integer microchip) {
        this.microchip = microchip;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", microchip=" + microchip +
                ", client=" + client +
                '}';
    }
}
