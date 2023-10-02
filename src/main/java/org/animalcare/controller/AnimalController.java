package org.animalcare.controller;

import org.animalcare.entity.Animal;
import org.animalcare.entity.AnimalType;
import org.animalcare.entity.Doctor;
import org.animalcare.entity.Owner;
import org.animalcare.service.AnimalService;
import org.animalcare.service.AnimalTypeService;
import org.animalcare.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RequestMapping("Animal")
@Controller
public class AnimalController {
    private final AnimalService animalService;
    private final AnimalTypeService animalTypeService;
    private final OwnerService ownerService;

    public AnimalController(AnimalService animalService, AnimalTypeService animalTypeService, OwnerService ownerService) {
        this.animalService = animalService;
        this.animalTypeService = animalTypeService;
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/Animal","/Animal.html"})
    public String OwnerList(Model model){
        model.addAttribute("animals",animalService.findAll());
        return "animals/AnimalList";
    }
    @GetMapping("/register")
    public String createAnimal(Model model){
        Animal an=new Animal();
        model.addAttribute("animals",an);
        Set<AnimalType> anitype= (Set<AnimalType>) animalTypeService.findAll();
        model.addAttribute("anitype",anitype);
        Set<Owner> ow = (Set<Owner>) ownerService.findAll();
        model.addAttribute("owns",ow);
        return "animals/CreateAnimal";

    }
    @PostMapping("/register")
    public String saveAnimal(@ModelAttribute("animals") Animal animal){
        if(animal==null){
            return "redirect:/Animal/Animal";
        }else {
            animalService.save(animal);
            return "redirect:/Animal/Animal";
        }
    }
    @RequestMapping("/delete/{animalId}")
    public String delete(@PathVariable("animalId") Long animalId){

        animalService.deleteById(animalId);
        return "redirect:/Animal/Animal";

    }
    @GetMapping("/edit/{animalId}")
    public String EditDoc(@PathVariable("animalId") Long animalId,Model model){
        Animal doc=animalService.findById(animalId);
        model.addAttribute("animal",doc);

        Set<AnimalType> anitype= (Set<AnimalType>) animalTypeService.findAll();
        model.addAttribute("anitype",anitype);
        Set<Owner> ow = (Set<Owner>) ownerService.findAll();
       
        model.addAttribute("owns",ow);
        return "animals/EditAnimal";

    }
    @PostMapping("/edit")
    public String updateDoc(@ModelAttribute("animal") Animal animal){
        animalService.save(animal);
        return "redirect:/Animal/Animal";
    }
}
