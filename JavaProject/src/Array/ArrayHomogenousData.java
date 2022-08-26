package Array;

public class ArrayHomogenousData {
	public static void main(String[] args) {
		int a[]=new int[5];
		a[0]=100;
		a[1]=200;
		a[2]=300;
		a[3]=400;
		a[4]=500;
		System.out.println(a[2]);
		System.out.println(a.length);
		//print array elements using for loop
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		System.out.println("--------printing using for each loop-------");

		String s[]= {"java","sql","aptitude","sleelnium"};
		for(String data:s) {
		System.out.println(data);
		}
	}

}
