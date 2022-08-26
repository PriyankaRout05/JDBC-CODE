
public class Test2 {
	public static void main(String[] args) {
		System.out.println("statemnt1");
		try {
		System.out.println(10/0);
		}
		catch (ArithmeticException e) { 
			System.out.println(10/2);
		}
		System.out.println("statement-3");
	}

}
