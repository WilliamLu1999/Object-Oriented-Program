import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		// Question Three Poem
		// The type of Exception could be IOException and InputMismatchException and IndexOutOfBoundsException
				
					
		System.out.println("Enter the a number from 0-99: ");
						
		try {
			int line = input.nextInt();
			input.close();
			String words = Files.readAllLines(Paths.get("A Falling Star,A Nun_s Priest Tale.txt")).get(line);
			System.out.println(words);
					
			}
		catch (InputMismatchException ex){
					
			System.out.println("Wrong.");
			
				}
		catch(IOException ex) {
			System.out.println("Wrong.");
					
				}
		catch(IndexOutOfBoundsException ex) {
			System.out.println("Wrong.");
					
				}
		finally {
			System.out.println("Exercise 5: adding a finally block is here.");
		}
				
		}

	}

