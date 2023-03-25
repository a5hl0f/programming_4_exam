package org.animalcare.service;

import org.animalcare.entity.Doctor;
import org.animalcare.reposistory.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public Doctor findById(Long id){

        return doctorRepository.findById(id).orElse(null);

    }

    public void save(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public void deleteById(Long id){
        doctorRepository.deleteById(id);
    }
    public Set<Doctor> findAll(){

        Set<Doctor> doctors=new HashSet<>();
        doctorRepository.findAll().forEach(doctors::add);
        return doctors;
    }
    public void delete(Doctor object){
        doctorRepository.delete(object);
    }
    public void deleteBYId(Long id){
        doctorRepository.deleteById(id);
    }

}
