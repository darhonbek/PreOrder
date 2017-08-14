
package UI;

import java.rmi.server.UnicastRemoteObject;

public class AdminOrdersFrame extends javax.swing.JFrame {

    public AdminOrdersFrame() {
        initComponents();
    }

    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        ordersLabel = new javax.swing.JLabel();
        ordersInfoLabel = new javax.swing.JLabel();
        acceptedLabel = new javax.swing.JLabel();
        acceptedInfoLabel = new javax.swing.JLabel();
        queueScroller = new javax.swing.JScrollPane();
        queuePanel = new javax.swing.JPanel();
        queueElement = new javax.swing.JLabel();
        queueInfoPanel = new javax.swing.JPanel();
        customerNameLabel = new javax.swing.JLabel();
        queueInfoScroller = new javax.swing.JScrollPane();
        queueInfoElement = new javax.swing.JPanel();
        foodNameLabel = new javax.swing.JLabel();
        foodNameLabel2 = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        declineButton = new javax.swing.JButton();
        acceptedScroller = new javax.swing.JScrollPane();
        acceptedPanel = new javax.swing.JPanel();
        acceptedElement = new javax.swing.JLabel();
        acceptedInfoPanel = new javax.swing.JPanel();
        customerNameLabel1 = new javax.swing.JLabel();
        acceptedInfoScroller = new javax.swing.JScrollPane();
        queueInfoElement1 = new javax.swing.JPanel();
        foodNameLabel1 = new javax.swing.JLabel();
        foodNameLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ordersLabel.setText("Orders in queue");

        ordersInfoLabel.setText("Order Information");

        acceptedLabel.setText("Accepted Orders");

        acceptedInfoLabel.setText("Accepted Order Information");

        javax.swing.GroupLayout upperPanelLayout = new javax.swing.GroupLayout(upperPanel);
        upperPanel.setLayout(upperPanelLayout);
        upperPanelLayout.setHorizontalGroup(
                upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(upperPanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(ordersLabel)
                                .addGap(167, 167, 167)
                                .addComponent(ordersInfoLabel)
                                .addGap(169, 169, 169)
                                .addComponent(acceptedLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(acceptedInfoLabel)
                                .addGap(88, 88, 88))
        );
        upperPanelLayout.setVerticalGroup(
                upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(upperPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ordersInfoLabel)
                                        .addComponent(acceptedLabel)
                                        .addComponent(acceptedInfoLabel)
                                        .addComponent(ordersLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        queueElement.setText("Queue product #1");

        javax.swing.GroupLayout queuePanelLayout = new javax.swing.GroupLayout(queuePanel);
        queuePanel.setLayout(queuePanelLayout);
        queuePanelLayout.setHorizontalGroup(
                queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(queuePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(queueElement)
                                .addContainerGap(154, Short.MAX_VALUE))
        );
        queuePanelLayout.setVerticalGroup(
                queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(queuePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(queueElement)
                                .addContainerGap(437, Short.MAX_VALUE))
        );

        queueScroller.setViewportView(queuePanel);

        customerNameLabel.setText("Customer Name");

        foodNameLabel.setText("Food #1");

        foodNameLabel2.setText("Food #2");

        javax.swing.GroupLayout queueInfoElementLayout = new javax.swing.GroupLayout(queueInfoElement);
        queueInfoElement.setLayout(queueInfoElementLayout);
        queueInfoElementLayout.setHorizontalGroup(
                queueInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(queueInfoElementLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(queueInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(foodNameLabel)
                                        .addComponent(foodNameLabel2))
                                .addContainerGap(206, Short.MAX_VALUE))
        );
        queueInfoElementLayout.setVerticalGroup(
                queueInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(queueInfoElementLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(foodNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(foodNameLabel2)
                                .addContainerGap(287, Short.MAX_VALUE))
        );

        queueInfoScroller.setViewportView(queueInfoElement);

        acceptButton.setText("Accept");

        declineButton.setText("Decline");

        javax.swing.GroupLayout queueInfoPanelLayout = new javax.swing.GroupLayout(queueInfoPanel);
        queueInfoPanel.setLayout(queueInfoPanelLayout);
        queueInfoPanelLayout.setHorizontalGroup(
                queueInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(queueInfoPanelLayout.createSequentialGroup()
                                .addGroup(queueInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(queueInfoPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(queueInfoScroller))
                                        .addGroup(queueInfoPanelLayout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(customerNameLabel)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(queueInfoPanelLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(acceptButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(declineButton)
                                .addGap(43, 43, 43))
        );
        queueInfoPanelLayout.setVerticalGroup(
                queueInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(queueInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(customerNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(queueInfoScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(queueInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(acceptButton)
                                        .addComponent(declineButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        acceptedElement.setText("Accepted product #1");

        javax.swing.GroupLayout acceptedPanelLayout = new javax.swing.GroupLayout(acceptedPanel);
        acceptedPanel.setLayout(acceptedPanelLayout);
        acceptedPanelLayout.setHorizontalGroup(
                acceptedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(acceptedPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(acceptedElement)
                                .addContainerGap(154, Short.MAX_VALUE))
        );
        acceptedPanelLayout.setVerticalGroup(
                acceptedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(acceptedPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(acceptedElement)
                                .addContainerGap(437, Short.MAX_VALUE))
        );

        acceptedScroller.setViewportView(acceptedPanel);

        customerNameLabel1.setText("Customer Name");

        foodNameLabel1.setText("Food #1");

        foodNameLabel3.setText("Food #2");

        javax.swing.GroupLayout queueInfoElement1Layout = new javax.swing.GroupLayout(queueInfoElement1);
        queueInfoElement1.setLayout(queueInfoElement1Layout);
        queueInfoElement1Layout.setHorizontalGroup(
                queueInfoElement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(queueInfoElement1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(queueInfoElement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(foodNameLabel1)
                                        .addComponent(foodNameLabel3))
                                .addContainerGap(209, Short.MAX_VALUE))
        );
        queueInfoElement1Layout.setVerticalGroup(
                queueInfoElement1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(queueInfoElement1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(foodNameLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(foodNameLabel3)
                                .addContainerGap(351, Short.MAX_VALUE))
        );

        acceptedInfoScroller.setViewportView(queueInfoElement1);

        javax.swing.GroupLayout acceptedInfoPanelLayout = new javax.swing.GroupLayout(acceptedInfoPanel);
        acceptedInfoPanel.setLayout(acceptedInfoPanelLayout);
        acceptedInfoPanelLayout.setHorizontalGroup(
                acceptedInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(acceptedInfoPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(customerNameLabel1)
                                .addContainerGap(175, Short.MAX_VALUE))
                        .addComponent(acceptedInfoScroller)
        );
        acceptedInfoPanelLayout.setVerticalGroup(
                acceptedInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(acceptedInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(customerNameLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(acceptedInfoScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(queueScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(queueInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(acceptedScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(acceptedInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(upperPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(upperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(queueScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(queueInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(acceptedScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(acceptedInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton acceptButton;
    private javax.swing.JLabel acceptedElement;
    private javax.swing.JLabel acceptedInfoLabel;
    private javax.swing.JPanel acceptedInfoPanel;
    private javax.swing.JScrollPane acceptedInfoScroller;
    private javax.swing.JLabel acceptedLabel;
    private javax.swing.JPanel acceptedPanel;
    private javax.swing.JScrollPane acceptedScroller;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel customerNameLabel1;
    private javax.swing.JButton declineButton;
    private javax.swing.JLabel foodNameLabel;
    private javax.swing.JLabel foodNameLabel1;
    private javax.swing.JLabel foodNameLabel2;
    private javax.swing.JLabel foodNameLabel3;
    private javax.swing.JLabel ordersInfoLabel;
    private javax.swing.JLabel ordersLabel;
    private javax.swing.JLabel queueElement;
    private javax.swing.JPanel queueInfoElement;
    private javax.swing.JPanel queueInfoElement1;
    private javax.swing.JPanel queueInfoPanel;
    private javax.swing.JScrollPane queueInfoScroller;
    private javax.swing.JPanel queuePanel;
    private javax.swing.JScrollPane queueScroller;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration
}
