package com.example.reports.reportsnovo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Report {

    @Id
    @GeneratedValue
    private Integer id;

    private String type;

    private String description;

    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @ManyToOne
    @JoinColumn(name = "animal_id")  // Nome da coluna que armazena a chave estrangeira em Report
    private Animal animal;

    public Report(){

    }

    public Report(String type, String description, LocalDateTime localDateTime) {
        this.type = type;
        this.description = description;
        this.localDateTime = localDateTime;
    }

    public Report(String type, String description, LocalDateTime localDateTime, Vet vet, Animal animal, Client client) {
        this.type = type;
        this.description = description;
        this.localDateTime = localDateTime;
        this.vet = vet;
        this.animal = animal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", localDateTime=" + localDateTime +
                ", vet=" + vet +
                '}';
    }
}

