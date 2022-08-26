package com.village.survey.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VillageApprovalPincodeValidation {
	
	public boolean isHomeState(String state, String zipcode) {
	    if (isValidZipCode(zipcode)) { 
	    // ...
	    }
	    return true;  
	}

	private boolean isValidZipCode(String zipcode) {
	    String regex = "^[60-64]{2}{0-9}{4}$";

	    Pattern p = Pattern.compile(regex);
	    // If the pin code is empty
	    // return false
	    if (zipcode == null) {
	        return false;
	    }

	    Matcher m = p.matcher(zipcode);
	    return m.matches();
	}

}
