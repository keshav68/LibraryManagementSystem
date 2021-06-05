import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Store {
	
	/**
	 * Description: This class will simply call the corresponding class and get to read details from 
	 * it and then storing to an array of employee class. and then after all this just printing the values by calling printInfo method accordingly.
	 */
	
	protected static Employee[] employees;
	protected boolean inputAgain = true;
	public static int m=0, n=0;

	public Store(int size) {
		this.employees = new Employee[size];
	}
	
	public void readDetails(Scanner input){
		//conditions to read the types of Employees
		if(this.m<employees.length){
			while(m< employees.length){
				System.out.printf("Enter details of Employee: %d\n", (m+1));
				System.out.printf(
						"\t1. Regular\n" +
						"\t2. Contractor\n");
				System.out.print("Enter type of Employee: ");

				int value = input.nextInt();
				inputAgain= false;

				//if-else condition to determine whether the user is regular or Contractor.
				if(value == 1){
					//creating and initializing the regular class object and assigning it to array of referenced of Employee class
					if(employees[employees.length-1]!=null){
						System.err.println("*****Array is full.... cannot add more elements *****");
					}
					else{
						employees[m] = new Regular(0, null, null, null, 0, 0);
						employees[m++].readInfo(input);
					}

				}else if(value == 2){
					if(employees[employees.length-1]!=null){
						System.err.println("*****Array is full.... cannot add more elements *****");
					}
					else{
						//creating and initializing the Contractor class object and assigning it to array of referenced of Employee class
						employees[m] = new Contractor(0, null, null, null, 0, 0, 0);
						employees[m++].readInfo(input);
					}
				}else{
					System.err.println("Please choose any one between 1 and 2");
				}
			}

		}
			
	}
	
	public  void readFiles(Scanner input) {
		try{
		    
		    FileInputStream fis = new FileInputStream("G:\\\\Sem 02\\\\OOPs\\\\Lab08\\\\employees.txt");
			byte []b = new byte[fis.available()];
			fis.read(b);
			String str = new String(b);
			String[] s = str.split(" ");

			for(int i=0;i< 2;){
				if(employees.length == 1){

					employees[n] = new Regular(Integer.valueOf(s[1]), s[2], s[3], s[4], Integer.parseInt(s[5]), Double.valueOf(s[6]));
					i=i+2;
				}
				if(employees.length == 2){
					employees[n] = new Regular(Integer.valueOf(s[1]), s[2], s[3], s[4], Integer.parseInt(s[5]), Double.valueOf(s[6]));
					n=1;
					employees[n] = new Contractor(Integer.valueOf(s[8]), s[9], s[10], s[11], Integer.valueOf(s[12]), Double.valueOf(s[13]), Double.valueOf(s[14]));
					i=i+2;
				}
				if(employees.length == 3){
					employees[n] = new Regular(Integer.valueOf(s[1]), s[2], s[3], s[4], Integer.parseInt(s[5]), Double.valueOf(s[6]));
					n=1;
					employees[n] = new Contractor(Integer.valueOf(s[8]), s[9], s[10], s[11], Integer.valueOf(s[12]), Double.valueOf(s[13]), Double.valueOf(s[14]));
					n=2;
					employees[n] = new Regular(Integer.valueOf(s[16]), s[17], s[18], s[19], Integer.valueOf(s[20]), Double.valueOf(s[21]));
					i=i+2;
				}
				if(employees.length != 1 && employees.length != 2 && employees.length != 3){
					employees[n] = new Regular(Integer.valueOf(s[1]), s[2], s[3], s[4], Integer.parseInt(s[5]), Double.valueOf(s[6]));
					n=1;
					employees[n] = new Contractor(Integer.valueOf(s[8]), s[9], s[10], s[11], Integer.valueOf(s[12]), Double.valueOf(s[13]), Double.valueOf(s[14]));
					n=2;
					employees[n] = new Regular(Integer.valueOf(s[16]), s[17], s[18], s[19], Integer.valueOf(s[20]), Double.valueOf(s[21]));
					i=i+2;
					m=3;
				}
			}
		}
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	// printing each object details using for loop
	public static void printDetails(){
		if(employees.length < 0){
			System.out.println("Kindly enter some detail: ");
		}else 
			if(n<employees.length){
			for (int i = 0; i < employees.length; i++) {
				if(employees[i]!=null){
					employees[i].printInfo();
				}
			}
		}
		else {
//			System.out.println(employees.length);
			for (int i = 0; i < employees.length; i++) {
				employees[i].printInfo();
			}
		}
	}
	
	//method to print lines.
		public static void printLine(){
			System.out.print("=");
		}

	//method to print the title and some lines
	public static void printTitle(String name){
		// checking employees array is empty or not
		boolean isEmpty = false;
		for(int i=0;i<employees.length;i++ ){
			if(employees[i] != null ){
				isEmpty = true;
			}
		}
		// VALIDATING
		if(isEmpty == false){
			System.err.println("***** No elements in the Array *****");
		}
		else {
			for (int i = 0; i < 80; i++) {
				printLine();
			}
			System.out.format("\n                       %s Store Management System\n", name);
			for (int i = 0; i < 80; i++) {
				printLine();
			}
			System.out.print("\n  Emp#|                Name |          Email |          Phone |      Salary|\n");
			for (int i = 0; i < 80; i++) {
				printLine();
			}
			System.out.println();

			// printing the details of every employees
			printDetails();
		}

		}
}
