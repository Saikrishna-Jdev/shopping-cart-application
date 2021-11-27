package com.sca.webapp.service;

import com.sca.webapp.entity.Apparal;

import java.util.List;

public interface ApparalService {

    Apparal saveApparal(Apparal apparal);
    List<Apparal> getApparals();
    Apparal getApparalById(int apparalId);

}
