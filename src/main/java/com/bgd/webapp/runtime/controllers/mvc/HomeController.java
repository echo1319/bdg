package com.bgd.webapp.runtime.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings("unchecked")
@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String getHome(Model model) {
        model.addAttribute("logo", "Big Green Data");
        return "home";
    }


}
