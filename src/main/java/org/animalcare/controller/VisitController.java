package org.animalcare.controller;

import org.animalcare.service.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/Visit")
@Controller
public class VisitController {
    private  final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }


    @RequestMapping({"","/","/Visit","/Visit.html"})
    public String visitList(Model model){
        model.addAttribute("visits",visitService.findAll());
        return "VisitList";

    }
    @RequestMapping("/delete/{visitId}")
    public String delete(@PathVariable("visitId") Long visitId){
        visitService.deleteById(visitId  );
        return "redirect:/Visit/Visit";
    }
}
