/*
 * This is an interface. Since the prompt asks us to implement a class, and an interface is a special type of class.
 * So we will implement this class in the Inventory class.
 * We call this interface, a special type of class, InventoryAb.
 */
public interface Inventory {
	//1
	public void Add(Product p);
	//2 Since an ID is unique, we can delete a product by taking the ID.
	public void Delete(int iD);
	//3
	public void DisplayAll();
	//4 
	public void Sell(int ID,int decreaseAmount);
	//5
	public void DisplayMin();
	//6
	public void WriteFile(int quant);
	//7
	public int[] MergeSort(int[]x);
	//8
	public boolean SumThree(float pr);
}
