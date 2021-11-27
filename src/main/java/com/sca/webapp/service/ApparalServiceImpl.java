package com.sca.webapp.service;

import com.sca.webapp.entity.Apparal;
import com.sca.webapp.exception.ApparalNotFoundException;
import com.sca.webapp.exception.EmptyInputFieldException;
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
    Apparal apparal;


    @Override
    public Apparal saveApparal(Apparal apparal) {

        log.info("Inside the saveApparal() in Service");
        if(apparal.getBrand().isEmpty()||apparal.getDesign().isEmpty())
            throw new EmptyInputFieldException("Mandatory Fields Data is Missing");
        Apparal savedApparal=repository.save(apparal);
        log.info("Apparal Saved {} ",apparal);
        return savedApparal;
    }
    public Apparal getApparalById(int apparalId){
        log.info("In getApparalById()");
        apparal=repository.getById(apparalId);
        log.info("The Apparal is Fetching by Id: {}",apparalId);
        if(apparal!=null)
            return apparal;
        else
            throw new ApparalNotFoundException("Sorry The Apparal which you are looking is not found");
    }

    @Override
    public List<Apparal> getApparals() {
        log.info("Getting All Apparals :  {}",repository.findAll());
        return repository.findAll();
    }
}
