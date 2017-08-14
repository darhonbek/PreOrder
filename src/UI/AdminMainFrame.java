package UI;

import BusinessLogic.Category;
import FunctionalClasses.Database;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author darho_000
 */
public class AdminMainFrame extends javax.swing.JFrame {

    private ArrayList<Category> categories;

    public AdminMainFrame() {
        db = new Database();
        categories = db.getCategories();
        initComponents();
        this.setLocationRelativeTo(null);
/*
        try{
            server = new RMIServer();
            try{
                // Bind this object instance to the name "RmiServer"
                Naming.rebind("rmi://192.168.19.91/RmiServer", server);
                System.out.println("PeerServer bound in registry");
                System.out.println("Server Running ...........");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        mottoLabel = new javax.swing.JLabel();
        newFoodLabel = new javax.swing.JLabel();
        newCategoryLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/PreOrder logo in center yellow.png"))); // NOI18N

        mottoLabel.setForeground(new java.awt.Color(102, 102, 102));
        mottoLabel.setText("Bringing you best quality service");

        newFoodLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_new-food_released.png"))); // NOI18N
        newFoodLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newFoodLabelPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                newFoodLabelReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newFoodLabelClicked(evt);

            }
        });
        newCategoryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_new-category_released.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(214, 214, 214)
                                                .addComponent(mottoLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(225, 225, 225)
                                                .addComponent(newFoodLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(205, 205, 205)
                                                .addComponent(newCategoryLabel)))
                                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mottoLabel)
                                .addGap(120, 120, 120)
                                .addComponent(newFoodLabel)
                                .addGap(66, 66, 66)
                                .addComponent(newCategoryLabel)
                                .addContainerGap(146, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainFrame().setVisible(true);
            }
        });
    }

    private void newFoodLabelPressed(java.awt.event.MouseEvent evt) {
        newFoodLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_new-food_pressed.png")));
    }

    private void newFoodLabelReleased(java.awt.event.MouseEvent evt) {
        newFoodLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/button_new-food_released.png")));
    }

    private void newFoodLabelClicked(MouseEvent evt) {

        ArrayList<String> categoryList = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            categoryList.add(categories.get(i).getName());
        }

        new AddFoodFrame(categoryList).setVisible(true);
    }

    // Variables declaration - do not modify
    private Database db;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel mottoLabel;
    private javax.swing.JLabel newCategoryLabel;
    private javax.swing.JLabel newFoodLabel;
    // End of variables declaration
}
