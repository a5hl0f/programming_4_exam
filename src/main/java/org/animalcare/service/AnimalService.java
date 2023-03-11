package org.animalcare.service;

import org.animalcare.entity.Animal;
import org.animalcare.entity.Owner;
import org.animalcare.reposistory.AnimalRepository;
import org.animalcare.reposistory.AnimalTypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalTypeRepository animalTypeRepository;

    public AnimalService(AnimalRepository animalRepository, AnimalTypeRepository animalTypeRepository) {
        this.animalRepository = animalRepository;
        this.animalTypeRepository = animalTypeRepository;
    }
    public Animal findById(Long id){

        return animalRepository.findById(id).orElse(null);

    }
    public void save(Animal animal){
        animalRepository.save(animal);
    }
    public void deleteById(Long id){
        animalRepository.deleteById(id);
    }
    public Set<Animal> findAll(){

        Set<Animal> animals=new HashSet<>();
        animalRepository.findAll().forEach(animals::add);
        return animals;
    }
    public void delete(Animal object){
        animalRepository.delete(object);
    }
    public void deleteBYId(Long id){
        animalRepository.deleteById(id);
    }
}
