package UI;

import BusinessLogic.Customer;
import FunctionalClasses.Database;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author darho_000
 */
public class RegisterFrame extends javax.swing.JFrame {

    private Database database;
    private boolean validPassword = false;

    public RegisterFrame() {
        super("Account registration");
        initComponents();
        this.requestFocus();
        this.toFront();
        this.setSize(490, 430);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        database = new Database();
    }

    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        welcomeMessageLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        repeatPasswordLabel = new javax.swing.JLabel();
        passwordField1 = new javax.swing.JPasswordField();
        registerButtonLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        welcomeLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 111, 0));
        welcomeLabel.setText("Welcome to PreOrder!");
        getContentPane().add(welcomeLabel);
        welcomeLabel.setBounds(150, 20, 220, 20);

        welcomeMessageLabel.setForeground(new java.awt.Color(51, 51, 51));
        welcomeMessageLabel.setText("Please fill all the blanks to get unlimited free access to the best food order service");
        getContentPane().add(welcomeMessageLabel);
        welcomeMessageLabel.setBounds(49, 59, 391, 14);

        nameLabel.setForeground(new java.awt.Color(51, 51, 51));
        nameLabel.setText("Name:");
        getContentPane().add(nameLabel);
        nameLabel.setBounds(91, 113, 31, 14);
        getContentPane().add(nameTextField);
        nameTextField.setBounds(173, 110, 160, 20);

        surnameLabel.setForeground(new java.awt.Color(51, 51, 51));
        surnameLabel.setText("Surname:");
        getContentPane().add(surnameLabel);
        surnameLabel.setBounds(76, 151, 46, 14);
        getContentPane().add(surnameTextField);
        surnameTextField.setBounds(173, 148, 160, 20);

        phoneLabel.setForeground(new java.awt.Color(51, 51, 51));
        phoneLabel.setText("Phone number:");
        getContentPane().add(phoneLabel);
        phoneLabel.setBounds(49, 189, 73, 14);
        getContentPane().add(phoneTextField);
        phoneTextField.setBounds(173, 186, 160, 20);

        passwordLabel.setForeground(new java.awt.Color(51, 51, 51));
        passwordLabel.setText("Create a password:");
        getContentPane().add(passwordLabel);
        passwordLabel.setBounds(27, 227, 95, 14);
        getContentPane().add(passwordField);
        passwordField.setBounds(173, 224, 160, 20);

        repeatPasswordLabel.setForeground(new java.awt.Color(51, 51, 51));
        repeatPasswordLabel.setText("Repeat a password:");
        getContentPane().add(repeatPasswordLabel);
        repeatPasswordLabel.setBounds(25, 268, 97, 14);
        getContentPane().add(passwordField1);
        passwordField1.setBounds(173, 262, 160, 20);
        
        registerButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_register_orange.png"))); // NOI18N
        registerButtonLabel.setToolTipText("Register and start using PreOrder!");
        registerButtonLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(registerButtonLabel);
        registerButtonLabel.setBounds(187, 323, 127, 44);
        registerButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerButtonLabelPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                registerButtonLabelReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonLabelClicked(evt);

            }
        });

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/RegisterFrameBackground.png"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 490, 400);

        pack();
    }

    private void registerButtonLabelClicked(MouseEvent evt) {
        PreparedStatement preparedStatement, preparedStatementInsert;
        String query = "SELECT * FROM users WHERE phonenumber=?";
        String queryInsert;
        ResultSet resultSet;

        String name;
        String surname;
        String phoneNumber;
        String password;
        int id;

        name = nameTextField.getText();
        surname = surnameTextField.getText();
        phoneNumber = phoneTextField.getText();
        password = passwordField.getText();

        boolean validPhoneNumber = true;
        if(phoneNumber.length() == 13 && phoneNumber.charAt(0) == '+') {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9') {
                    validPhoneNumber = false;
                    break;
                }
            }
        }
        else
            validPhoneNumber = false;

        validPassword = validPhoneNumber && (passwordField.getText().equals(passwordField1.getText()) && passwordField.getText().length()!=0);

        if (validPassword && !nameTextField.getText().isEmpty() && !surnameTextField.getText().isEmpty() && !phoneTextField.getText().isEmpty())
        {
            try
            {
                preparedStatement = database.getConnection().prepareStatement(query);
                preparedStatement.setString(1,phoneTextField.getText().toString());
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next())
                {
                    queryInsert = "INSERT INTO users(name,surname,phonenumber,password) VALUES(?,?,?,?)";
                    preparedStatementInsert = database.getConnection().prepareStatement(queryInsert);

                    preparedStatementInsert.setString(1,name);
                    preparedStatementInsert.setString(2,surname);
                    preparedStatementInsert.setString(3,phoneNumber);
                    preparedStatementInsert.setString(4,password);
                    preparedStatementInsert.execute();

                    preparedStatement = database.getConnection().prepareStatement(query);
                    preparedStatement.setString(1,phoneTextField.getText().toString());
                    resultSet = preparedStatement.executeQuery();
                    resultSet.next();

                    id = resultSet.getInt("userid");

                    JOptionPane.showMessageDialog(null, "Congratulations, registration completed successfully!\nYour id number is " + Integer.toString(id), "Registration completed", JOptionPane.INFORMATION_MESSAGE);

                    Customer customer = new Customer(name, surname, id, phoneNumber, password);
                    dispose();

                    new ClientMainFrame2(customer).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This phone number already exists!", "Registration error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please, fill all the blanks correctly!", "Registration error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void registerButtonLabelReleased(MouseEvent evt) {
        registerButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_register_orange.png"))); // NOI18N
    }

    private void registerButtonLabelPressed(MouseEvent evt) {
        registerButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_register_orange_pressed.png"))); // NOI18N
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel registerButtonLabel;
    private javax.swing.JLabel repeatPasswordLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel welcomeMessageLabel;
    // End of variables declaration
}
