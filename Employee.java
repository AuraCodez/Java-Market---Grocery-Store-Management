import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class Employee extends JDialog {
	private String name;
	private int employeeID;
	private static int employeeIDF = 99;
	private double salary;
	private JFrame frame;
	public JLabel test;
	
	
	public Employee(JFrame frame, String name, double salary) {
	    this.frame = frame;
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
