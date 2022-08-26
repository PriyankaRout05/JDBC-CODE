
public class Test1 {
	public static void main(String []args) {
		doStuff(); 
	}
	public static void doStuff() {
		doMoreStuff();
		System.out.println("hi");
	}
	public static void doMoreStuff() {
		System.out.println(10/0);
	}

}
