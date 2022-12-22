
public class Employee {
	private String name;
	private int employeeID;
	private static int employeeIDF = 99;
	private double salary;
	
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		this.employeeID = employeeIDF += 1;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public int getEmployeeId() {
		return this.employeeID;
	}
	
	public void raiseSalary(double amount) {
		this.salary += amount;
	}
	
	public void decreaseSalary(double amount) {
		this.salary -= amount;
	}
	
	@Override
	public String toString() {
	    return String.format("Employee: %s, Employee ID: %s, Salary: $%.2f", this.getName(), this.getEmployeeId(), this.getSalary());
	}

}
