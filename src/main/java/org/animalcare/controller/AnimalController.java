package org.animalcare.controller;

import org.animalcare.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("Animal")
@Controller
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping({"","/","/Animal","/Animal.html"})
    public String OwnerList(Model model){
        model.addAttribute("animals",animalService.findAll());
        return "AnimalList";
    }
}
