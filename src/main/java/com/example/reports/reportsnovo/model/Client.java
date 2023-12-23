package com.example.reports.reportsnovo.model;
//também chamado de entities

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

    //identificar como PK e gerar numeros automaticamente
    @Id
    @GeneratedValue
    private Integer id;
    private String fullName;
    private Integer vatNumber;

    /*
    **Uso da anotação fetch = FetchType.EAGER: Define que, ao carregar a entidade "Animal",
    os dados relacionados à entidade associada (Client) devem ser carregados imediatamente.
    Ou seja, quando você carregar um Animal, o correspondente "Client" também será carregado automaticamente.

    **cascade = CascadeType.ALL: Essa configuração indica que as operações de persistência
    (como salvar, atualizar e excluir) realizadas na entidade proprietária (Animal) devem ser propagadas
    automaticamente para a entidade associada (Client). O CascadeType.ALL inclui todas as operações possíveis:
    persistência, remoção, atualização, etc.

    **orphanRemoval = true: Isso está relacionado à remoção de entidades "órfãs". Quando uma entidade Animal é removida e não está associada a nenhum Client, a configuração orphanRemoval = true instrui o provedor JPA a remover automaticamente a entidade Animal do banco de dados, pois não tem mais uma entidade associada. Isso é útil quando o relacionamento entre Animal e Client é forte e você deseja manter o banco de dados consistente com o modelo de objeto.

    */
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Animal> animals;

    public Client() {

    }
    public Client(String fullName, Integer vatNumber){
        this.fullName=fullName;
        this.vatNumber=vatNumber;
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

    public Integer getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(Integer vatNumber) {
        this.vatNumber = vatNumber;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", vatNumber=" + vatNumber +
                '}';
    }
}
