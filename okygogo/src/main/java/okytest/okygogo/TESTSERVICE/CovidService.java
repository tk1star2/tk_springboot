//package com.oky.demo.service;
package okytest.okygogo.TESTSERVICE;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Service
public class CovidService {

    private final String filePath = "data/covid_info.txt";

    public Map<String, Object> getCovidInfo(){

        Map<String, Object> covidInfoMap = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            File resource = new ClassPathResource(filePath).getFile();
            String text = new String(Files.readAllBytes(resource.toPath()));
            covidInfoMap = objectMapper.readValue(text, Map.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return covidInfoMap;
    }

}
