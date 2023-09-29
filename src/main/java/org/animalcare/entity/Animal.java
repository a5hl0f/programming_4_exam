//package org.animalcare.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Animal extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "type_id")
    private AnimalType animalType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private Long birthDate;
    private String Name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "animal")
    private Set<Visit> visits;

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalType=" + animalType +
                ", owner=" + owner +
                ", birthDate=" + birthDate +
                ", Name='" + Name + '\'' +
                ", visits=" + visits +
                '}';
    }
}
