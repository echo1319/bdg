package com.bgd.webapp.runtime.controllers.mvc;

import com.bgd.webapp.api.dto.GardenAetherMetrics;
import com.bgd.webapp.api.dto.GardenMetrics;
import com.bgd.webapp.api.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings("unchecked")
@Controller
public class HomeController {
    @Autowired
    private MetricsService gardenMetricsService;

    @Autowired
    private MetricsService gardenAetherMetricsService;

    @GetMapping(path = "/")
    public String getHome(Model model) {

        model.addAttribute("windDirection", "NW");
        model.addAttribute("windSpeed", 200);

        model.addAttribute("temperature", 40);
        model.addAttribute("humidity", 50);

        return "home";
    }


}
