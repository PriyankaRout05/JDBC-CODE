package com.village.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.BranchSetUp;
import com.village.survey.entity.Village;

@Repository
public interface BranchSetUpRepo extends JpaRepository<BranchSetUp, Long> {

	@Query(value = "select bs.branch_set_up_id,br.title as title,pr.particular as particulars, r.value as data,r.assetid as assetid from branch_set_up_survey br\n"
			+ "inner join particular_records pr on pr.particular_records_id= br.survey_id\n"
			+ "inner join branch_set_up bs on br.branch_set_up_survey_id=bs.branch_set_up_id\n"
			+ "inner join records r on r.records_id= pr.particular_id\n"
			+ "where title='HR Process SetUp';", nativeQuery = true)
	public List<BranchSetUp> getbranchSetUp();
//
//	@Query(value = "select v.name as village,v.no_of_households as noofhh from village v\n"
//			+ "inner join panchayath p on p.id=v.panchayath \n" 
//			+ "inner join mandal m on m.id=p.mandal \n"
//			+ "where mandal=?1", nativeQuery = true)
//	public List<Village> getVillagesByBlock();

}
