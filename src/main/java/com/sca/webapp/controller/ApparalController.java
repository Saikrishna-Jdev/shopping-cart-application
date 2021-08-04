package com.sca.webapp.controller;

import com.sca.webapp.entity.Apparal;
import com.sca.webapp.service.ApparalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apparal")
public class ApparalController {

    @Autowired
    private ApparalService apparalService;

    @PostMapping("/saveApparal")
    public Apparal saveApparal(@RequestBody Apparal apparal){
        System.out.println(apparal.getBrand());
        return apparalService.saveApparal(apparal);

    }

    @GetMapping("/all")
    public List<Apparal> getAll(){

        return apparalService.getApparals();
    }
}
