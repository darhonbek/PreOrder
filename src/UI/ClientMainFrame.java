package UI;

import BusinessLogic.*;
import FunctionalClasses.Database;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClientMainFrame extends javax.swing.JFrame {

    private final static int COLUMN = 3;
    private GridBagConstraints c;

    public ClientMainFrame(Customer customer) {
        super("PreOrder");
        db = new Database();
        this.customer = customer;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);

        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        categoriesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        foodsPanel = new javax.swing.JPanel();
        foodsScroller = new javax.swing.JScrollPane(foodsPanel);
        foodsScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        orderPanel = new javax.swing.JPanel();

        initFoodsPanel("Dishes");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1020, 610));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Welcome");

        jLabel2.setText(this.customer.getName() + " " + this.customer.getSurname());

        javax.swing.GroupLayout categoriesPanelLayout = new javax.swing.GroupLayout(categoriesPanel);
        categoriesPanel.setLayout(categoriesPanelLayout);
        categoriesPanelLayout.setHorizontalGroup(
                categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(categoriesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addContainerGap(133, Short.MAX_VALUE))
        );
        categoriesPanelLayout.setVerticalGroup(
                categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(categoriesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        foodsScroller.setViewportView(foodsPanel);

        //@DARKHONBEK
        //speed of the scroller
        foodsScroller.getVerticalScrollBar().setUnitIncrement(10);

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
                orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 297, Short.MAX_VALUE)
        );
        orderPanelLayout.setVerticalGroup(
                orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(categoriesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(foodsScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(orderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(foodsScroller, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addComponent(categoriesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    public void initFoodsPanel(String category) {
        foodsPanel.removeAll();

        ArrayList<Food> foods = db.getAllFood();

        foodsPanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 1);

        //DARKHONBEK
        //Adding through database
        /*
        for (int i = 0; i < foods.size(); i++) {
            //if( category.equals(foods.get(i).getCategory()) ){
            System.out.println("food #" + i +" added");
            c.gridx = i % COLUMN;
            c.gridy = i / COLUMN;
            foodsPanel.add(new SingleFoodPanel(foods.get(i)), c);
            //}
        }
        */

        //Adding fake food
        //TO BE USED WITHOUT DATABASE
        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/Assets/Food icon.png"));
        Food fakeFood = new Food(1, "Burger", "Fast food", 5500, icon);
        for (int i = 0; i < 16; i++) {
            System.out.println("food #" + i +" added");
            c.gridx = i % COLUMN;
            c.gridy = i / COLUMN;
            foodsPanel.add(new SingleFoodPanel(fakeFood), c);
        }

        foodsPanel.revalidate();
    }

    private Database db;
    private final Customer customer;
    // Variables declaration - do not modify
    private javax.swing.JPanel categoriesPanel;
    private javax.swing.JScrollPane foodsScroller;
    private javax.swing.JPanel foodsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel orderPanel;
    // End of variables declaration
}