package org.animalcare.controller;

import org.animalcare.entity.Owner;
import org.animalcare.service.OwnerService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
      @GetMapping("/register")
      public String registerOwner(Model model){
          Owner owner=new Owner();
          model.addAttribute("owner",owner);
          return "CreateOwner";
      }
      @PostMapping("/register")
    public String submitonwer(@ModelAttribute("owner") Owner owner){
        ownerService.save(owner);

        return "redirect : OwnerList";
      }
      @GetMapping("/{OwnerId}/edit")
      public String EditOwner(@PathVariable("OwnerId") Long ownerId,Model model){
        Owner own=ownerService.findById(ownerId);
        model.addAttribute("owner",own);
        return "UpdateOwner";

      }
      @PostMapping("/edit/{OwnerId}")
      public String updateOwner(){
        return "redirect:OwnerList";
      }
      @RequestMapping("/delete/{OwnerId}")
      public String delete(@PathVariable("OwnerId") Long ownerId){

        ownerService.deleteById(ownerId);
        return "redirect:/";

      }

}
