
public class Product {
	private int ID;
	private float price;
	private int quantity;
	
	public Product() {
		
	}
	public Product(int id, float price, int quantity) {
		this.ID = id;
		this.price = price;
		this.quantity = quantity;		
	}
	
	// Getters and Setters
	public int getID() {
		return ID;
	}
	public void setID(int newID) {
		ID = newID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float newPrice) {
		price = newPrice;
	}
	public int getQuant() {
		return quantity;
	}
	public void setQuant(int newQuant) {
		quantity = newQuant;
	}
	public String toString() {

		return "Product ID: "+ID+" price: "+price+" with a quantity of "+quantity;
	}
}
