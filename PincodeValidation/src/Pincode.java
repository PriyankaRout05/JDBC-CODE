import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pincode {
	
	//Function to valid pin code of India
	public static boolean isValidPinCode(String pinCode) {
		//regex to check valid pin code of India
		String regex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
	
		
		//compile the regex 
		Pattern p = Pattern.compile(regex);
		
		//If the pin code is empty return false
		if(pinCode == null) {
		return false;
	}
		//pattern class contains matcher() method
		// to find between given pin code and regular expression
		Matcher m = p.matcher(pinCode);
		
		//return if the pin code  matched the regex
		
		return m.matches();
	}
	//Driver code 
	public static void main(String args[]) {
		
		//Test case1:
		String num1 = "123434";
		System.out.println(num1  + ":"+isValidPinCode(num1));
		
		//Testcase2:
		String num2 ="201 303";
		System.out.println(num2 + ":"+isValidPinCode(num2));
		
		//TestCase3:
		String num3="012345";
		System.out.println(num3 +":"+isValidPinCode(num3));
		
		//TestCase4:
		String num4 ="7312633";
		System.out.println(num4 + ":"+isValidPinCode(num4));
		
	}

		
		

}
