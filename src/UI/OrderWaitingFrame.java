package UI;

/**
 *
 * @author darho_000
 */
public class OrderWaitingFrame extends javax.swing.JFrame {

    public OrderWaitingFrame() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(390, 270);
        this.setAlwaysOnTop(true);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        loaderLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(390, 270));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        messageLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(245, 124, 0));
        messageLabel.setText("Your order is in progress...");
        jPanel1.add(messageLabel);
        messageLabel.setBounds(80, 220, 250, 30);

        loaderLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/loader.gif"))); // NOI18N
        loaderLabel.setPreferredSize(new java.awt.Dimension(390, 300));
        jPanel1.add(loaderLabel);
        loaderLabel.setBounds(0, -30, 390, 300);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 390, 300);

        pack();
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loaderLabel;
    private javax.swing.JLabel messageLabel;
    // End of variables declaration
}
