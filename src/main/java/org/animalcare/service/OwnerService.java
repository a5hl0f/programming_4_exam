package org.animalcare.service;

import org.animalcare.entity.Owner;
import org.animalcare.reposistory.AnimalRepository;
import org.animalcare.reposistory.AnimalTypeRepository;
import org.animalcare.reposistory.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final AnimalTypeRepository animalTypeRepository;
   private final AnimalRepository animalRepository;

    public OwnerService(OwnerRepository ownerRepository, AnimalTypeRepository animalTypeRepository, AnimalRepository animalRepository) {
        this.ownerRepository = ownerRepository;
        this.animalTypeRepository = animalTypeRepository;
        this.animalRepository = animalRepository;
    }


    public Owner findById(Long id){

    return ownerRepository.findById(id).orElse(null);

    }
    public void save(Owner owner){
        ownerRepository.save(owner);
    }
    public void deleteById(Long id){
        ownerRepository.deleteById(id);
    }
    public Set<Owner> findAll(){

      Set<Owner> owners=new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }
    public void delete(Owner object){
        ownerRepository.delete(object);
    }
    public void Update(Owner object){
        ownerRepository.save(object);
    }
}
