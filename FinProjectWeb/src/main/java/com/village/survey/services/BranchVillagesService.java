package com.village.survey.services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.survey.core.util.CustomException;
import com.village.survey.dao.BranchVillagesDao;
import com.village.survey.entity.BranchVillages;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class BranchVillagesService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BranchVillagesDao branchVillagesDao;

	/**
	 * 
	 * @param branchVillages
	 * @return
	 */
	public BranchVillages saveBranchVillages(BranchVillages branchVillages) {
		// TODO user id need to be loaded form user context.
		branchVillages.setCreatedUser(1L);
		branchVillages.setModifiedUser(1L);
		return branchVillagesDao.save(branchVillages);
	}

	/**
	 * This method for update BranchVillages
	 * 
	 * @param state
	 * @return
	 */
	public BranchVillages updateBranchVillages(BranchVillages branchVillages) {
		List<BranchVillages> branchVillagesList = Optional
				.ofNullable(branchVillagesDao.findById(branchVillages.getId())).orElseThrow(
						() -> new CustomException("BranchVillages not found for this id :: " + branchVillages.getId()));
		BranchVillages branchVillagesDto = new BranchVillages();
		if (!branchVillagesList.isEmpty()) {
			branchVillagesDto = branchVillagesList.get(0);
			branchVillagesDto.setModifiedOn(new Date());
			branchVillagesDto.setModifiedUser(1L);
			branchVillagesDto = branchVillagesDao.updte(branchVillagesDto);
			logger.info("BranchVillages is updted");
		}
		return branchVillagesDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public BranchVillages getBranchVillagesById(Long id) {
		List<BranchVillages> branchVillagesList = Optional.ofNullable(branchVillagesDao.findById(id))
				.orElseThrow(() -> new CustomException("BranchVillages not found for this id :: " + id));
		return !branchVillagesList.isEmpty() ? branchVillagesList.get(0) : new BranchVillages();

	}

	/**
	 * This method for get all BranchVillages
	 * 
	 * @return
	 */
	public List<BranchVillages> getAllBranchVillages() {
		return branchVillagesDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(BranchVillages::getId).reversed()).collect(Collectors.toList());
	}

}
