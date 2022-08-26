package com.village.survey.controller;

import java.util.List;

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

	private static final String SUCCCESS = "SUCCESS";

	@Autowired
	private ActivityService activityService;

	/**
	 * This method is for save Activity
	 * 
	 * @param activity
	 * @return
	 */
	@PostMapping("/saveActivity")
	public ResponseEntity<ApiStatus<Activity>> saveActivity(@RequestBody Activity activity) {
		Activity activityResponse = activityService.saveActivity(activity);
		ApiStatus<Activity> apiStatus = new ApiStatus<>(HttpStatus.CREATED, SUCCCESS,
				"CREATED ACTIVITY RECORD SUCCESSFULLY ", activityResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method is for update Activity
	 * 
	 * @param activity
	 * @return
	 */
	@PutMapping("/updateActivity")
	public ResponseEntity<ApiStatus<Activity>> updateActivity(@RequestBody Activity activity) {
		Activity activityResponse = activityService.updateActivity(activity);
		ApiStatus<Activity> apiStatus = new ApiStatus<>(HttpStatus.CREATED, SUCCCESS,
				"UPDATE ACTIVITY RECORD SUCCESSFULLY ", activityResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This method is for get Activity by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getActivityById/{id}")
	public ResponseEntity<ApiStatus<Activity>> getActivity(@PathVariable(value = "id") Long id) {
		Activity activityResponse = activityService.getActivity(id);
		ApiStatus<Activity> apiStatus = new ApiStatus<>(HttpStatus.OK, SUCCCESS,
				"GET SINGLE ACTIVITY RECORD SUCCESSFULLY ", activityResponse);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This method is for get all Activity
	 * 
	 * @return
	 */
	@GetMapping("/getAllActivity")
	public ResponseEntity<ApiStatus<List<Activity>>> getAllActivity() {
		List<Activity> activityList = activityService.getAllActivity();
		ApiStatus<List<Activity>> apiStatus = new ApiStatus<>(HttpStatus.OK, SUCCCESS,
				"GET ALL ACTIVITY RECORD SUCCESSFULLY ", activityList);
		return new ResponseEntity<>(apiStatus, HttpStatus.OK);
	}

}
