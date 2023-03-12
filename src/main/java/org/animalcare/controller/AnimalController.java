package org.animalcare.controller;

import org.animalcare.entity.Animal;
import org.animalcare.entity.AnimalType;
import org.animalcare.entity.Owner;
import org.animalcare.service.AnimalService;
import org.animalcare.service.AnimalTypeService;
import org.animalcare.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
        return "AnimalList";
    }
    @GetMapping("/register")
    public String createAnimal(Model model){
        Animal an=new Animal();
        model.addAttribute("animals",an);
        ArrayList<AnimalType> anitype= (ArrayList<AnimalType>) animalTypeService.findAll();
        model.addAttribute("anitype",anitype);
        ArrayList<Owner> ow= (ArrayList<Owner>) ownerService.findAll();
        model.addAttribute("own",ow);
        return "animals/CreateAnimal";

    }
    @PostMapping("/register")
    public String saveAnimal(@ModelAttribute("animals") Animal animal){
        animalService.save(animal);
        return "redirect : AnimalList";
    }
}
