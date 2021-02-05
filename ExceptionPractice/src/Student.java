import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Student {
	String name;
	int age;
	String motivation;
// constructor
Student(){
	
}
Student(String name, int age, String motivation){
	this.name = name;
	this.age = age;
	this.motivation = motivation;
}

public String getName() {
	return this.name;
}

public void setName(String name) { 
	
	this.name = name;
}
public int getAge() {
	return this.age;
}

//We use throw statements here. Question 2b.
// Comment out the throws if you need to check with part a in Exercise2a.
public void setAge(int age) 
	throws IllegalArgumentException{
		if(age>=0) {
			this.age = age;
		}
		else {
			throw new IllegalArgumentException("Age cannot be negative.");
		}
	}
	
public void setMotivation(String motivation) {
	this.motivation = motivation;
}
// Bonus Question
public static String getSomeMotivation() throws IOException {
	
	@SuppressWarnings("unused")
	String motivation = "";
	
		URL oracle = new URL("https://www.affirmations.dev/");
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(oracle.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            return motivation = (inputLine.substring(15,inputLine.length()-1));
        in.close();
	
	
		throw new IOException("Sorry cannot access motivation.");
	
	
}

}



