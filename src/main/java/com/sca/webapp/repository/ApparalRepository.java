package com.sca.webapp.repository;

import com.sca.webapp.entity.Apparal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApparalRepository extends JpaRepository<Apparal,Integer> {
}
