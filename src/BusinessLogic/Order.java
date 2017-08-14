package BusinessLogic;

import java.util.*;

public class Order
{
    private final int ID;
    private final int userID;
    private double totalCost;
    private Date date;
    private ArrayList<Food> foods;
    private int isAccepted;
    private String comment;

    public int isAccepted() {
        return isAccepted;
    }

    public void setAccepted(int accepted) {
        isAccepted = accepted;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return userID;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost)
    {
        if(totalCost > 0)
            this.totalCost = totalCost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public Order(int orderID, int userID)//, Date date)
    {
        foods = new ArrayList<Food>();
        totalCost = 0;
        isAccepted = 0;
        this.ID = orderID;
        this.userID = userID;
        //this.date = date;
    }
    public Order(int orderID, int userID, double totalCost, Date date, ArrayList<Food> foods, int isAccepted, String comment){
        this.foods = foods;
        this.totalCost = totalCost;
        this.isAccepted = isAccepted;
        this.ID = orderID;
        this.userID = userID;
        this.comment = comment;
        this.date = date;
    }

    public int getSize(){
        return this.foods.size();
    }

    public void addFood(Food f)
    {
        this.foods.add(f);
        this.totalCost += f.getPrice();
    }

    public void removeFood(Food f)
    {
        for (int i = 0; i < this.foods.size(); i++)
        {
            if(this.foods.get(i) == f)
            {
                this.totalCost -= foods.get(i).getPrice();
                this.foods.remove(i);
                break;
            }
        }
    }

    //sending order to the server
    //then administrator processes the order
    public void makeOrder()
    {
        //some code
    }



}
