import java.util.InputMismatchException;
import java.util.Scanner;
public class Lab8 {
	/**
	 * This class will help to get the whole code executed with the help of Main method. It is also having try-catch to catch the exception and ask the user to
	 * enter it again respectively if the user is inputing the invalid value (like negative, Characters, Strings, decimal)
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = -1;
		int opt = -1;
		boolean check = true, check2 = true;

		//Scanner helping to read details of user from whole project
		Scanner input = new Scanner(System.in);
		

		System.out.print("Enter name of the Store:");
		String storeName = input.nextLine();

		// try-catch, To make sure if the user is inputing valid input for the number of employees.
		 while(check){ 
			try{
				while(num<=0){
						System.out.print("How many employees do you have? ");
						num = input.nextInt();
						check = false;
					} 
				}
				catch(InputMismatchException ex) {
					System.err.print("*****Input Mismatch Exception while reading number of employees*****\n");
					input.next();
				}
		}
		 
		//instance class object of Store class with the parameter of number of employees.														
		Store s = new Store(num);
		
		// try-catch, To make sure if the user is inputing valid input for the Options.
		while(opt!= 4 || check2) {
			
			try {
				System.out.printf(
						"\t1. Read info from user\n" +
						"\t2. Read info from files\n" +
						"\t3. print Employee Details\n" +
						"\t4. Quit\n" );
				System.out.print("Enter your option: ");
				opt = input.nextInt();
				check2 = false;
				
					if(opt!= 1 && opt!= 2 && opt!=3 && opt!=4) {
			        	System.out.println("Invalid option.... please try again...");
			        	continue;
			        }

					if(opt == 1){
						if(s.m == num){
							System.err.println("*****Array is full.... cannot add more elements *****");
							System.exit(0);
						}else {
							s.readDetails(input);
						}
					}
					
					if(opt == 2){
						if(s.m == num){
							System.err.println("*****Array is full.... cannot add more elements *****");
							System.exit(0);
						}else {
							s.readFiles(input);
						}

					}
					
					 if(opt == 3) {
						 Store.printTitle(storeName);

					 }
					 if(opt == 4){
						 System.out.println("Goodbye... Have a nice day!");
					 	System.exit(0);
					 }
			}
			catch(InputMismatchException ex){
				System.out.print("*****Input Mismatch Exception while reading selection of process*****\n");
				input.next();
			}
			
		}
		 System.out.println("Goodbye... Have a nice day!");
		 
		 input.close();
	}
	public static boolean isInteger( String input ) { //Pass in string
		try { //Try to make the input into an integer
			Integer.parseInt( input );
			return true; //Return true if it works
		}
		catch( Exception e ) {
			return false; //If it doesn't work return false
		}
	}

}
