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
import com.village.survey.dao.BranchDao;
import com.village.survey.dto.BranchDTO;
import com.village.survey.entity.Branch;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class BranchService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BranchDao branchDao;

	/**
	 * 
	 * @param branch
	 * @return
	 */
	public Branch saveBranch(Branch branch) {
		// TODO user id need to be loaded form user context.
		branch.setCreatedUser(1L);
		branch.setModifiedUser(1L);
		return branchDao.save(branch);
	}

	/**
	 * This method for update Branch
	 * 
	 * @param state
	 * @return
	 */
	public Branch updateBranch(Branch branch) {
		List<Branch> branchList = Optional.ofNullable(branchDao.findById(branch.getId()))
				.orElseThrow(() -> new CustomException("Branch not found for this id :: " + branch.getId()));
		Branch branchDto = new Branch();
		if (!branchList.isEmpty()) {
			branchDto = branchList.get(0);
			branchDto.setModifiedOn(new Date());
			branchDto.setModifiedUser(1L);
			branchDto.setName(branch.getName());
			branchDto.setMandal(branch.getMandal());
			branchDto = branchDao.updte(branchDto);
			logger.info("Branch is updated");
		}
		return branchDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Branch getBranchById(Long id) {
		List<Branch> branchList = Optional.ofNullable(branchDao.findById(id))
				.orElseThrow(() -> new CustomException("Branch not found for this id :: " + id));
		return !branchList.isEmpty() ? branchList.get(0) : new Branch();

	}

	/**
	 * This method for get all Branch
	 * 
	 * @return
	 */
	public List<Branch> getAllBranch() {
		return branchDao.findAll().stream().parallel().sorted(Comparator.comparingLong(Branch::getId).reversed())
				.collect(Collectors.toList());
	}

	public BranchDTO getAllDistrictByBranchId(Long id) {
		return branchDao.getAllDistrictByBranchId(id);

	}

	public List<Branch> getBranchByname(String name) {
		return Optional.ofNullable(branchDao.findByname(name))
				.orElseThrow(() -> new CustomException("Branch not found for this name :: " + name));


	}

}
