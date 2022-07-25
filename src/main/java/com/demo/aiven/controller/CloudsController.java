package com.demo.aiven.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.demo.aiven.service.CloudServiceImpl;

@Controller
@PropertySource("classpath:project.properties")
public class CloudsController {

    public static String[] stringArray = {"azure", "aws", "google", "do", "upcloud"};
    private final CloudServiceImpl cloudService;

    @Value("${AIVEN_URL}")
    private String URL;

    public CloudsController(final CloudServiceImpl cloudService) {
        this.cloudService = cloudService;
    }

    /**
     * Retrieves clouds
     * @param model
     * @return
     */
    @GetMapping("/clouds")
    public String clouds(final Model model) {
        //I dont have experience with reactive programming, I will use old modelattibute approach
        model.addAttribute("cloudsMap", cloudService.getCloudsForProvider(URL));
        model.addAttribute("cloudProviders", stringArray);

        return "clouds";
    }

}