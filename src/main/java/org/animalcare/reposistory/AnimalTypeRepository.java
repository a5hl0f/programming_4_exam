package org.animalcare.reposistory;

import org.animalcare.entity.AnimalType;
import org.springframework.data.repository.CrudRepository;

public interface AnimalTypeRepository extends CrudRepository<AnimalType,Long> {
}
