package BusinessLogic;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by darho_000 on 12/21/2016.
 */
public class Category {

    private String name;
    private int id;
    private ImageIcon icon;

    public Category(String name, int id, ImageIcon icon){
        setName(name);
        setId(id);
        setIcon(icon);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ImageIcon getIcon() {
        return icon;
    }
    public void setIcon(ImageIcon icon) {
        if(icon != null)
            this.icon = icon;
        else{
            this.icon = new javax.swing.ImageIcon(getClass().getResource("/Assets/category.png"));
        }
    }
}
