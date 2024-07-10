package com.kao.springboot.demo.SpringBootDemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class FunRestController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/welcome")
    public String sayHello(@RequestParam(required = false) String locale) {
        Locale currentLocale = Locale.TAIWAN;
        if (locale != null){
            if (locale.toLowerCase().equals("zh-tw"))
                currentLocale = Locale.TAIWAN;
            else if (locale.toLowerCase().equals("en"))
                currentLocale = Locale.US;
            else if (locale.toLowerCase().equals("fr"))
                currentLocale = Locale.FRANCE;
        }
        return messageSource.getMessage("welcome.message", null, currentLocale);
    }
}