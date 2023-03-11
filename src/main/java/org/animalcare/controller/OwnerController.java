package org.animalcare.controller;

import org.animalcare.service.OwnerService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @RequestMapping({"/","/Welcome","/Welcome.html"})
      public String Welcome(){
            return "Welcome";
      }

}
