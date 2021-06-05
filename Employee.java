import java.util.Scanner;

public class Employee extends Person {
	
	/**
	 * Description: This class will let the user to enter employee number through readInfo() and will print it out using printInfo().
	 */
	
	//instance variables
	protected int employeeNumber;

	//parameterized constructor
	public Employee(int employeeNumber, String firstName, String lastName, String email, long phoneNumber) {
		super(firstName, lastName, email, phoneNumber);
		this.employeeNumber = employeeNumber;
	}

	//method to read input from user
	@Override
	public void readInfo(Scanner input) {
		super.readInfo(input);
		System.out.print("enter the employee Number: ");
		int employee = input.nextInt();
		this.employeeNumber = employee;
	}
	
	// method to print info
	@Override
	public void printInfo() {
		System.out.printf(" %2d | %19s | %14s | %15d |", employeeNumber, (firstName+" "+lastName), email, phoneNumber);	
	}

}
