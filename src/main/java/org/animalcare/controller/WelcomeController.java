package org.animalcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class WelcomeController {
    @RequestMapping({"","/","/Welcome","/Welcome.html"})
    public String Welcome(){
        return "Welcome";
    }
}
