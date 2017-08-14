package UI;

import BusinessLogic.Category;
import FunctionalClasses.ImageScale;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Locale;

public class SingleCategoryPanel extends javax.swing.JPanel {


    public SingleCategoryPanel(Category category) {
        this.category = category;
        initComponents();
    }

    private void initComponents() {
        nameLabel = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryClicked(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Calibri", 3, 20)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText(category.getName());

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //Initializing icon label
        iconLabel.setSize(50, 50);
        iconLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
        iconLabel.setIcon( ImageScale.getScaledImage(category.getIcon(), iconLabel.getWidth(), iconLabel.getHeight()) );
        add(iconLabel);
        add(nameLabel);

        setPreferredSize(new Dimension(210, 50));
        setMaximumSize(new Dimension(210, 50));
    }

    //BACKGROUND
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new javax.swing.ImageIcon(getClass().getResource("/Assets/category.png")).getImage(), 0, 0, null);
    }

    private void categoryClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        ClientMainFrame2 frame = (ClientMainFrame2)SwingUtilities.getRoot(this);
        frame.initFoodsPanel(category.getName());
    }

    // Variables declaration - do not modify
    private Category category;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration
}
