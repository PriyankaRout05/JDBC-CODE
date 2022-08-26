package Array;

public class DemoArray {
	public static void main(String []args) {
		
		//array creation 
		int a[]=new int[3];
		System.out.println(a[0]); //0
		System.out.println(a[1]); //0
		System.out.println(a[2]); //0
		//System.out.println(a[3]); //Exception in thread "main" Array indexoutofBoundException
		
		//storing elements in an array 
		a[0]=100;
		a[1]=200;
		a[2]=300;
		//Retrieving
		System.out.println(a[0]); //100
		System.out.println(a[1]); //200
		System.out.println(a[2]); //300
		System.out.println(a.length); //3
		/* Array index out of bounds exception
		a[3]=400;
		System.out.println(a[3]);
		a[-1]=400;
		System.out.println(a[-1]);*/
		String s[]= {"okati","rundu","mudhu","nalugu","arau","edu","enamdi","tomidi","padi"};
		
		System.out.println(s[0]);
		System.out.println(s[1]);
		System.out.println(s[2]);
		System.out.println(s[8]);
		
		
	}

}
