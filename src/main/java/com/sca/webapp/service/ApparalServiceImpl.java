package com.sca.webapp.service;

import com.sca.webapp.entity.Apparal;
import com.sca.webapp.repository.ApparalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApparalServiceImpl implements ApparalService{

    @Autowired
    private ApparalRepository repository;


    @Override
    public Apparal saveApparal(Apparal apparal) {
        return repository.save(apparal);
    }

    @Override
    public List<Apparal> getApparals() {
        return repository.findAll();
    }
}
