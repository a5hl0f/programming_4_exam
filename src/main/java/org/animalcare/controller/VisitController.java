package org.animalcare.controller;

import org.animalcare.reposistory.VisitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/Visit")
@Controller
public class VisitController {
    private  final VisitRepository visitRepository;

    public VisitController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }
   @RequestMapping({"","/","/Visit","/Visit.html"})
    public String visitList(Model model){
        model.addAttribute("visits",visitRepository.findAll());
        return "VisitList";

    }
}
