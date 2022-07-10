//package com.oky.demo.controller;
package okytest.okygogo.TESTSERVICE;

//import com.oky.demo.service.CovidService;
import okytest.okygogo.TESTSERVICE.CovidService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CovidController {

    @Autowired
    private final CovidService covidService;

    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping(value = "/covidInfo")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Map<String,Object> covidInfo(){

        Map<String, Object> covidInfo = covidService.getCovidInfo();

        return covidInfo;
    }

}
