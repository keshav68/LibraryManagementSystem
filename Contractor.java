import java.util.Scanner;

public class Contractor extends Employee {

	/**
	 * Description: This class will extend Employee class and let the user input hourly rate 
	 * and number of hours with the help of Overridden readInfo() and will print values through Overridden printInfo
	 */

	
	//instance variables
	protected double hourlyRate;
    protected double numHours;

    //parameterized constructor 
    public Contractor(int employeeNumber, String firstName, String lastName, String email, long phoneNumber, double numHours, double hourlyRate){
        super(employeeNumber, firstName, lastName, email, phoneNumber);
        this.numHours = numHours;
        this.hourlyRate = hourlyRate;
    }

    //method to enter the hoursRate and numHours
    @Override
    public void readInfo(Scanner input){
        super.readInfo(input);
        System.out.print("Enter hourly rate: ");
        hourlyRate = input.nextDouble();
        System.out.print("Enter no. of hour worked: ");
        numHours = input.nextDouble();
       
    }
    
    //method to printout the values 
    @Override
    public void printInfo(){
    	//System.out.print(c);
        super.printInfo();
        System.out.format("    %.2f |\n", (hourlyRate*numHours));
    }

}
