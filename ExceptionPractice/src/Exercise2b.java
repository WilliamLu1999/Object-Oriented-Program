import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2b {
	// Add a throw statement and add a try catch block whenever call the methods.
	// Throw statement added in the setAge method from Student class.
	// Exception could be InputMismatch and IllegalArgument.

	public static void main(String[] args) {
		Student two = new Student();
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		do {
			try {
				System.out.println("Enter the age of the student: ");
				int one_age = input.nextInt();
				two.setAge(one_age);
				continueInput = true;
			}
		catch (InputMismatchException ex){
			System.out.println("Wrong input type. Not an integer.");
			continueInput = false;
		}
		// This exception is thrown in the setAge method from Student class.
		catch(IllegalArgumentException ex) {
			System.out.print(ex);
			// still keep asking the user a positive age according to the question prompt.
		}
		finally {
			
				System.out.println("Exercise 5: adding a finally block is here.");
			}
		}while(continueInput);
input.close();
	}
	

}
