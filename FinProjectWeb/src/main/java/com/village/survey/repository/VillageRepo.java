package com.village.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.village.survey.entity.Village;

@Repository
public interface VillageRepo extends JpaRepository<Village, Long> {

	@Query(value = "select v.name as village,v.no_of_households as noofhh from village v\n"
			+ "inner join panchayath p on p.id=v.panchayath \n"
			+ "inner join mandal m on m.id=p.mandal \n"
			+ "where mandal=1", nativeQuery = true)
	public List<Village> getVillagesByBlock(long id);

}