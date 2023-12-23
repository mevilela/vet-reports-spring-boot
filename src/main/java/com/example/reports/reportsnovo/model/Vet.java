package com.example.reports.reportsnovo.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Vet {
    @Id
    @GeneratedValue
    private Integer id;

    private String fullName;

    private Integer crmv;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Report> reports;

    public Vet(){

    }
    public Vet(String fullName, Integer crmv) {
        this.fullName = fullName;
        this.crmv = crmv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getCrmv() {
        return crmv;
    }

    public void setCrmv(Integer crmv) {
        this.crmv = crmv;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }


    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", crmv=" + crmv +
                '}';
    }
}
