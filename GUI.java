import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GUI {

    List<Employee> employees = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    public GUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Store Management Program : Created by Ryan");
        frame.setSize(1366, 768);
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.setLayout(null);

        JButton resetEverything = new JButton("Reset Button"); // Work on this
        resetEverything.setPreferredSize(new Dimension(150, 75));

        JButton credits = new JButton("Credits"); // Work on this
        credits.setPreferredSize(new Dimension(150, 75));

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

        JDialog itemDialog = new JDialog();

        addItemB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel addItemPanel = new JPanel();
                addItemPanel.setBackground(Color.BLUE);
                addItemPanel.setLayout(new GridBagLayout());

                JLabel itemNameLabel = new JLabel("Enter Item Name: ");
                itemNameLabel.setFont(itemNameLabel.getFont().deriveFont(24f));
                itemNameLabel.setForeground(Color.yellow);
                JTextField itemNameLabelField = new JTextField(20);

                JLabel priceLabel = new JLabel("Enter Price: ");
                priceLabel.setFont(priceLabel.getFont().deriveFont(24f));
                priceLabel.setForeground(Color.yellow);
                JTextField priceLabelField = new JTextField(20);

                JLabel quantityLabel = new JLabel("Enter Quantity: ");
                quantityLabel.setFont(quantityLabel.getFont().deriveFont(24f));
                quantityLabel.setForeground(Color.yellow);
                JTextField quantityLabelField = new JTextField(20);

                JButton submitButton = new JButton("Submit");

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.VERTICAL;

                gbc.gridx = 0;
                gbc.gridy = 0;

                addItemPanel.add(itemNameLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                addItemPanel.add(itemNameLabelField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                addItemPanel.add(priceLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                addItemPanel.add(priceLabelField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                addItemPanel.add(quantityLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                addItemPanel.add(quantityLabelField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 8;
                addItemPanel.add(submitButton, gbc);

                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        double price = 0;
                        if (priceLabelField.getText().isEmpty()) {
                            System.out.println("Error Empty String");
                        } else {
                            price = Double.parseDouble(priceLabelField.getText().trim());
                        }

                        int quantity = 0;
                        if (quantityLabelField.getText().isEmpty()) {
                            System.out.println("Error Empty String");

                        } else {
                            quantity = Integer.parseInt(quantityLabelField.getText().trim());
                        }

                        String name = itemNameLabelField.getText();
                        Item addItemDialogItem = new Item(name, price, quantity);
                        items.add(addItemDialogItem);

                    }
                });

                addItemPanel.setSize(new Dimension(640, 480));
                itemDialog.setSize(640, 480);
                itemDialog.add(addItemPanel);
                itemDialog.setVisible(true);

            }
        });

        itemList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < items.size(); i++) {
                    Item a = items.get(i);
                    System.out.println(a.toString());
                }
            }
        });

        JDialog addEmployeeDialog = new JDialog();

        addEmployeeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel addEmployeePanel = new JPanel();
                addEmployeePanel.setBackground(Color.BLUE);
                addEmployeePanel.setLayout(new GridBagLayout());

                JLabel nameLabel = new JLabel("Enter name: ");
                nameLabel.setFont(nameLabel.getFont().deriveFont(24f));
                nameLabel.setForeground(Color.yellow);
                JTextField nameField = new JTextField(20);
                JLabel salaryLabel = new JLabel("Enter salary: ");
                salaryLabel.setForeground(Color.yellow);
                salaryLabel.setFont(salaryLabel.getFont().deriveFont(24f));
                JTextField salaryField = new JTextField(20);
                JLabel genderLabel = new JLabel("Gender :");
                JButton submitButton = new JButton("Submit");
                genderLabel.setForeground(Color.yellow);
                genderLabel.setFont(salaryLabel.getFont().deriveFont(24f));
                JTextField genderField = new JTextField(20);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.VERTICAL;

                gbc.gridx = 0;
                gbc.gridy = 0;

                addEmployeePanel.add(nameLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                addEmployeePanel.add(nameField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                addEmployeePanel.add(genderLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                addEmployeePanel.add(genderField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                addEmployeePanel.add(salaryLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                addEmployeePanel.add(salaryField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 8;
                addEmployeePanel.add(submitButton, gbc);

                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String name = nameField.getText();
                        String gender = genderField.getText();

                        double salary = 0.0;
                        if (salaryField.getText().isEmpty()) {
                            System.out.println("Error Empty String not valid");
                        } else {
                            salary = Double.parseDouble(salaryField.getText().trim());

                        }

                        Employee obj = new Employee(name, salary, gender);
                        employees.add(obj);

                    }

                });

                addEmployeePanel.setSize(new Dimension(640, 480));

                addEmployeeDialog.setSize(640, 480);
                addEmployeeDialog.add(addEmployeePanel);
                addEmployeeDialog.setVisible(true);
                addEmployeePanel.setVisible(true);

            }
        });

        EmployeeList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Employee employee : employees) {
                    System.out.println(employee.toString());
                }
            }
        });

        JLabel itemsLabel = new JLabel("Add new items to store by clicking the button");
        itemsLabel.setBounds(100, 300, 350, 150);

        JLabel itemStock = new JLabel("Click to see current item inventory");
        itemStock.setBounds(500, 300, 350, 150);

        JLabel employeeListLabel = new JLabel("Click to see employee information");
        employeeListLabel.setBounds(500, 100, 350, 150);

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
