
public class StringDriver {
	public static void main(String[] args) {
		String str1 = "Priyanka"; //it is a literal and that Priyanka is created string pull
		String str2 = "Priyanka";
		String str3 = new String("Priyanka"); // here we are creating new object in our heap
		//String str3 = new String("priyanka");
	System.out.println(str1 == str2);//here str1==str2 as we are commited by equal to equal to so both are literal it will return TRUE
	System.out.println(str1 == str3);//here output is FALSE bcz in str1 is literal and object is string constant and
	                               //str3 is in heap and we are commited both the reference which are different so thats the reason it is false
	
	System.out.println(str1.equals(str3));//op=true
	//System.out.println(str1.equalsIgnoreCase(str3));//it is ignoring the case and op is TRUE
	
	}
	

}
//the equals methods check for content .so it will check for the content of the string