package com.sca.webapp.service;

import com.sca.webapp.entity.Apparal;
import com.sca.webapp.repository.ApparalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ApparalServiceImpl implements ApparalService{

    @Autowired
    private ApparalRepository repository;


    @Override
    public Apparal saveApparal(Apparal apparal) {
        log.info("Inside the saveApparal() in Service");
        log.info("Apparal Saved {} ",apparal);
        return repository.save(apparal);
    }

    @Override
    public List<Apparal> getApparals() {
        log.info("Getting All Apparals :  {}",repository.findAll());
        return repository.findAll();
    }
}
