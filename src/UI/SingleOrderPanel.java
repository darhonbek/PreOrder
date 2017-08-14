package UI;

import BusinessLogic.Food;
import FunctionalClasses.ImageScale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SingleOrderPanel extends javax.swing.JPanel {

    public SingleOrderPanel(Food food)
    {
        this.food = food;
        initComponents();
    }

    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        foodImageLabel = new javax.swing.JLabel();
        cancelLabel = new javax.swing.JLabel();

        setLayout(new GridLayout(1, 3));

        foodImageLabel.setSize(100, 80);
        foodImageLabel.setBorder(new EmptyBorder(3, 3, 0, 8));
        foodImageLabel.setIcon(ImageScale.getScaledImage(food.getImage(), foodImageLabel.getWidth(), foodImageLabel.getHeight()));

        //DARKHONBEK
        //Setting fake image for test
        //foodImageLabel.setIcon(ImageScale.getScaledImage(new ImageIcon(getClass().getResource("/Assets/Food icon.png")), foodImageLabel.getWidth(), foodImageLabel.getHeight()));

        add(foodImageLabel);

        nameLabel.setSize(150, 25);
        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        nameLabel.setText(food.getName());
        nameLabel.setBorder(new EmptyBorder(0, 0, 0, 8));
        add(nameLabel);


        cancelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelLabel.setSize(50, 40);
        cancelLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
        cancelLabel.setIcon(new ImageIcon(getClass().getResource("/Assets/button_x_released.png")));
        cancelLabel.setToolTipText("Remove food");
        cancelLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(cancelLabel);
        cancelLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelLabelClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelLabelPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelLabelReleased(evt);
            }
        });

        setPreferredSize(new Dimension(350, 80));
        setMaximumSize(new Dimension(350, 80));
    }

    private void cancelLabelClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        ClientMainFrame2 frame = (ClientMainFrame2)SwingUtilities.getRoot(this);
        frame.getOrder().removeFood( this.food );
        this.setVisible(false);
        frame.initOrdersPanel();
    }

    private void cancelLabelReleased(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        cancelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_x_released.png")));
    }

    private void cancelLabelPressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        cancelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_x_pressed.png")));
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new javax.swing.ImageIcon(getClass().getResource("/Assets/SingleOrder background.png")).getImage(), 0, 0, null);
    }

    private Food food;
    private javax.swing.JLabel cancelLabel;
    private javax.swing.JLabel foodImageLabel;
    private javax.swing.JLabel nameLabel;
}
