package org.animalcare.controller;
import org.animalcare.entity.Doctor;
import org.animalcare.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "doctors/DoctorList";
    }
    @RequestMapping("/delete/{doctorId}")
    public String delete(@PathVariable("doctorId") Long doctorId){
        doctorService.deleteById(doctorId);
        return "redirect:/Doctor/Doctor";
    }
    @GetMapping("/register")
    public String registerDoc(Model model){
        Doctor doctor=new Doctor();
        model.addAttribute("doctor",doctor);
        return "doctors/CreateDoctor";
    }
    @PostMapping("/register")
    public String submitDoc(@ModelAttribute("doctor") Doctor doctor){
        doctorService.save(doctor);

        return "redirect:/Doctor/Doctor";
    }

    @GetMapping("/edit/{doctorId}")
    public String EditDoc(@PathVariable("doctorId") Long doctorId,Model model){
        Doctor doc=doctorService.findById(doctorId);
        model.addAttribute("doctor",doc);
        return "doctors/EditDoc";

    }
    @PostMapping("/edit")
    public String updateDoc(@ModelAttribute("doctor") Doctor doctor){
        doctorService.Update(doctor);
        return "redirect:/Doctor/Doctor";
    }
}

