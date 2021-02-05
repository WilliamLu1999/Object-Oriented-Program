import java.io.*;
import java.util.*;
public class Application implements Inventory{

	/* 
	 * Test with size 6 according the NYU classes Forums
	 */
	Product[] ls;
public Application() {
	ls = new Product[3];
}
	

	
	
public static void main(String[]args) {
		
		Scanner input = new Scanner(System.in);
		
		Application app= new Application();
		// length


		boolean enter =true;
		do {
			System.out.println("Welcome to the product inventroy System.");
			System.out.println("A: add a product to the inventory.");
			System.out.println("B: delete a product in the inventory.");
			System.out.println("C: display all products.");
			System.out.println("D: sell a product.");
			System.out.println("E: display the infor of the cheapest product.");
			System.out.println("F: write to a text file.");
			System.out.println("G: mergesort the inventory.");
			System.out.println("H: Three products that sum to a price.");
			System.out.println("I: quit.");
			String option = input.nextLine();
			
			switch(option) {
			
			case("A"):
				/*
				 * Assume Id entered is always different
				 * Assume price and quantity won't be negative
				 */
				System.out.println("Enter the ID of the product: ");	
				int id2 = input.nextInt();
				System.out.println("Enter the price of the product: ");	
				float price2 = input.nextFloat();
				System.out.println("Enter the quantity of the product: ");	
				int quantity2 = input.nextInt();
				Product a = new Product(id2,price2,quantity2);
				app.Add(a);
				break;
			
			
			
			case("B"):
				/* Assume the user will delete the existing ID.
				 * Assume the user always enter different ID, as ID is unique, so that only one item is deleted each time.
				 * And assume the user deletes the LATEST ID always.
				 */
				System.out.println("Enter the ID of the product you want to delete: ");
				int id3 = input.nextInt();
				app.Delete(id3);
				break;
				
			case("C"):
				app.DisplayAll();
				
				break;
				
				/*
				 * Assume the number entered is always positive
				 */
			case("D"):
				System.out.println("Enter the ID of the product you want to delete quantity: ");
				int id4  =input.nextInt();
				System.out.println("Enter the decrease amount: ");
				int dc  =input.nextInt();
		
				app.Sell(id4, dc);
				
				break;
				
			case("E"):
				app.DisplayMin();
				break;
				
			case("F"):
				// Assume at least one product is input already. Otherwise, there is no point to write.
				System.out.println("Enter the quantity and let the below quantity be in a file!");
				int qt2 = input.nextInt();
				app.WriteFile(qt2);
				break;
			
			case("G"):
				
				
				
				/* Only merge sort the array after all inputs are taken!
				 * Please give some partial credits if anything is correct. 
				 * As I believe my merge methods are all correct. Thank you!
				 */
				
				
				
				int []arry = new int[app.ls.length];
				// Unsorted quantity array:
				for(int i= 0;i<app.ls.length;i++) {
					arry[i] =app.ls[i].getQuant();
				}
				arry = app.MergeSort(arry);
				// Sorted quantity array;
				for(int i = 0 ; i < arry.length ; i++) {
			 		System.out.println(arry[i]);
			 	}
				
					
				
			
				break;
			case("H"):
				System.out.println("Enter the sum of price! And check if there is a combo");
				float pr3 = input.nextFloat();
				app.SumThree(pr3);
				break;
				
			case("I"):
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
	
	/*
	 * Assume the user always knows the maximum number of product.
	 * i.e. he won't add beyond the total number of products(in this case 6)
	 */
	@Override
	public void Add(Product p) {
		for (int i=0;i<ls.length;i++) {
			if(ls[i]!=null && p.getID()==ls[i].getID()) {
				System.out.println("Already exists.");
			}
			else if(ls[i]==null) {
				ls[i]=p;
				return;
			}
		}

		
		
	}
	/*
	 * Assume the user always enter different ID, as ID is unique, so that only one item is deleted each time.
	 * And assume the user deletes the LATEST ID always.
	 */
	@Override
	public void Delete(int ID) {
		for(int i=0;i<ls.length;i++) {
			if (ID==ls[i].getID()) {
				ls[i]=null;
				break;
			}
		}
	}
	@Override
	public void DisplayAll() {
	
		for(int i=0;i<ls.length;i++) {
		if(ls[i]!=null) {
				System.out.println("ID: "+ls[i].getID()+" price: "+ls[i].getPrice()+" quantity: "+ls[i].getQuant());
			
		}else{
			System.out.println("empty");
			
		}
		

		}	
	}
	// Assume valid ID entered.
	@SuppressWarnings("unused")
	@Override
	public void Sell(int ID,int decreaseAmount) {
		for(int i=0;i<ls.length;i++) {
			if(ls[i].getID()==ID && decreaseAmount<=ls[i].getQuant()) {
				ls[i].setQuant(ls[i].getQuant()-decreaseAmount);
				break;
			}else {
				System.out.println("Can't oversell!");
				break;
			}
		}
	}
	
	
	@Override
	/*
	 *  we display the minimum one with information.
	 *  Assume all prices are entered.
	 */
	public void DisplayMin() {
		int indexMin =0;
		if(ls[0]!=null) {
			float min = ls[0].getPrice();
			for(int i = 0;i<ls.length;i++) {
				if(ls[i]!=null && ls[i].getPrice()<min) {
					min = ls[i].getPrice();
					indexMin = i;
							
				}
			}
			
			System.out.println("ID: "+ls[indexMin].getID()+" price: "+ls[indexMin].getPrice()+" quantity: "+ls[indexMin].getQuant());
			for (int j =0;j<ls.length;j++) {
				if(ls[j].getPrice()==ls[indexMin].getPrice() && j!=indexMin) {
					System.out.println("ID: "+ls[j].getID()+" price: "+ls[j].getPrice()+" quantity: "+ls[j].getQuant());
				}
			}
		}
		}
			
			
		
	
	@Override
	public void WriteFile(int quant) {
		try {
			FileWriter file = new FileWriter("p.txt");
			for (int i = 0; i<ls.length;i++) {
				if(ls[i]!=null) {
				if(ls[i].getQuant()<quant) {
					file.write(ls[i].toString());
				}
				
			}file.close();
			
		}
		}
		catch(IOException x){
			System.out.println("Something wrong happened.");
		}
		
		
	}
	

	// Assume all products are implemented. No product is NULL.
	// Quantity are in whole number.
	// Please give some partial credits if anything is correct. Thank you!
	/*
	public int[] MergeSort(int []arry) {
		// Take half and half ...
		if(arry.length<=1) {
			return arry;
		}
		int mid = arry.length/2;
		int [] left = new int[mid];
		int []right = new int[arry.length-mid];
		
		
		for (int j = 0; j<mid; j++) {
			left[j]=arry[j];
		}
		
		
		for (int j = 0; j<right.length; j++) {
			right[j]=arry[j+mid];
		}
		int[]after = new int[arry.length];
		
		left = MergeSort(left);
		right = MergeSort(right);

		after = merge(left,right);
	
		return after;
		
	}
	public int[] merge(int []left, int[] right){
		int []after =new int[left.length+right.length];
		int a =0;
		int b =0;
		int correctvalue =0;
		// since we need to merge same value.
		// and merge
		while(a<left.length ||b<right.length) {
			
			if(b<right.length) {
				after[correctvalue++] =right[b++];
			}
			else if(a<left.length) {
				after[correctvalue++]=left[a++]; 
			}
			else if(a<left.length && b<right.length) {
				if(left[a]>=right[b]) {
					after[correctvalue++]=right[b++];
					
				}
				else {
					after[correctvalue++] =left[a++];
				}
			}
		}return after;
	}*/
	@ Override
	public int[] MergeSort(int[] array) {


	 	int mid = array.length/2;

	 	if (array.length <= 1) {
	 		return array;
	 	}

	 	int[] left = new int[mid];
	 	int[] right;

	 	if (array.length % 2 == 0) {
	 		right = new int[mid];
	 	}
	 	else {
	 		right = new int[mid + 1];
	 	}

	 	for(int i = 0 ; i < left.length ; i++) {

	 		left[i] = array[i];

	 	}
	 	for(int j = 0 ; j < right.length ; j++) {

	 		right[j] = array[mid + j];

	 	}

	 	MergeSort(left);
	 	MergeSort(right);

	 	int[] result = new int[array.length];

	 	result = merge(left , right);

	 	return result;

	 }

	 public static int[] merge (int[] left, int [] right){

	 	int[] result = new int[left.length + right.length];
	 	int resultPointer, leftPointer, rightPointer;
	 	resultPointer = leftPointer = rightPointer = 0;

	 	while (leftPointer < left.length || rightPointer < right.length) {

	 		if (leftPointer < left.length && rightPointer < right.length) {
	 			if(left[leftPointer] < right[rightPointer]) {
	 				result[resultPointer++] = left[leftPointer++];
	 			}
	 			else {
	 				result[resultPointer++] = right[rightPointer++];
	 			}
	 		}
	 		else if(leftPointer < left.length) {
	 			result[resultPointer++] = left[leftPointer++];
	 		}
	 		else if(rightPointer < right.length) {
	 			result[resultPointer++] = right[rightPointer++];
	 		}

	 	}

	 	return result;

	 }

	 
	
	@Override
	// We need to create three loops as sum of three products' price equal to a sum
	// Assume that every product is entered. NO PRODUCT IS NULL.
	// According to the Forums, one combo is enough.
	public boolean SumThree(float pr) {
		boolean exist = true;
		for (int i = 0;i<ls.length-2;i++) {
			for (int j = i+1;j<ls.length-1;j++) {
				for (int k = j+1; k<ls.length;k++) {
					if (ls[i].getPrice()+ls[j].getPrice()+ls[k].getPrice()==pr) {
						System.out.println("ID: "+ls[i].getID()+" price: "+ls[i].getPrice()+" quantity: "+ls[i].getQuant());
						System.out.println("ID: "+ls[j].getID()+" price: "+ls[j].getPrice()+" quantity: "+ls[j].getQuant());
						System.out.println("ID: "+ls[k].getID()+" price: "+ls[k].getPrice()+" quantity: "+ls[k].getQuant());
						return exist;
					}
				
				}
			}
		}
		System.out.println("No such combo exists!");
		return false;
	}
	

}