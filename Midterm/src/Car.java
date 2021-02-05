
public class Car {
	private String brand;
	private double price;
	
	//constructors
	Car(){
		brand ="";
		price =0;
	}
	
	Car(String br){
		brand = br;
	}
	
	Car(double pr){
		price = pr;
	}
	
	Car(String br,double pr) {
		brand = br;
		price = pr;
	}
	
	// Getters
	public String getBrand() {
		return brand;
	}
	public double getPrice() {
		return price;
	}
	
	// Setters
	public void setBrand(String newbrand) {
		brand = newbrand;
	}
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	public void printCar() {
		System.out.println("Car brand: "+brand+" price: "+price);
	}

}
