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
import com.village.survey.dao.StateDao;
import com.village.survey.entity.State;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class StateService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StateDao stateDao;

	/**
	 * 
	 * @param state
	 * @return
	 */
	public State saveState(State state) {
		// TODO user id need to be loaded form user context.
		state.setCreatedUser(1L);
		state.setModifiedUser(1L);
		return stateDao.save(state);
	}

	/**
	 * This method for update state
	 * 
	 * @param state
	 * @return
	 */
	public State updateState(State state) {
		List<State> stateList = Optional.ofNullable(stateDao.findById(state.getId()))
				.orElseThrow(() -> new CustomException("State not found for this id :: " + state.getId()));
		State stateDto = new State();
		if (!stateList.isEmpty()) {
			stateDto = stateList.get(0);
			stateDto.setModifiedOn(new Date());
			stateDto.setModifiedUser(1L);
			stateDto.setName(state.getName());
			stateDto = stateDao.updte(stateDto);
			logger.info("state updted");
		}
		return stateDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public State getState(Long id) {
		List<State> stateList = Optional.ofNullable(stateDao.findById(id))
				.orElseThrow(() -> new CustomException("State not found for this id :: " + id));
		return !stateList.isEmpty() ? stateList.get(0) : new State();

	}

	/**
	 * This method for get all state
	 * 
	 * @return
	 */
	public List<State> getAllState() {
		return stateDao.findAll().stream().parallel().sorted(Comparator.comparingLong(State::getId).reversed())
				.collect(Collectors.toList());
	}

}
