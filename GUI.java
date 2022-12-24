import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GUI {
    public GUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Store Management Program");
        frame.setSize(800,500);
        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        panel.setLayout(null);
        
        JButton resetEverything = new JButton("Reset Button");
        resetEverything.setPreferredSize(new Dimension(150, 75));

        JButton addEmployeeB = new JButton("New Employee");
        addEmployeeB.setPreferredSize(new Dimension(150, 75));
        addEmployeeB.setBounds(100, 100, 200, 50);
        
        JButton EmployeeList = new JButton("Employee List");
        EmployeeList.setPreferredSize(new Dimension(150, 75));
        EmployeeList.setBounds(500, 100, 200, 50);
        
        JButton addItemB = new JButton("New Item");
        addItemB.setPreferredSize(new Dimension(150, 75));
        addItemB.setBounds(100, 300, 200, 50);
        
        JButton itemList = new JButton("Item List");
        itemList.setPreferredSize(new Dimension(150, 75));
        itemList.setBounds(500, 300, 200, 50);
      
        
        addEmployeeB.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JPanel addEmployeePanel = new JPanel();
        		addEmployeePanel.setBackground(Color.BLUE);
        		JLabel nameLabel = new JLabel("Enter name: ");
        		nameLabel.setForeground(Color.yellow);
        		JTextField nameField = new JTextField(20);
        		JLabel salaryLabel = new JLabel("Enter salary: ");
        		salaryLabel.setForeground(Color.yellow);
        		JTextField salaryField = new JTextField(20);
        		String name = nameField.getText();
        		double salary = 0.0;
        		if(salaryField.getText().isEmpty()) {
        			System.out.println("Error Empty String not valid");
        		} else {
            		salary = Double.parseDouble(salaryField.getText().trim());

        		}
        		addEmployeePanel.add(nameLabel);
        		addEmployeePanel.add(salaryLabel);
        		addEmployeePanel.add(nameField);
        		addEmployeePanel.add(salaryField);
        		Employee addEmployeeDialog = new Employee(frame, name, salary);
        		addEmployeeDialog.add(addEmployeePanel);
        		addEmployeeDialog.setPreferredSize(new Dimension(600, 400));
        		addEmployeeDialog.setVisible(true);

            }
        });
        
        
        
        JLabel itemsLabel = new JLabel("Add new items to store by clicking the button");
        itemsLabel.setBounds(100,300,350,150);
        
        JLabel itemStock = new JLabel("Click to see current item inventory");
        itemStock.setBounds(500,300,350,150);
        
        
        JLabel employeeListLabel = new JLabel("Click to see employee information");
        employeeListLabel.setBounds(500,100,350,150);

        JLabel label = new JLabel("Add new employees by clicking the button");
        label.setBounds(100, 100, 350, 150); 
        
        panel.add(addEmployeeB);
        panel.add(EmployeeList);
        panel.add(employeeListLabel);
        panel.add(label);
        panel.add(addItemB);
        panel.add(itemsLabel);
        panel.add(itemList);
        panel.add(itemStock);
        

        frame.add(panel);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new GUI();
    }
    
    
}
