package UI;

import BusinessLogic.*;
import FunctionalClasses.Database;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author darho_000
 */
public class ClientMainFrame2 extends javax.swing.JFrame {

    private final static int COLUMN = 3;
    private GridBagConstraints c;
    private final static int COLUMN_ORDER = 1;//also used for categories
    private GridBagConstraints c_order;
    private GridBagConstraints c_categories;

    private Order order;
    private Database db;
    private final Customer customer;
    private ArrayList<Food> foods;
    private ArrayList<Category> categories;


    public ClientMainFrame2(Customer customer) {

        //FAKE ORDER ID - TAKE ONE FROM DATABASE
        int orderID = 001;

        this.order = new Order(orderID, customer.getID());
        this.customer = customer;

        this.foods = db.getAllFood();
        this.categories = db.getCategories();


        initComponents();

        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


    }
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        leftPanel = new javax.swing.JPanel();
        welcomePanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        categoriesPanel = new javax.swing.JPanel();

        titlePanel = new javax.swing.JPanel();
        titleBackground = new javax.swing.JLabel();

        rightPanel = new javax.swing.JPanel();
        orderPanel = new javax.swing.JPanel();
        yourOrderLabel = new javax.swing.JLabel();

        //orders scroller
        ordersPanel = new javax.swing.JPanel();
        ordersScroller = new javax.swing.JScrollPane(ordersPanel);
        ordersScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ordersScroller.getVerticalScrollBar().setUnitIncrement(10);

        makeOrderPanel = new javax.swing.JPanel();
        preorderButtonLabel = new javax.swing.JLabel();
        itemsLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();

        itemsNoLabel = new javax.swing.JLabel();
        priceNoLabel = new javax.swing.JLabel();


        //foods scroller
        foodsPanel = new javax.swing.JPanel();
        foodsPanel.setBackground(new Color(255, 255, 255));
        foodsScroller = new javax.swing.JScrollPane(foodsPanel);
        foodsScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        foodsScroller.getVerticalScrollBar().setUnitIncrement(10);


        //DARKHONBEK
        //CATEGORIES HERE
        initFoodsPanel("All");

        //LAYERED PANE (WE DON'T NEED THIS)
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
        setTitle("PreOrder");
        setBackground(new java.awt.Color(255, 255, 255));

        //LEFT PANEL
        leftPanel.setBackground(new java.awt.Color(255, 255, 204));

        welcomePanel.setBackground(new java.awt.Color(255, 255, 204));

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(250, 104, 0));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome!");


        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(102, 102, 102));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText(this.customer.getName() + " " + this.customer.getSurname());
        //nameLabel.setText("Your name + your surname");

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePanelLayout.createSequentialGroup()
                                                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePanelLayout.createSequentialGroup()
                                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23))))
        );
        welcomePanelLayout.setVerticalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addContainerGap(45, Short.MAX_VALUE)
                                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        categoriesPanel.setBackground(new java.awt.Color(255, 255, 204));

        categoriesPanel.setLayout(new GridBagLayout());
        c_categories = new GridBagConstraints();
        c_categories.insets = new Insets(0, 0, 5, 0);
        initCategoriesPanel();

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(categoriesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leftPanelLayout.createSequentialGroup()
                                .addComponent(welcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoriesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        //TITLE PANEL
        titlePanel.setBackground(new java.awt.Color(255, 255, 204));

        titleBackground.setBackground(new java.awt.Color(255, 255, 204));
        titleBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/PreOrder midsize with motto.png"))); // NOI18N

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanelLayout.createSequentialGroup()
                                .addComponent(titleBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        //RIGHT PANEL
        rightPanel.setBackground(new java.awt.Color(255, 255, 204));

        orderPanel.setBackground(new java.awt.Color(255, 255, 204));

        yourOrderLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        yourOrderLabel.setForeground(new java.awt.Color(250, 104, 0));
        yourOrderLabel.setText("Your order");

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
                orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(orderPanelLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(yourOrderLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        orderPanelLayout.setVerticalGroup(
                orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanelLayout.createSequentialGroup()
                                .addContainerGap(61, Short.MAX_VALUE)
                                .addComponent(yourOrderLabel)
                                .addGap(58, 58, 58))
        );

        ordersScroller.setBackground(new java.awt.Color(255, 255, 255));



        ordersPanel.setBackground(new java.awt.Color(255, 255, 255));
        ordersPanel.setLayout(new GridLayout(100, 1) );
        c_order = new GridBagConstraints();
        c_order.insets = new Insets(0, 0, 5, 0);
        initOrdersPanel();

        ordersScroller.setViewportView(ordersPanel);

        makeOrderPanel.setBackground(new java.awt.Color(255, 255, 204));

        preorderButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_preorder_released.png"))); // NOI18N
        preorderButtonLabel.setToolTipText("Make an order");
        preorderButtonLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        preorderButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preorderLabelClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                preorderLabelPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                preorderLabelReleased(evt);
            }
        });

        itemsLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        itemsLabel.setForeground(new java.awt.Color(102, 102, 102));
        itemsLabel.setText("Items:");

        costLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        costLabel.setForeground(new java.awt.Color(102, 102, 102));
        costLabel.setText("Total cost:");

        itemsNoLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemsNoLabel.setText("0");

        priceNoLabel.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        priceNoLabel.setText("0.00");

        javax.swing.GroupLayout makeOrderPanelLayout = new javax.swing.GroupLayout(makeOrderPanel);
        makeOrderPanel.setLayout(makeOrderPanelLayout);
        makeOrderPanelLayout.setHorizontalGroup(
                makeOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeOrderPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(preorderButtonLabel)
                                .addGap(30, 30, 30)
                                .addGroup(makeOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeOrderPanelLayout.createSequentialGroup()
                                                .addComponent(costLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(priceNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeOrderPanelLayout.createSequentialGroup()
                                                .addComponent(itemsLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(itemsNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(58, 58, 58))
        );
        makeOrderPanelLayout.setVerticalGroup(
                makeOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(makeOrderPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(makeOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(preorderButtonLabel)
                                        .addGroup(makeOrderPanelLayout.createSequentialGroup()
                                                .addGroup(makeOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(costLabel)
                                                        .addComponent(priceNoLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(makeOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(itemsLabel)
                                                        .addComponent(itemsNoLabel))))
                                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
                rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(orderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ordersScroller, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(makeOrderPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
                rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(orderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ordersScroller)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(makeOrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );


        //CENTRAL FOODS SCROLLER
        foodsScroller.setBackground(new java.awt.Color(255, 255, 255));
        foodsScroller.setViewportView(foodsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(foodsScroller)
                                        .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(foodsScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void preorderLabelClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:


        OrderWaitingFrame frame = new OrderWaitingFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        preorderButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_preorder_released.png")));

        int orderId = Database.uploadOrder(order);
        if(SocketClient.sendOrder(orderId))
        {

        }

    }

    private void preorderLabelReleased(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

    }

    private void preorderLabelPressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        preorderButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_preorder_pressed.png")));
    }

    public void initFoodsPanel(String category) {

        foodsPanel.removeAll();
        foodsPanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 1);

        //Adding all foods
        if(category.equals("All")){
            for (int i = 0; i < foods.size(); i++) {
                System.out.println("food #" + i +" added");
                c.gridx = i % COLUMN;
                c.gridy = i / COLUMN;
                foodsPanel.add(new SingleFoodPanel(foods.get(i)), c);
            }
        }
        else{
            //DARKHONBEK
            //Adding through database
            for (int i = 0, j = 0; i < foods.size(); i++) {
                if( category.equals(foods.get(i).getCategory()) ){
                System.out.println("food #" + i +" added");
                c.gridx = j % COLUMN;
                c.gridy = j / COLUMN;
                foodsPanel.add(new SingleFoodPanel(foods.get(i)), c);
                    j++;
                }
            }
            /*
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
            */

            foodsPanel.revalidate();
        }
    }


    public void initOrdersPanel(){
        ordersPanel.removeAll();
        for(int i = 0; i < order.getSize(); i++){
            c_order.gridx = i % COLUMN_ORDER;
            c_order.gridy = i / COLUMN_ORDER;
            SingleOrderPanel singleOrderPanel = new SingleOrderPanel( order.getFoods().get(i) );
            ordersPanel.add(singleOrderPanel, c_order);
        }
        ordersPanel.revalidate();
        ordersPanel.updateUI();
        updateOrderInfo();
    }

    public void updateOrderInfo(){
        itemsNoLabel.setText( Integer.toString(order.getFoods().size()) );
        priceNoLabel.setText( Double.toString(order.getTotalCost()) );

    }

    public void initCategoriesPanel(){
        categoriesPanel.removeAll();

        /*
        //THIS IS FAKE CATEGORIES
        //ORIGINAL ONES SHOULD BE DOWNLOADED VIA DATABASE
        //new javax.swing.ImageIcon(getClass().getResource("/Assets/category.png"))
        Category fakeCategory = new Category("Category name", 001, null);

        for(int i = 0; i < 7; i++){
            c_categories.gridx = i % COLUMN_ORDER;
            c_categories.gridy = i / COLUMN_ORDER;
            categoriesPanel.add(new SingleCategoryPanel(fakeCategory), c_categories);
        }
        */

        for(int i = 0; i < categories.size(); i++){
            c_categories.gridx = i % COLUMN_ORDER;
            c_categories.gridy = i / COLUMN_ORDER;
            categoriesPanel.add(new SingleCategoryPanel(categories.get(i)), c_categories);
        }


        categoriesPanel.revalidate();
        categoriesPanel.updateUI();
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel categoriesPanel;
    private javax.swing.JLabel costLabel;
    private javax.swing.JPanel foodsPanel;
    private javax.swing.JScrollPane foodsScroller;
    private javax.swing.JLabel itemsLabel;
    private javax.swing.JLabel itemsNoLabel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel makeOrderPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JPanel ordersPanel;
    private javax.swing.JScrollPane ordersScroller;
    private javax.swing.JLabel preorderButtonLabel;
    private javax.swing.JLabel priceNoLabel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel titleBackground;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JPanel welcomePanel;
    private javax.swing.JLabel yourOrderLabel;
    // End of variables declaration
}
