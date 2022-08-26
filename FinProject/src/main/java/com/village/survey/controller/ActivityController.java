package com.village.survey.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.survey.core.util.ApiStatus;
import com.village.survey.entity.Activity;
import com.village.survey.services.ActivityService;

@RestController
@RequestMapping("/api/administration/activity")
@CrossOrigin
public class ActivityController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ActivityService activityService;

	/**
	 * @param activity
	 * @return
	 */
	@PostMapping("/saveActivity")
	public ResponseEntity<ApiStatus<Activity>> saveActivity(@RequestBody Activity activity) {
		Activity activityResponse = activityService.saveActivity(activity);
		ApiStatus<Activity> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"CREATED ACTIVITY RECORD SUCCESSFULLY ", activityResponse);
		return new ResponseEntity<ApiStatus<Activity>>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * @param activity
	 * @return
	 */
	@PutMapping("/updateActivity")
	public ResponseEntity<ApiStatus<Activity>> updateActivity(@RequestBody Activity activity) {
		Activity activityResponse = activityService.updateActivity(activity);
		ApiStatus<Activity> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"UPDATE ACTIVITY RECORD SUCCESSFULLY ", activityResponse);
		return new ResponseEntity<ApiStatus<Activity>>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/getActivityById/{id}")
	public ResponseEntity<ApiStatus<Activity>> getActivity(@PathVariable(value = "id") Long id) {
		Activity ActivityResponse = activityService.getActivity(id);
		ApiStatus<Activity> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"GET SINGLE ACTIVITY RECORD SUCCESSFULLY ", ActivityResponse);
		return new ResponseEntity<ApiStatus<Activity>>(apiStatus, HttpStatus.OK);
	}

	/**
	 * @return
	 */
	@GetMapping("/getAllActivity")
	public ResponseEntity<ApiStatus<List<Activity>>> getAllActivity() {
		List<Activity> activityList = activityService.getAllActivity();
		ApiStatus<List<Activity>> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"GET ALL ACTIVITY RECORD SUCCESSFULLY ", activityList);
		return new ResponseEntity<ApiStatus<List<Activity>>>(apiStatus, HttpStatus.OK);
	}

}
