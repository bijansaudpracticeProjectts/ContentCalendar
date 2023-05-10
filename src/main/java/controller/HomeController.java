package dev.bijansaudcontentcalender.contentcalender.controller;

import dev.bijansaudcontentcalender.contentcalender.config.ContentCalendarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


//    @GetMapping("/")
//    public String home(){
//        return welcomeMessage;
//    }

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }


    @GetMapping("/")
    public ContentCalendarProperties home(){
        return properties;
    }
}
