package com.bgd.webapp.runtime.controllers.mvc;

import com.bgd.webapp.api.indices.AQI;
import com.bgd.webapp.api.indices.AQI_AIR_QUALITY;
import com.bgd.webapp.api.indices.ERPI;
import com.bgd.webapp.api.indices.ERPI_AIR_QUALITY;
import com.bgd.webapp.api.indices.Humidex;
import com.bgd.webapp.api.indices.POLLUTION_FACTORS;
import com.bgd.webapp.api.indices.THERMAL_COMFORT;
import com.bgd.webapp.api.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unchecked")
@Controller
public class HomeController {
    @Autowired
    private MetricsService gardenMetricsService;

    @Autowired
    private MetricsService gardenAetherMetricsService;

    private List<AQI> aqiCity = new ArrayList<>();
    private List<AQI> aqiGarden = new ArrayList<>();

    private List<ERPI> erpiCity = new ArrayList<>();
    private List<ERPI> erpiGarden = new ArrayList<>();

    @PostConstruct
    private void initLists() {
        aqiCity.add(new AQI(48, AQI_AIR_QUALITY.GOOD, POLLUTION_FACTORS.CO));
        aqiCity.add(new AQI(54, AQI_AIR_QUALITY.MEDIOCRE, POLLUTION_FACTORS.NO2));
        aqiCity.add(new AQI(53, AQI_AIR_QUALITY.MEDIOCRE, POLLUTION_FACTORS.SO2));
        aqiCity.add(new AQI(51, AQI_AIR_QUALITY.MEDIOCRE, POLLUTION_FACTORS.O3));
        aqiCity.add(new AQI(50, AQI_AIR_QUALITY.MEDIOCRE, POLLUTION_FACTORS.CO));


        aqiGarden.add(new AQI(40, AQI_AIR_QUALITY.GOOD, POLLUTION_FACTORS.CO));
        aqiGarden.add(new AQI(41, AQI_AIR_QUALITY.GOOD, POLLUTION_FACTORS.NO2));


        erpiCity.add(new ERPI(48, ERPI_AIR_QUALITY.ADEQUATE, POLLUTION_FACTORS.CO));
        erpiCity.add(new ERPI(55, ERPI_AIR_QUALITY.ADEQUATE, POLLUTION_FACTORS.NO2));
        erpiCity.add(new ERPI(62, ERPI_AIR_QUALITY.ADEQUATE, POLLUTION_FACTORS.SO2));
        erpiCity.add(new ERPI(76, ERPI_AIR_QUALITY.ADEQUATE, POLLUTION_FACTORS.O3));
        erpiCity.add(new ERPI(83, ERPI_AIR_QUALITY.ADEQUATE, POLLUTION_FACTORS.CO));

        erpiGarden.add(new ERPI(38, ERPI_AIR_QUALITY.SATISFACTORY, POLLUTION_FACTORS.CO));
        erpiGarden.add(new ERPI(40, ERPI_AIR_QUALITY.SATISFACTORY, POLLUTION_FACTORS.NO2));


    }


    @GetMapping(path = "/")
    public String getHome(Model model) {

        model.addAttribute("windDirection", "NW");
        model.addAttribute("windSpeed", 2);
        model.addAttribute("temperature", 25);
        model.addAttribute("humidity", 50);


        model.addAttribute("cityErpiStatus", "Μέτρια");
        model.addAttribute("gardenErpiStatus", "Καλή");
        model.addAttribute("cityHumidexStatus", "Μέτρια");
        model.addAttribute("gardenHumidexStatus", "Καλή");


        model.addAttribute("aqiGarden", chooseRandomAqi("garden"));
        model.addAttribute("erpiGarden", chooseRandomErpi("garden"));
        model.addAttribute("humidexGarden", chooseRandomHumidex("garden"));

        model.addAttribute("aqiCity", chooseRandomAqi("city"));
        model.addAttribute("erpiCity", chooseRandomErpi("city"));
        model.addAttribute("humidexCity", chooseRandomHumidex("city"));

        return "home";
    }

    private Humidex chooseRandomHumidex(String location) {

        if (location.equals("city")) {
            return new Humidex(40, THERMAL_COMFORT.SLIGHTLY_UNCOMFORTABLE);
        } else {
            return new Humidex(35, THERMAL_COMFORT.NORMAL);
        }
    }

    private ERPI chooseRandomErpi(String location) {
        if (location.equals("city")) {
            return erpiCity.get(getRandomInt(erpiCity));
        } else {
            return erpiGarden.get(getRandomInt(erpiGarden));
        }
    }

    private AQI chooseRandomAqi(String location) {
        if (location.equals("city")) {
            return aqiCity.get(getRandomInt(aqiCity));
        } else {
            return aqiGarden.get(getRandomInt(aqiGarden));
        }
    }

    private int getRandomInt(List list) {
        return ThreadLocalRandom.current().nextInt(1, list.size());
    }

    @GetMapping(path = "/garden")
    public String getGarden() {
        return "garden";
    }

    @GetMapping(path = "/info")
    public String getInfo() {
        return "info";
    }

    @GetMapping(path = "/test")
    public String getTest(Model model) {
        model.addAttribute("windDirection", "NW");
        model.addAttribute("windSpeed", 2);
        model.addAttribute("temperature", 25);
        model.addAttribute("humidity", 50);


        return "test";
    }
}
