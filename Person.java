import java.util.Scanner;

public abstract class Person {
	
	/**
	 * Assessment: Lab08
	 * Prof. Name: James Mwangi
	 * Name: Keshav Sandhu
	 * Description: This class basically serves the purpose of abstract class with local variables, one abstract method and one Non-abstract method.
	 */
	
	//Attributes
		protected String firstName;
		protected String lastName;
		protected String email;
		protected long phoneNumber;
		
		
		//parameterized constructor 
		public Person(String firstName, String lastName, String email, long phoneNumber) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}
		
		//method to read input from users
			public void readInfo(Scanner input) {
				System.out.print("enter the first name: ");
				firstName = input.next();
				
				System.out.print("enter the last name: ");
				lastName = input.next();
				
				System.out.print("enter the email address: ");
				email = input.next();
				
				System.out.print("enter the phone number: ");
				phoneNumber = input.nextLong();
			}
			
			//Abstract method
			abstract public void printInfo();

}
