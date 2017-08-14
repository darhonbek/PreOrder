package BusinessLogic;

import javax.swing.*;

public class Food
{
    protected double price;
    protected final String name;
    protected final int ID;
    protected final String category;
    protected ImageIcon image;
    protected boolean isAvailable;

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public ImageIcon getImage() { return image; }
    public void setImage(ImageIcon image) { this.image = image; }


    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price)
    {
        if(price > 0)
            this.price = price;
        else
            this.price = 0;
    }

    public Food(int id, String name, String category, double price, ImageIcon image)
    {
        this.name = name;
        this.ID = id;
        this.category = category;
        this.image = image;
        this.isAvailable = true;
        setPrice(price);
    }
}
