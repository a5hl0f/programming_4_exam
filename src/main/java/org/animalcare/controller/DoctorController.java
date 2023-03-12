package org.animalcare.controller;

import org.animalcare.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("Doctor")
@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @RequestMapping({"","/","Doctor"  ,"Doctor.html"})
    public String doctorlist(Model model){
        model.addAttribute("doctors",doctorService.findAll());
        return "DoctorList";
    }
}

