import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//u have list of employee in which each employee have name ,age,salary.
//u have to increase salary of each employee  whose age is greater than 25 by 10% . 
//the condition isTHAT Employee age is should greater than 25age.
public class MainDriver {
	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<Employee>();
		Employee e1 = new Employee("Priyanka", 21, 10000);
		Employee e2 = new Employee("Sriyanka", 24, 12000);
		Employee e3 = new Employee("Mayanka", 27, 10116);
		Employee e4 = new Employee("priyanshu", 26, 24500);
		Employee e5 = new Employee("Sheryansu", 25, 18000);

		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);

		System.out.println("Original Salary!!1");
		System.out.println(employees);

		// here we used steam which is java 8 concept

		List<Employee> incrementedSalary = employees.stream().map(e -> {

			if (e.getAge() > 25) {
				e.setSalary(e.getSalary() * 1.10);
			}
			return e;
		}).collect(Collectors.toList());

		System.out.println("incremented Salary!!1");
		System.out.println(incrementedSalary);

	}

}
