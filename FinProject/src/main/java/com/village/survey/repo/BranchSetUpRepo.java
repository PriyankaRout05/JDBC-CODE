package com.village.survey.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.BranchSetUp;

@Repository
public interface BranchSetUpRepo extends JpaRepository<BranchSetUp, Long> {

	@Query(value = "select br.title as title,pr.particular as particulars, r.value as data,r.assetid as assetid from branch_set_up_survey br\n"
			+ "inner join particular_records pr on pr.particular_records_id= br.survey_id\n"
			+ "inner join records r on r.records_id= pr.particular_id\n"
			+ "where title='HR Process SetUp';", nativeQuery = true)
	public List<BranchSetUp> getbranchSetUp();

}
