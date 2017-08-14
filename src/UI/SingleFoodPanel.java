/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BusinessLogic.Food;
import FunctionalClasses.ImageScale;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author darho_000
 */
public class SingleFoodPanel extends javax.swing.JPanel {

    /**
     * Creates new form FoodPanel
     */
    public SingleFoodPanel(Food food) {
        this.food = food;
        initComponents();
        amountSlider.addChangeListener(
                e -> amountLabel.setText( Integer.toString(amountSlider.getValue()) )
        );
    }

    private void initComponents() {

        foodImageLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        foodInfoPanel = new javax.swing.JPanel();
        addLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        amountSlider = new javax.swing.JSlider();
        priceLabel = new javax.swing.JLabel();
        priceLabelNonfunctional = new javax.swing.JLabel();
        foodNameLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(200, 261));
        setLayout(null);



        add(foodImageLabel);
        foodImageLabel.setBounds(0, 0, 200, 150);


        //DARKHONBEK
        //resizing image
        foodImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(food.getImage()!=null){
            foodImageLabel.setIcon( ImageScale.getScaledImage(food.getImage(), foodImageLabel.getWidth(), foodImageLabel.getHeight() ) );
        }
        else
            foodImageLabel.setIcon(new ImageIcon(getClass().getResource("/Assets/Food icon.png")) );

        add(jSeparator1);
        jSeparator1.setBounds(0, 150, 200, 10);

        foodInfoPanel.setOpaque(false);

        addLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_add_released.png"))); // NOI18N
        addLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLabelClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addLabelPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addLabelReleased(evt);
            }
        });

        amountLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountLabel.setText("1");

        amountSlider.setMaximum(10);
        amountSlider.setMinimum(1);
        amountSlider.setValue(1);
        amountSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        amountSlider.setPreferredSize(new java.awt.Dimension(200, 25));

        priceLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        priceLabel.setText( Double.toString(food.getPrice()) );

        priceLabelNonfunctional.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        priceLabelNonfunctional.setText("Price:");

        foodNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        foodNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodNameLabel.setText(food.getName());
        foodNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout foodInfoPanelLayout = new javax.swing.GroupLayout(foodInfoPanel);
        foodInfoPanel.setLayout(foodInfoPanelLayout);
        foodInfoPanelLayout.setHorizontalGroup(
                foodInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodInfoPanelLayout.createSequentialGroup()
                                .addGroup(foodInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(foodInfoPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                        .addGroup(foodInfoPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(amountSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)))
                                .addComponent(addLabel)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodInfoPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(priceLabelNonfunctional)
                                .addGap(18, 18, 18)
                                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                        .addGroup(foodInfoPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(foodNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        foodInfoPanelLayout.setVerticalGroup(
                foodInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodInfoPanelLayout.createSequentialGroup()
                                .addComponent(foodNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(foodInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(priceLabelNonfunctional)
                                        .addComponent(priceLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(foodInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(foodInfoPanelLayout.createSequentialGroup()
                                                .addComponent(amountSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(addLabel))
                                .addContainerGap())
        );

        add(foodInfoPanel);
        foodInfoPanel.setBounds(0, 156, 200, 105);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Single Food background.png"))); // NOI18N
        add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 200, 260);
    }// </editor-fold>

    private void addLabelClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        ClientMainFrame2 frame = (ClientMainFrame2)SwingUtilities.getRoot(this);
        for (int i = 0; i < amountSlider.getValue(); i++) {
            frame.getOrder().addFood( this.food );
        }
        frame.initOrdersPanel();
    }

    private void addLabelReleased(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        addLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_add_released.png")));
    }

    private void addLabelPressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        addLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_add_pressed.png")));
    }

    // Variables declaration - do not modify
    private Food food;
    private javax.swing.JLabel addLabel;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JSlider amountSlider;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel foodImageLabel;
    private javax.swing.JPanel foodInfoPanel;
    private javax.swing.JLabel foodNameLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceLabelNonfunctional;
    // End of variables declaration
}
