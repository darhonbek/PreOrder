/*
package UI;

import items.MenuItemUI;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class MenuUI extends JPanel{
    private ArrayList<MenuItemUI> menuItems;
    private final static int COLUMN = 2;
    private JPanel mainPanel;
    private GridBagConstraints c;

    public MenuUI(ArrayList<MenuItemUI> items){
        mainPanel = new JPanel();
        JScrollPane sp = new JScrollPane(mainPanel);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        mainPanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        menuItems = items;
        setItems();

        this.add(sp);

        setBorder(new EmptyBorder(5, 5, 5, 5));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getPreferredSize().width/2, dim.height/2-this.getPreferredSize().height/2);
    }

    private void setItems(){
        for(int i = 0; i < menuItems.size(); i++){
            c.gridx = i % COLUMN;
            c.gridy = i / COLUMN;
            mainPanel.add(menuItems.get(i), c);
        }

        mainPanel.revalidate();
    }

    public ArrayList<MenuItemUI> getMenuItemUIs(){
        return menuItems;
    }
}
*/