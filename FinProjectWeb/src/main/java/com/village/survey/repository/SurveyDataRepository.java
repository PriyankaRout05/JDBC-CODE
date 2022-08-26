package com.village.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.SurveyData;

@Repository
public interface SurveyDataRepository extends JpaRepository<SurveyData, Integer> {

	@Query(value = "select * from visited_villages where visited_villages_id=?", nativeQuery = true)
	public List<SurveyData> getsurveydata();

}
