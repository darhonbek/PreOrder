package BusinessLogic;


import javax.swing.*;

public class OrderedFood extends Food{

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderedFood(int id, String name, String category, double price, ImageIcon image, int n){
        super(id, name, category, price, image);
        this.quantity = n;
    }
    public boolean add(int num)//increase food
    {
        if(num < 0)
            return false;
        this.quantity += num;
        return true;
    }
    public boolean sell(int num)//decrease food
    {
        if(num > quantity)
            return false;
        this.quantity -= num;
        return true;
    }
}