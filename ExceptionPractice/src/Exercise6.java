import java.io.IOException;

public class Exercise6 {

	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		Student three = new Student();
		try {
			System.out.println(three.getSomeMotivation());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("File not found");
		}
		finally {
			System.out.println("Exercise 5: adding a finally block is here.");
		}

	}

}
