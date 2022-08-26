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
import com.village.survey.dao.BranchOperationalBlocksDao;
import com.village.survey.dto.BranchDTO;
import com.village.survey.entity.BranchOperationalBlocks;

@Service
public class BranchOperationalBlocksService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BranchOperationalBlocksDao branchOperationalBlocksDao;

	/**
	 * 
	 * @param branch
	 * @return
	 */
	public BranchOperationalBlocks saveBranchOperationalBlocks(BranchOperationalBlocks branch) {
		// TODO user id need to be loaded form user context.
		branch.setCreatedUser(1L);
		branch.setModifiedUser(1L);
		return branchOperationalBlocksDao.save(branch);
	}

	/**
	 * This method for update BranchOperatioinalBlocks
	 * 
	 * @param branch
	 * @return
	 */
	public BranchOperationalBlocks updateBranchOperationalBlocks(BranchOperationalBlocks branch) {
		List<BranchOperationalBlocks> branchList = Optional
				.ofNullable(branchOperationalBlocksDao.findById(branch.getId())).orElseThrow(() -> new CustomException(
						"BranchOperationalBlocks not found for this id :: " + branch.getId()));
		BranchOperationalBlocks branchDto = new BranchOperationalBlocks();
		if (!branchList.isEmpty()) {
			branchDto = branchList.get(0);
			branchDto.setBranchId(branch.getBranchId());
			branchDto.setBlockId(branch.getBlockId());
			branchDto.setModifiedOn(new Date());
			branchDto.setModifiedUser(1L);
			branchDto = branchOperationalBlocksDao.update(branchDto);
			logger.info("BranchOperationalBlocks is updated");
		}
		return branchDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public BranchOperationalBlocks getBranchOperationalBlocksById(Long id) {
		List<BranchOperationalBlocks> branchOperationalBlocksList = Optional
				.ofNullable(branchOperationalBlocksDao.findById(id))
				.orElseThrow(() -> new CustomException("BranchOperationalBlocks not found for this id :: " + id));
		return !branchOperationalBlocksList.isEmpty() ? branchOperationalBlocksList.get(0)
				: new BranchOperationalBlocks();

	}

	/**
	 * This method for get all BranchOperationalBlocks
	 * 
	 * @return
	 */
	public List<BranchOperationalBlocks> getAllBranchOperationalBlocks() {
		return branchOperationalBlocksDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(BranchOperationalBlocks::getId).reversed())
				.collect(Collectors.toList());
	}

	public BranchDTO getAllBranchOperationalBlocksById(Long id) {
		return branchOperationalBlocksDao.getAllBranchOperationalBlocksById(id);
	}
}
