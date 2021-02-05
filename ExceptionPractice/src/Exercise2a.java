
import java.util.InputMismatchException;
import java.util.Scanner;
@SuppressWarnings("unused")
public class Exercise2a {

	public static void main(String[] args) {
		Student one = new Student();
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		
		/* This part is just doing try catch block. Execute this with the setAge method with No throw statement added.
		 * in Exercise2b, you can execute Exercise2b with the setAge method that has throw statement added.
		do {
			try {
				System.out.println("Enter the age of the student: ");
				int one_age = input.nextInt();
				one.setAge(one_age);
				continueInput = true;
			}
		catch (InputMismatchException ex){
			System.out.println("Wrong input type. Not an integer.");
			continueInput = false;
		}
		
		finally {
			
				System.out.println("Exercise 5: adding a finally block is here.");
			}
		}while(continueInput);
		*/
		
		
		// Below is the nextLine() part of code for question 2a, using a try catch block. 
		// In Exercise2b.java, we use the throw. 
		// Exception type might be RuntimeException
		do {
			try {
				System.out.println("Enter the name of the student: ");
				String one_name = input.nextLine();
				one.setName(one_name);
				
				continueInput = true;
			}
			catch (RuntimeException ex2){
				
				System.out.println("Never ends. Runtime.");
				continueInput = false;
			}
			
		
		finally {
				
				System.out.println("Exercise 5: adding a finally block is here.");
			}
		}while(continueInput);
		
		
		input.close();
		
	}
	

}