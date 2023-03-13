package org.animalcare.service;

import org.animalcare.entity.Owner;
import org.animalcare.entity.Visit;
import org.animalcare.reposistory.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }
    public Visit findById(Long id){

        return visitRepository.findById(id).orElse(null);

    }
    public void save(Visit visit){
        visitRepository.save(visit);
    }
    public void deleteById(Long id){
        visitRepository.deleteById(id);
    }
    public Set<Visit> findAll(){

        Set<Visit> visits=new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }
    public void delete(Visit object){
        visitRepository.delete(object);
    }
    public void deleteBYId(Long id){
        visitRepository.deleteById(id);
    }
    public void Update(Visit object){
        visitRepository.save(object);
    }
}
