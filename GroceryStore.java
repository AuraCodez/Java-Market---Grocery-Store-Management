import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GroceryStore  {
	private ArrayList<Item> items;
	private ArrayList<Employee> employees;

	
	public GroceryStore() {
		this.items = new ArrayList<Item>();
		this.employees = new ArrayList<Employee>();
	}
	
	public void hireEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	public void addItem(Item obj) {
		this.items.add(obj);
		Collections.sort(this.items);
		
	}
	
	public int getEmployeeID(String name) {
		   for(int i = 0; i < this.employees.size(); i++) {
		      Employee e = this.employees.get(i);
		      if (e.getName().equals(name)) {
		         return e.getEmployeeId();
		      }
		   }
		   return -1; //If employee is not found
		}

	
	public ArrayList<String> getListOfItems() { //Gets the list of items that are in the store
		ArrayList<String> itemArray = new ArrayList<String>();
		for(int i = 0; i < this.items.size(); i++) {
			Item a = this.items.get(i);
			itemArray.add(a.getName());
		}
		Collections.sort(itemArray);
		return itemArray;
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
	
	
	public int searchTest(String name) {
		ArrayList<String> itemArray = this.getListOfItems();
		int low = 0;
		int high = itemArray.size() - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			String midItem = itemArray.get(mid);
			if(midItem.equals(name)) {
				return mid;
			} else if(midItem.compareTo(name) < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1; //Returning -1 if it's not found.
	}

}
