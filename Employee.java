import javax.swing.JDialog;
import javax.swing.JFrame;


public class Employee extends JDialog {
	private String name;
	private int employeeID;
	private static int employeeIDF = 99;
	private double salary;
	private JFrame frame;
	private String gender;

	public Employee(JFrame frame, String name, double salary, String gender) {
		this.frame = frame;
		this.name = name;
		this.salary = salary;
		this.employeeID = employeeIDF += 1;
		this.gender = gender;

	}

	public String getName() {
		return this.name;
	}

	public String getGender() {
		return this.gender;
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
		return String.format("Employee: %s, Employee ID: %s, Salary: $%.2f", this.getName(), this.getEmployeeId(),
				this.getSalary());
	}

}
