package Array;
import java.util.*;
public class ArrayUsingScanner {
	public static void main(String []args) {
		
		Scanner s = new Scanner(System.in);
		int size;
		System.out.println("Enter the size of an array:");
		size=s.nextInt();
		int a[]=new int[size];//an array gets created of size =4
		//for accepting inputs
		for(int i=0;i<a.length;i++) {
			
			a[i]=s.nextInt();
			
		}
		System.out.println("Array elements are.....");
		
		//for retrieving values
		for(int j=0;j<a.length;j++) {
			System.out.println(a[j]);
			
		}
		
		
	}

}
