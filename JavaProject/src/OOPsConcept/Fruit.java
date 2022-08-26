package OOPsConcept;
  abstract  class Fruit {
	  public abstract  int getNoOfVariety();
 }
  class Apple extends Fruit {
  public int getNoOfVariety() {
	  return 4;
     }
	 }
  class Mango extends Fruit{
	  public int getNoOfVariety() {
		  return 10;
	  }
  }
  class Main{
	  public static void main(String args[]) {
		  Apple a = new Apple();
		  System.out.println(a.getNoOfVariety());
		  Mango m = new Mango();
		  System.out.println(m.getNoOfVariety());
	  }
  }
