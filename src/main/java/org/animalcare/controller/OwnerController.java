package org.animalcare.controller;

import org.animalcare.service.OwnerService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("Owner")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @RequestMapping({"","/","/Owner","/Owner.html"})
      public String OwnerList(Model model){
        model.addAttribute("owners",ownerService.findAll());
            return "OwnerList";
      }

}
