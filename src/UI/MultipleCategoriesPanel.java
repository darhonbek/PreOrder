/*
package UI;

import javax.swing.*;
import java.awt.*;

public class MultipleCategoriesPanel extends JFrame
{
    private JPanel categoriesPanel;
    private final static int COLUMN = 1;
    private GridBagConstraints c;

    public MultipleCategoriesPanel(){
        super("Food tester");
        this.setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        categoriesPanel = new JPanel();

        categoriesPanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 5, 0);

        initCategoriesPanel();
        this.add(categoriesPanel);

        setVisible(true);
        //add(new singleCategoryPanel());
        setPreferredSize(new Dimension(210, 630));
        setSize(210, 630);
    }
    private void initCategoriesPanel(){
        for(int i = 0; i < 7; i++){
            c.gridx = i % COLUMN;
            c.gridy = i / COLUMN;
            categoriesPanel.add(new SingleCategoryPanel(), c);
        }
        categoriesPanel.revalidate();
    }
}
*/