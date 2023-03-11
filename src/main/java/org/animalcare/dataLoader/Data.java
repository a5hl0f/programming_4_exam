package org.animalcare.dataLoader;

import org.animalcare.entity.Owner;
import org.animalcare.reposistory.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Data implements CommandLineRunner {

    private final OwnerRepository ownerRepository;

    public Data(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner=new Owner();
        owner.setFirstName("mohammad");
        owner.setLastName("aquib");
        owner.setAddress("Hungary");
        owner.setCity("Budapest");
        owner.setTelephone("+308776886");

        ownerRepository.save(owner);

    }
}
