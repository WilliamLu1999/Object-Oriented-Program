import java.util.*;

/* Assumption: the user will always enter the correct name of the car
 * the name of the car will never appear twice
 * "Enter" will be considered as in default case.
*/
public class CarDealership {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Use the Car() constructor in Car class to construct 10 empty Cars.
		Car [] cr = new Car[10];
		for (int i=0; i<cr.length;i++){
			cr[i] =new Car();
		}

		boolean enter =true;
		do {
			System.out.println("Welcome to the Car Dealership Management System.");
			System.out.println("A: add a car to the inventory.");
			System.out.println("B: search for a car by the car's brand name.");
			System.out.println("C: delete a car by the car's brand name.");
			System.out.println("D: displays cars below a certain price.");
			System.out.println("E: edit a car.");
			System.out.println("F: sort the car and display.");
			System.out.println("G: calculate the average.");
			System.out.println("H: quit.");
			
			String option = input.nextLine();
			
			switch(option) {
			
			case("A"):
				System.out.println("Enter a car brand name to add: ");
				String bn = input.nextLine();
				System.out.println("Enter the price for the car: ");
				double pr = input.nextDouble();
				addCar(cr,bn,pr);
				break;
				
			case("B"):
				System.out.println("Enter the brand's name you want to find: ");
				String bn2 =input.nextLine();
				searchCar(cr,bn2);
				break;
				
			case("C"):
				System.out.println("Enter a car brand you want to delete: ");
				String bn3 = input.nextLine();
				deleteCar(cr,bn3);
				break;
				
			case("D"):
				System.out.println("Under what price of cars do you want to see?");
				double pr1 = input.nextDouble();
				displayCar(cr,pr1);
				
				break;
				
			case("E"):
				System.out.println("Type a car to edit the information you want.");
				String bn4 = input.nextLine();
				System.out.println("What's the new brand name?");
				String bn5 = input.nextLine();
				System.out.println("What's the new price?");
				double pr2 =input.nextDouble();
				System.out.println(editCar(cr,bn4,bn5,pr2));
				break;
				
			case("F"):
				sortCar(cr);
				break;
			
			case("G"):
				System.out.println("The average price of cars is: "+averageCar(cr));
				break;
				
			case("H"):
				System.out.println("Thank you for using until next time!");
				enter = false;
				break;
		
				
			default:
				System.out.println("Please enter a valid letter/a capital letter.");
				break;
		
			}
			
		}while (enter);
		input.close();
		
			
		
	}
	
	// method for adding a car (A)
	public static void addCar(Car[]c,String b,double p) {
		for (int i =0; i<c.length;i++) {
			if (c[i].getBrand().equals("")) {
				c[i].setBrand(b);
				c[i].setPrice(p);
				break;
			}
			
		}
		
	}
	// method for finding a car through a car's name (B)
	
	@SuppressWarnings("unused")
	public static void searchCar(Car[]c,String b) {
		for (int j= 0; j<c.length;j++) {
			if(b.equalsIgnoreCase(c[j].getBrand())) {
				c[j].printCar();
				break;
			}
			else{
			System.out.println("Invalid. Enter new name from the beginning.");
			break;
		}
		}
		}
		
	
	// method for deleting a car. (C)
	public static void deleteCar(Car[]c,String b) {
		for (int i=0;i<c.length;i++) {
			if (c[i].getBrand().equals(b)){
				c[i].setBrand("");
				c[i].setPrice(0.0);
				break;
			}
			
		}
	}
	// method for showing cars below a certain price. (D)
	public static void displayCar (Car[]c,double p) {
		
		// count the number of cars that are below a certain price
		int count = 0;
		
		for (int i=0;i<c.length;i++) {
			if (c[i].getPrice()<= p) {
				count += 1;
			}
		}
		// new array for cars under the price
		
		Car [] listC = new Car[count];
		
		for (int j = 0;j<count;j++) {
			
			for (int i=0;i<c.length;i++) {
				if (c[i].getPrice()<= p) {
					listC[j] = new Car();
					listC[j].setBrand(c[i].getBrand());
					listC[j].setPrice(c[i].getPrice());
					
					
				}
				
				
			}
			listC[j].printCar();
			
		}
		
		
		
	}
	// method for editing car's information (E) (see the assumption at the top.)
	public static Car[] editCar(Car[]c,String b, String b2, double p) {
		// find the position of this car
		int positionCar = 0;
		for (int i =0;i<c.length;i++) {
			if (b.equalsIgnoreCase(c[i].getBrand())) {
				positionCar = i;
			}
		}
		c[positionCar].setBrand(b2);
		c[positionCar].setPrice(p);
		return c;		
	}
			
		
	
	// method for sorting car according to the price from (F)
	public static void sortCar(Car[]c) {
		
		for (int i =0;i<c.length;i++) {
			for (int j =i+1;j<c.length;j++)
			if(c[i].getPrice()>c[j].getPrice()) {
				Car temp = c[i];
				c[i] = c[j];
				c[j] = temp;
			}
				
			c[i].printCar();
		}
			
		}
	// method for calculate the average price (G)
	public static double averageCar(Car[]c) {
		
		double sum = 0;
		// some car may not be initialized yet
		int numofCar =0;
		for (int i=0;i<c.length;i++) {
			if (c[i].getPrice()!=0) {
				sum += c[i].getPrice();
				numofCar+=1;
			}
			
		}
		double average = sum/numofCar;
		return average;
		
	}
	}


