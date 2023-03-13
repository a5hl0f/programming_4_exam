package org.animalcare.service;
import org.animalcare.entity.AnimalType;
import org.animalcare.entity.Owner;
import org.animalcare.reposistory.AnimalTypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class AnimalTypeService {
    private final AnimalTypeRepository animalTypeRepository;

    public AnimalTypeService(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }
    public AnimalType findById(Long id){

        return animalTypeRepository.findById(id).orElse(null);

    }
    public void save(AnimalType animalType){
        animalTypeRepository.save(animalType);
    }
    public void deleteById(Long id){
        animalTypeRepository.deleteById(id);
    }
    public Set<AnimalType> findAll(){

        Set<AnimalType> animalTypes =new HashSet<>();
        animalTypeRepository.findAll().forEach(animalTypes::add);
        return animalTypes;
    }
    public void delete(AnimalType object){
        animalTypeRepository.delete(object);
    }
    public void deleteBYId(Long id){
        animalTypeRepository.deleteById(id);
    }
    public void Update(AnimalType object){
        animalTypeRepository.save(object);
    }
}
