package UI;

import BusinessLogic.Customer;
import FunctionalClasses.Database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame extends javax.swing.JFrame {

    private Database database;
    private boolean validPassword = false;

    public LoginFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.toFront();
        this.requestFocus();
        database = new Database();
    }

    private void initComponents() {

        LogoLabel = new javax.swing.JLabel();
        MottoLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        RegisterLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login to PreOrder");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("LoginFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(410, 485));
        setResizable(false);
        getContentPane().setLayout(null);

        LogoLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LogoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/PreOrder logo in center yellow.png"))); // NOI18N
        getContentPane().add(LogoLabel);
        LogoLabel.setBounds(40, 10, 340, 90);

        MottoLabel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        MottoLabel.setForeground(new java.awt.Color(102, 102, 102));
        MottoLabel.setText("Ultimately new experience of making orders");
        getContentPane().add(MottoLabel);
        MottoLabel.setBounds(90, 100, 220, 17);

        UsernameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        UsernameLabel.setText("Phone number:");
        getContentPane().add(UsernameLabel);
        UsernameLabel.setBounds(30, 160, 97, 17);

        UsernameTextField.setToolTipText("enter your phone number here");
        UsernameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        getContentPane().add(UsernameTextField);
        UsernameTextField.setBounds(140, 160, 130, 20);

        PasswordLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PasswordLabel.setText("Password:");
        getContentPane().add(PasswordLabel);
        PasswordLabel.setBounds(60, 210, 70, 20);

        getContentPane().add(PasswordField);
        PasswordField.setBounds(140, 210, 130, 20);

        RegisterLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RegisterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterLabel.setText(" Don't have an account yet?");
        getContentPane().add(RegisterLabel);
        RegisterLabel.setBounds(130, 350, 150, 20);

        loginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_login_orange.png"))); // NOI18N
        loginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginLabelPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginLabelReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLabelClicked(evt);
            }
        });
        getContentPane().add(loginLabel);
        loginLabel.setBounds(160, 270, 90, 50);

        registerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_register_orange.png"))); // NOI18N
        registerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerLabelPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                registerLabelReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelClicked(evt);

            }
        });
        getContentPane().add(registerLabel);
        registerLabel.setBounds(140, 380, 130, 50);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Background milk.png"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 420, 450);

        pack();
    }

    private void loginLabelPressed(java.awt.event.MouseEvent evt) {
        loginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_login_orange_pressed.png")));
    }

    private void loginLabelReleased(java.awt.event.MouseEvent evt) {
        loginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_login_orange.png")));
    }

    private void registerLabelPressed(java.awt.event.MouseEvent evt) {
        registerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_register_orange_pressed.png"))); // NOI18N
    }

    private void registerLabelReleased(java.awt.event.MouseEvent evt) {
        registerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_register_orange.png"))); // NOI18N
    }

    //LOGGIN IN VIA DATABASE
    private void loginLabelClicked(java.awt.event.MouseEvent evt) {

        PreparedStatement preparedStatement;
        String query = "SELECT * FROM users WHERE phonenumber=? AND password=?";
        try
        {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, UsernameTextField.getText().toString());
            preparedStatement.setString(2, PasswordField.getText().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next())
            {
                count++;
            }
            if (count == 1)
            {
                String name;
                String surname;
                int id;
                String phonenumber;
                String password;
                try
                {
                    resultSet.first();
                    name = resultSet.getString("name");
                    surname = resultSet.getString("surname");
                    id = resultSet.getInt("userid");
                    phonenumber = resultSet.getString("phonenumber");
                    password = resultSet.getString("password");
                    loginLabel.setText("Correct!!!");
                    dispose();
                    new ClientMainFrame2(new Customer(name, surname, id, phonenumber, password)).setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect username or password :(");

                if(count == 0)
                    loginLabel.setText("No such username or password!");
                else
                    loginLabel.setText("More than 1 user detected");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //REGISTERING
    private void registerLabelClicked(java.awt.event.MouseEvent evt) {
        dispose();
        java.awt.EventQueue.invokeLater(() ->
                new RegisterFrame().setVisible(true)
        );
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel MottoLabel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel RegisterLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel registerLabel;
    // End of variables declaration
}
