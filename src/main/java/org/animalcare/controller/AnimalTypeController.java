package org.animalcare.controller;

import org.animalcare.entity.AnimalType;
import org.animalcare.service.AnimalTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("AnimalType")
@Controller
public class AnimalTypeController {
    private final AnimalTypeService animalTypeService;

    public AnimalTypeController(AnimalTypeService animalTypeService) {
        this.animalTypeService = animalTypeService;
    }
    @RequestMapping({"","/","/AniType"})
    public String listAniType(Model model){
        model.addAttribute("anitype",animalTypeService.findAll());
        return "anitype/AniTypeList";

    }
    @RequestMapping("delete/{anitypeId}")
    public String delete(@PathVariable("anitypeId") Long anitypeId){
        animalTypeService.deleteById(anitypeId);
        return "redirect:/AnimalType/AniType";
    }
    @GetMapping("/register")
    public String registerAniType(Model model){
        AnimalType ani=new AnimalType();
        model.addAttribute("ani",ani);
        return "anitype/CreateAniType";
    }
    @PostMapping("/register")
    public String submitDoc(@ModelAttribute("ani") AnimalType animalType){
        animalTypeService.save(animalType);

        return "redirect:/AnimalType/AniType";
    }

    @GetMapping("/edit/{anitypeId}")
    public String EditAni(@PathVariable("anitypeId") Long anitypeId,Model model){
        AnimalType doc=animalTypeService.findById(anitypeId);
        model.addAttribute("anitype",doc);
        return "anitype/Editanitype";

    }
    @PostMapping("/edit")
    public String updateAni(@ModelAttribute("anitype") AnimalType animalType){
        animalTypeService.save(animalType);
        return "redirect:/AnimalType/AniType";
    }
}
