import java.util.InputMismatchException;
import java.util.Scanner;
public class Exercise4 {
	// The kind of exception caused by dividing 0 is called ArithmeticException.
	public static void main(String[] args){
		System.out.println("Enter two numbers");
		Scanner input = new Scanner(System.in);
		
		try {
			int num1 = input.nextInt();
			int num2 = input.nextInt();
			input.close();
			int answer = division(num1,num2);
			System.out.println("The answer after division is about: "+answer);
		}
		catch (ArithmeticException ex){
			System.out.println("Cannot divide a number by 0.");
		}
		// Assume we only allow inputs to be whole numbers. No decimals. No letters.
		catch(InputMismatchException ex) {
			System.out.println("Invalid input.");
		}
		finally {
			System.out.println("Exercise 5: adding a finally block is here.");
		}
	}
	// assume we divide a by b.
	public static int division(int a, int b) {
		return a/b;
	}
	// The kind of exception caused by dividing 0 is called ArithmeticException.

}
