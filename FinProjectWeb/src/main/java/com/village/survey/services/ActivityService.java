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
import com.village.survey.dao.ActivityDao;
import com.village.survey.entity.Activity;

@Service
public class ActivityService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ActivityDao activityDao;

	/**
	 * @param activity
	 * @return
	 */
	public Activity saveActivity(Activity activity) {

		activity.setCreatedUser(1L);
		activity.setModifiedUser(1L);
		return activityDao.save(activity);
	}

	/**
	 * @param activity
	 * @return
	 */
	public Activity updateActivity(Activity activity) {
		List<Activity> activityList = Optional.ofNullable(activityDao.findById(activity.getId()))
				.orElseThrow(() -> new CustomException("Activity not found for this id :: " + activity.getId()));
		Activity activityDto = new Activity();
		if (!activityList.isEmpty()) {
			activityDto = activityList.get(0);
			activityDto.setModifiedOn(new Date());
			activityDto.setModifiedUser(1L);
			activityDto.setName(activity.getName());
			activityDto = activityDao.update(activityDto);
			logger.info("activity updted");
		}
		return activityDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Activity getActivity(Long id) {
		List<Activity> activityList = Optional.ofNullable(activityDao.findById(id))
				.orElseThrow(() -> new CustomException("Activity not found for this id :: " + id));
		return !activityList.isEmpty() ? activityList.get(0) : new Activity();

	}

	/**
	 * @return
	 */
	public List<Activity> getAllActivity() {
		return activityDao.findAll().stream().parallel().sorted(Comparator.comparingLong(Activity::getId).reversed())
				.collect(Collectors.toList());
	}

}
