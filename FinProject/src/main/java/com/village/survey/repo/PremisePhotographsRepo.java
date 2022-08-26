package com.village.survey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.PremisePhotographs;

@Repository
public interface PremisePhotographsRepo extends JpaRepository<PremisePhotographs, Long> {

}
