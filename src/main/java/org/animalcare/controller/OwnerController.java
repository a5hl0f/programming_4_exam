package org.animalcare.controller;

import org.animalcare.entity.Owner;
import org.animalcare.service.OwnerService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            return "owners/OwnerList";
      }
      @GetMapping("/register")
      public String registerOwner(Model model){
          Owner owner=new Owner();
          model.addAttribute("owner",owner);
          return "owners/CreateOwner";
      }
      @PostMapping("/register")
    public String submitOwner(@ModelAttribute("owner") Owner owner){
        ownerService.save(owner);

        return "redirect:/Owner/Owner";
      }
      @GetMapping("/edit/{OwnerId}")
      public String EditOwner(@PathVariable("OwnerId") Long ownerId,Model model){
        Owner own=ownerService.findById(ownerId);
        model.addAttribute("owner",own);
        return "owners/UpdateOwner";

      }
      @PostMapping("/edit")
      public String updateOwner(@ModelAttribute("owner") Owner owner){
        ownerService.save(owner);
        return "redirect:/Owner/Owner";
      }
      @RequestMapping("/delete/{OwnerId}")
      public String delete(@PathVariable("OwnerId") Long ownerId){

        ownerService.deleteById(ownerId);
        return "redirect:/Owner/Owner";

      }

}
