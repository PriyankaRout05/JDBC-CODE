package com.village.survey.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VillageController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * This method for save village 
	 */
	public String saveVillage(@RequetsBody Village village) {
		villagaeService.saveVillage(village);
		return new village;
		
	}

}
