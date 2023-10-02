package org.animalcare.dataLoader;

import org.animalcare.entity.*;
import org.animalcare.reposistory.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class Data implements CommandLineRunner {

    private final OwnerRepository ownerRepository;
    private final AnimalTypeRepository animalTypeRepository;
    private final AnimalRepository animalRepository;
    private final VisitRepository visitRepository;
    private  final DoctorRepository doctorRepository;

    public Data(OwnerRepository ownerRepository, AnimalTypeRepository animalTypeRepository, AnimalRepository animalRepository, VisitRepository visitRepository, DoctorRepository doctorRepository) {
        this.ownerRepository = ownerRepository;
        this.animalTypeRepository = animalTypeRepository;
        this.animalRepository = animalRepository;
        this.visitRepository = visitRepository;

        this.doctorRepository = doctorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //animal type
        AnimalType dog=new AnimalType();
        dog.setName("Dog");
        AnimalType dogType=animalTypeRepository.save(dog);

        AnimalType cat=new AnimalType();
        cat.setName("Cat");
        AnimalType catType=animalTypeRepository.save(cat);

       //owner data
        Owner owner1=new Owner();
        owner1.setFirstName("mohammad");
        owner1.setLastName("aquib");
        owner1.setAddress("Hungary");
        owner1.setCity("Budapest");
        owner1.setTelephone("+308776886");

        Owner savedOwner=ownerRepository.save(owner1);

        ///animal data
        Animal an=new Animal();
        an.setAnimalType(catType);
        an.setOwner(savedOwner);
        an.setBirthDate(1998L);
        an.setName("cherry");
        owner1.getAnimals().add(an);

        animalRepository.save(an);



        // visit data
        Visit vis=new Visit();
        vis.setAnimal(an);
        vis.setDate(LocalDate.now());
        vis.setDescription("Dog has fever ");

        visitRepository.save(vis);


        //animal type
        AnimalType dog1=new AnimalType();
        dog1.setName("Cat");
        AnimalType dogType1=animalTypeRepository.save(dog1);

        AnimalType cat1=new AnimalType();
        cat1.setName("Cat");
        AnimalType catType1=animalTypeRepository.save(cat1);

        //owner data
        Owner owner2=new Owner();
        owner2.setFirstName("Anant");
        owner2.setLastName("Kumar");
        owner2.setAddress("Hungary");
        owner2.setCity("Pecs");
        owner2.setTelephone("+30877635");

        Owner savedOwner2= ownerRepository.save(owner2);

        ///animal data
        Animal an1=new Animal();
        an1.setAnimalType(dogType1);
        an1.setOwner(savedOwner2);
        an1.setBirthDate(2000L);
        an1.setName("Meow");
       owner2.getAnimals().add(an1);
        animalRepository.save(an1);
        // Visit
        Visit vis1=new Visit();
        vis1.setAnimal(an1);
        vis1.setDate(LocalDate.now());
        vis1.setDescription("COUGH PROBLEM ");

        visitRepository.save(vis1);

        //Doctor
        Doctor doc=new Doctor();
        doc.setFirstName(" Tyege");
        doc.setLastName("kumar");
        doc.setSpeciality("general physican");

        doctorRepository.save(doc);



    }
}
