import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GroceryStore implements Comparable<Item>  {
	private ArrayList<Item> items;
	
	//public static void main(String [] args) {
		//GroceryStore store = new GroceryStore();
		//store.addItem(new Item("Grape", 4, 10));
		//store.addItem(new Item("Orange", 5, 5));
		//store.addItem(new Item("Pear", 5, 5));
		//store.addItem(new Item("Apple", 4, 10));
		//store.displayItems();
	//}
	
	public GroceryStore() {
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item obj) {
		this.items.add(obj);
		Collections.sort(this.items);
		
	}
	
	public String getName() { //Get name of Item
		String name = "";
	     for(int i = 0; i < this.items.size(); i++) {
	    	 Item a = this.items.get(i);
	    	 name += a.getName();
	     }
	     return name;
	     
	}
	
	public void setNewStock(String name, int newStock) {
		for(int i = 0; i < this.items.size(); i++) {
			Item a = this.items.get(i);
			if(a.getName().equals(name)) {
				a.setStock(newStock);
				break;
			}
		}
	}
	
	public double getTotalPriceOfGoods() { //This methods get the total price of the items
		double price = 0;
		for(int i = 0; i < this.items.size(); i++) {
			Item a = this.items.get(i);
			price += a.getTotalPrice();
		}
		return price;
		
	}
	
	public void removeItem(String item) {
		for(int i = 0; i < this.items.size(); i++) {
			Item a = this.items.get(i);
			if(a.getName().equals(item)) {
				this.items.remove(i);
				i--; //Decrement value i after removing an element.
			}
		}
		
	}
	
	public void increaseStock(String name, int quantity) {
		for(int i = 0; i < this.items.size(); i++) {
			Item a = this.items.get(i);
			if(a.getName().equals(name)) {
			   if(quantity > 0) {
				   a.increaseStock(quantity);
				   break;
			   }
			}
		}
	}
	
	public void decreaseStock(String name, int quantity) {
		for(int i = 0; i < this.items.size(); i++) {
			Item a = this.items.get(i);
			if(a.getName().equals(name)) {
				if(quantity != 0) {
					a.decreaseStock(quantity);
					break;
				}
			}
		}
	}
	
	public void displayItems() { 
		for(int i = 0; i < this.items.size(); i++) {
			Item a = this.items.get(i);
			System.out.println("Item: " + a.getName() + "  Price: " + a.getPrice() + " Current Stock: "+ a.getStock());
		}
	}
	


	public int search(String name) {
		int low = 0;
		int high = this.items.size() - 1;
		while(low <= high) {
			int mid = (low + high)/ 2;
			Item midItem = this.items.get(mid);
			if(name.equals(midItem.getName())) {
				return mid;
			} else if(name.compareTo(midItem.getName()) < 0) {
				low = mid + 1;
				
			} else if(name.compareTo(midItem.getName()) > 0) {
				high = mid - 1;
			}
			
		}
		return -1; //Item is not found in items
		
	}

	@Override
	public int compareTo(Item o) {
		return this.getName().compareTo(o.getName());
	}

}
