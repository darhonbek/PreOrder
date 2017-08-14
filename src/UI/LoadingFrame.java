package UI;

/**
 *
 * @author darho_000
 */
public class LoadingFrame extends javax.swing.JFrame {

    public LoadingFrame() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(390, 270);
        this.setAlwaysOnTop(true);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loaderLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(410, 310));
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(400, 270));
        jPanel1.setLayout(null);

        loaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loaderLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/loading.gif"))); // NOI18N
        jPanel1.add(loaderLabel);
        loaderLabel.setBounds(130, 60, 128, 130);

        messageLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(245, 124, 0));
        messageLabel.setText("Loading data...");
        jPanel1.add(messageLabel);
        messageLabel.setBounds(130, 210, 150, 25);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Loading background 2.png"))); // NOI18N
        jPanel1.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 400, 290);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 290);

        pack();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loaderLabel;
    private javax.swing.JLabel messageLabel;
    // End of variables declaration                   
}
