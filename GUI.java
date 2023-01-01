
//GUI Created by Ryan. L (https://github.com/AuraCodez)
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GUI {

    List<Employee> employees = new ArrayList<>();
    List<Item> items = new ArrayList<>();
    GroceryStore store = new GroceryStore(items, employees);

    public GUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Store Management Program : Created by Ryan (https://github.com/AuraCodez)");
        frame.setSize(900, 700);
        JPanel panel = new JPanel();
        int red = 173;
        int green = 216;
        int blue = 230;
        Color color = new Color(red, green, blue);
        panel.setBackground(color);

        panel.setLayout(null);

        JButton clickNext = new JButton("Next Page");
        clickNext.setBackground(Color.green);
        clickNext.setPreferredSize(new Dimension(150, 75));
        clickNext.setBounds(325, 500, 200, 50);
        clickNext.setFont(new Font(clickNext.getFont().getName(), clickNext.getFont().getStyle(), 18));
        // panel.add(clickNext);

        JFrame nextPage = new JFrame();
        nextPage.setLayout(null);
        JButton button1 = new JButton("Button 1");
        button1.setBounds(50, 50, 100, 50);
        nextPage.add(button1);

        clickNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(store.getListOfItems());
                nextPage.setLocationRelativeTo(null);
            }
        });

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

        JButton searchItemB = new JButton("Search for Item");
        searchItemB.setPreferredSize(new Dimension(150, 75));
        searchItemB.setBounds(100, 495, 200, 50);

        JButton searchEmployeeB = new JButton("Search for Employee");
        searchEmployeeB.setPreferredSize(new Dimension(150, 75));
        searchEmployeeB.setBounds(500, 495, 200, 50);

        searchEmployeeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog searchEmployeeDialog = new JDialog();
                JPanel searchEmployeePanel = new JPanel();
                searchEmployeePanel.setBackground(Color.blue);
                searchEmployeePanel.setLayout(new GridBagLayout());

                JLabel searchEmployeeName = new JLabel("Enter Employee Name: ");
                JButton submitSearch = new JButton("Search");

                JLabel isEmployeeFound = new JLabel();
                searchEmployeeName.setForeground(Color.yellow);
                searchEmployeeName.setFont(searchEmployeeName.getFont().deriveFont(24f));

                JTextField searchField = new JTextField(20);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.VERTICAL;

                gbc.gridx = 0;
                gbc.gridy = 0;
                searchEmployeePanel.add(searchEmployeeName, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                searchEmployeePanel.add(searchField, gbc);

                gbc.gridx = 2;
                gbc.gridy = 0;
                searchEmployeePanel.add(submitSearch, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                searchEmployeePanel.add(isEmployeeFound, gbc);

                isEmployeeFound.setForeground(Color.ORANGE);
                isEmployeeFound.setFont(isEmployeeFound.getFont().deriveFont(24f));

                submitSearch.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!searchField.getText().isEmpty()) {
                            if (store.searchEmployee(searchField.getText().toLowerCase().trim()) != -1) {
                                isEmployeeFound.setText("Employee is found");
                            } else {
                                isEmployeeFound.setText("Not Found");
                            }
                        }

                        if (searchField.getText().isEmpty()) {
                            isEmployeeFound.setText("Error: No input");
                        }
                    }
                });
                searchEmployeeDialog.setSize(640, 480);
                searchEmployeeDialog.setTitle("Search Employee");
                searchEmployeeDialog.setLocationRelativeTo(null);
                searchEmployeeDialog.add(searchEmployeePanel);
                searchEmployeeDialog.setVisible(true);

            }
        });

        searchItemB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog searchItemDialog = new JDialog();
                JPanel searchItemPanel = new JPanel();
                searchItemPanel.setBackground(Color.BLUE);
                searchItemPanel.setLayout(new GridBagLayout());

                JButton submitSearch = new JButton("Search");

                JLabel isFound = new JLabel();

                JLabel searchItemName = new JLabel("Enter Item Name: ");
                searchItemName.setForeground(Color.yellow);
                searchItemName.setFont(searchItemName.getFont().deriveFont(24f));

                JTextField searchItemField = new JTextField(20);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.VERTICAL;

                gbc.gridx = 0;
                gbc.gridy = 0;
                searchItemPanel.add(searchItemName, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                searchItemPanel.add(searchItemField, gbc);

                gbc.gridx = 2;
                gbc.gridy = 0;
                searchItemPanel.add(submitSearch, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                searchItemPanel.add(isFound, gbc);

                isFound.setForeground(Color.ORANGE);
                isFound.setFont(isFound.getFont().deriveFont(24f));

                submitSearch.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!searchItemField.getText().isEmpty()) {
                            if (store.searchItem(searchItemField.getText().toLowerCase().trim()) != -1) {
                                isFound.setText("In stock!");
                            } else {
                                isFound.setText("Not in stock!");
                            }
                        }

                        if (searchItemField.getText().isEmpty()) {
                            isFound.setText("Error: no input");
                        }

                    }

                });

                searchItemDialog.setSize(640, 480);
                searchItemDialog.setLocationRelativeTo(null);
                searchItemDialog.add(searchItemPanel);
                searchItemDialog.setTitle("Search Item");
                searchItemDialog.setVisible(true);
            }
        });

        addItemB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog itemDialog = new JDialog();
                JPanel addItemPanel = new JPanel();
                addItemPanel.setBackground(Color.BLUE);
                addItemPanel.setLayout(new GridBagLayout());
                itemDialog.setTitle("Add items");

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
                JButton clearButtonforItem = new JButton("Clear Text Field");

                JLabel addedButtonItem = new JLabel();
                addedButtonItem.setForeground(Color.ORANGE);
                addedButtonItem.setFont(addedButtonItem.getFont().deriveFont(24f));

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

                gbc.gridx = 0;
                gbc.gridy = 10;
                addItemPanel.add(clearButtonforItem, gbc);

                gbc.gridx = 0;
                gbc.gridy = 14;
                addItemPanel.add(addedButtonItem, gbc);

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
                        Item itemObj = new Item(name.trim(), price, quantity);
                        items.add(itemObj);

                        if (!priceLabelField.getText().isEmpty() && !quantityLabelField.getText().isEmpty()
                                && !itemNameLabelField.getText().isEmpty()) {
                            addedButtonItem.setText("Added Succesfully");
                        } else {
                            addedButtonItem.setText("Error : Try Again");
                        }

                        clearButtonforItem.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                priceLabelField.setText("");
                                quantityLabelField.setText("");
                                itemNameLabelField.setText("");
                            }
                        });

                    }
                });

                addItemPanel.setSize(new Dimension(640, 480));
                itemDialog.setSize(640, 480);
                itemDialog.add(addItemPanel);
                itemDialog.setLocationRelativeTo(null);
                itemDialog.setVisible(true);

            }
        });

        addEmployeeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog addEmployeeDialog = new JDialog();
                JPanel addEmployeePanel = new JPanel();
                addEmployeePanel.setBackground(Color.BLUE);
                addEmployeePanel.setLayout(new GridBagLayout());
                addEmployeeDialog.setTitle("Add Employees");

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

                JButton clearButtonforEmployee = new JButton("Clear Text Field");

                JLabel employeeAddedButton = new JLabel();
                employeeAddedButton.setForeground(Color.ORANGE);
                employeeAddedButton.setFont(employeeAddedButton.getFont().deriveFont(24f));

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.NONE;

                gbc.gridx = 0;
                gbc.gridy = 14;
                addEmployeePanel.add(employeeAddedButton, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                addEmployeePanel.add(nameLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                addEmployeePanel.add(nameField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                addEmployeePanel.add(genderLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                addEmployeePanel.add(genderField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                addEmployeePanel.add(salaryLabel, gbc);

                gbc.gridx = 0;
                gbc.gridy = 6;
                addEmployeePanel.add(salaryField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 7;
                addEmployeePanel.add(submitButton, gbc);

                gbc.gridx = 0;
                gbc.gridy = 10;
                addEmployeePanel.add(clearButtonforEmployee, gbc);

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

                        if (!nameField.getText().isEmpty() && !salaryField.getText().isEmpty()
                                && !genderField.getText().isEmpty()) {
                            employeeAddedButton.setText("Added Succesfully");
                        } else {
                            employeeAddedButton.setText("Error Try Again");
                        }

                        Employee obj = new Employee(name.trim(), salary, gender);
                        employees.add(obj);

                        clearButtonforEmployee.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                nameField.setText("");
                                salaryField.setText("");
                                genderField.setText("");
                            }
                        });

                    }

                });

                addEmployeePanel.setSize(new Dimension(640, 480));

                addEmployeeDialog.setSize(640, 480);
                addEmployeeDialog.add(addEmployeePanel);
                addEmployeeDialog.setLocationRelativeTo(null);
                addEmployeeDialog.setVisible(true);
                addEmployeePanel.setVisible(true);

            }
        });

        EmployeeList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog employeeListDialog = new JDialog();
                JPanel employeeListPanel = new JPanel();
                employeeListPanel.setBackground(Color.BLUE);
                employeeListPanel.setSize(new Dimension(640, 480));
                employeeListDialog.setSize(640, 480);
                employeeListDialog.setTitle("Employee Information");
                JTextArea jtextarea = new JTextArea();
                jtextarea.setEditable(false);

                String[] columnNames = { "Name", "Employee ID", "Gender", "Salary" };

                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                for (int i = 0; i < employees.size(); i++) {
                    Employee a = employees.get(i);
                    if (a.getName().isEmpty() || a.getGender().isEmpty() || a.getSalary() == 0) {
                        continue;
                    } else {
                        Object[] rows = { a.getName(), a.getEmployeeId(), a.getGender(), a.getSalary() };
                        tableModel.addRow(rows);
                    }

                }

                JTable table = new JTable(tableModel);

                JScrollPane scrollPane = new JScrollPane(table);

                employeeListPanel.add(scrollPane);
                employeeListDialog.add(employeeListPanel);
                employeeListDialog.setLocationRelativeTo(null);
                employeeListDialog.setVisible(true);

            }

        });

        itemList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog itemListDialog = new JDialog();
                JPanel itemListPanel = new JPanel();
                itemListPanel.setBackground(Color.BLUE);
                itemListPanel.setSize(640, 480);
                itemListDialog.setSize(640, 480);
                itemListDialog.setTitle("Item Inventory");
                JTextArea jtextarea = new JTextArea();
                jtextarea.setEditable(false);

                String[] columnNames = { "Name", "Price", "Stock" };
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                for (int i = 0; i < items.size(); i++) {
                    Item a = items.get(i);
                    if (a.getName().isEmpty() || a.getPrice() == 0 || a.getStock() == 0) {
                        continue;
                    } else {
                        Object[] row = { a.getName(), a.getPrice(), a.getStock() };
                        tableModel.addRow(row);
                    }

                }

                JTable table = new JTable(tableModel);
                JScrollPane scrollPane = new JScrollPane(table);
                table.setModel(tableModel);

                itemListPanel.add(scrollPane);
                itemListDialog.add(itemListPanel);
                itemListDialog.setLocationRelativeTo(null);
                itemListDialog.setVisible(true);
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

        JLabel searchItemLabel = new JLabel("Check if an item in the inventory");
        searchItemLabel.setBounds(100, 500, 350, 150);

        JLabel searchEmployeeLabel = new JLabel("Check if an employee is in the store");
        searchEmployeeLabel.setBounds(500, 500, 250, 150);

        panel.add(addEmployeeB);
        panel.add(EmployeeList);
        panel.add(employeeListLabel);
        panel.add(searchItemB);
        panel.add(searchItemLabel);
        panel.add(label);
        panel.add(addItemB);
        panel.add(itemsLabel);
        panel.add(itemList);
        panel.add(itemStock);
        panel.add(searchEmployeeB);
        panel.add(searchEmployeeLabel);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

}
