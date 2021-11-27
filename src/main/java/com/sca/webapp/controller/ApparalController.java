package com.sca.webapp.controller;

import com.sca.webapp.entity.Apparal;
import com.sca.webapp.service.ApparalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apparal")
@Slf4j
public class ApparalController {

    @Autowired
    private ApparalService apparalService;

    @PostMapping("/saveApparal")
    public Apparal saveApparal(@RequestBody Apparal apparal){
        log.debug("Saving Apparal  {}  into database ",apparal.getBrand());
        return apparalService.saveApparal(apparal);

    }

    @GetMapping("/all")
    public List<Apparal> getAll(){
        log.info("getting the all Apparals from Database : {}",apparalService.getApparals());

        return apparalService.getApparals();
    }
}
