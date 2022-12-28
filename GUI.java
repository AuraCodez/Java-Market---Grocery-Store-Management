import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GUI {
    public GUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Store Management Program : Created by Ryan");
        frame.setSize(1366, 768);
        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        panel.setLayout(null);

        JButton resetEverything = new JButton("Reset Button");
        resetEverything.setPreferredSize(new Dimension(150, 75));

        JButton credits = new JButton("Credits");
        credits.setPreferredSize(new Dimension( 150, 75));

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

                double price = 0;
                if(priceLabelField.getText().isEmpty()) {
                    System.out.println("Error Empty String");
                } else {
                    price = Double.parseDouble(priceLabelField.getText().trim());
                }



                String itemName = itemNameLabel.getText();

                int quantity = 0;
                if(quantityLabelField.getText().isEmpty()) {
                    System.out.println("Error Empty String");
                
                } else {
                    quantity = Integer.parseInt(quantityLabelField.getText().trim());
                }

                Item addItemDialogItem = new Item(itemName, price, quantity);
                addItemPanel.setSize(new Dimension(640, 480));
                addItemDialogItem.setSize(640, 480);

                addItemDialogItem.add(addItemPanel);
                addItemDialogItem.setVisible(true);



                


            }
        });

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

                double salary = 0.0;
                if (salaryField.getText().isEmpty()) {
                    System.out.println("Error Empty String not valid");
                } else {
                    salary = Double.parseDouble(salaryField.getText().trim());

                }

                String name = nameField.getText();
                String gender = genderField.getText();


                Employee addEmployeeDialog = new Employee(frame, name, salary, gender);
                addEmployeePanel.setSize(new Dimension(640, 480));
                addEmployeeDialog.setSize(640, 480);

                addEmployeeDialog.add(addEmployeePanel);
                addEmployeeDialog.setVisible(true);

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
