package OOPsConcept;

abstract class Vehicle 
{
	public abstract int getNoOfWheels();
}
class Car extends Vehicle
{
	public int getNoOfWheels() 
	{
		return 4;
	}
}
class Bike extends Vehicle
{
	public int getNoOfWheels() 
	{
	return 2;	
    }
}	
	class Test{
		public static void main(String args[]) {
			 
			Car c = new Car();
			System.out.println(c.getNoOfWheels());
			Bike b = new Bike();
			System.out.println(b.getNoOfWheels());
		}
	}
