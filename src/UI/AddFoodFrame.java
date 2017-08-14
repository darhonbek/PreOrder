package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import BusinessLogic.Category;
import FunctionalClasses.Database;
import FunctionalClasses.ImageScale;

public class AddFoodFrame extends javax.swing.JFrame {

    private Database database;
    private String[] categories;
    public AddFoodFrame(ArrayList<String> c) {
        file = null;
        database = new Database();
        categories = c.toArray(new String[c.size()]);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
    }

    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jFileChooser1 = new javax.swing.JFileChooser();
        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        categoryLabel = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        priceLabel = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        chooseImageButton = new javax.swing.JButton();
        imageNameLabel = new javax.swing.JLabel();
        addFoodButton = new javax.swing.JButton();

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif", "bmp");
        fileChooser.addChoosableFileFilter(filter);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(categories));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleLabel.setText("Add new product");

        nameLabel.setText("Name:");

        categoryLabel.setText("Category:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(categories));

        priceLabel.setText("Price:");

        chooseImageButton.setText("Choose food image");
        chooseImageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageButtonActionPerformed();
            }
        });

        imageNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/attach_file2.gif")));
        imageNameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imageNameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseImageButtonActionPerformed();
            }
        });

        addFoodButton.setText("Add food!");
        addFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFoodButtonActionPerformed(evt);
            }
        });


        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                database.closeConnection();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(chooseImageButton)
                                .addGap(188, 188, 188))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addFoodButton)
                                .addGap(213, 213, 213))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(imageNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(categoryLabel)
                                                                        .addComponent(nameLabel)
                                                                        .addComponent(priceLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(categoryLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(priceLabel)
                                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(chooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imageNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(addFoodButton)
                                .addContainerGap())
        );

        pack();
    }

    private void addFoodButtonActionPerformed(ActionEvent evt) {
        try{
            FileInputStream fin = new FileInputStream(file);
            PreparedStatement pre =
                    database.getConnection().prepareStatement("insert into foods (name, price, category," +
                            "imagelocation, image, isAvailable) values(?,?,?,?,?,?)");
            pre.setString(1, nameTextField.getText());
            pre.setDouble(2, Double.parseDouble(priceTextField.getText()));
            pre.setString(3, categoryComboBox.getSelectedItem().toString());
            pre.setString(4, file.getName());
            pre.setBinaryStream(5, (InputStream)fin,(int)file.length());
            pre.setBoolean(6, true);
            pre.executeUpdate();
            System.out.println("Successfully inserted the file into the database!");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    //choose file button pressed
    private void chooseImageButtonActionPerformed() {
        fileChooser.setVisible(true);
        int returnVal = fileChooser.showOpenDialog(AddFoodFrame.this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            Image image;
            file = fileChooser.getSelectedFile();
            try{
                //read image
                image = ImageIO.read(file);
                imageNameLabel.setIcon(ImageScale.getScaledImage(new ImageIcon(image), imageNameLabel.getWidth(), imageNameLabel.getHeight()) );
                imageNameLabel.setText("");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify
    private File file;
    private javax.swing.JButton addFoodButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton chooseImageButton;
    private javax.swing.JLabel imageNameLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration
}