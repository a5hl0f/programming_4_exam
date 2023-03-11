package org.animalcare.entity;

import jakarta.persistence.Entity;

@Entity
public class Doctor extends Person{
   private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
