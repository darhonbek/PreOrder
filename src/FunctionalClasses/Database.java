package FunctionalClasses;

import BusinessLogic.Category;
import BusinessLogic.Food;
import BusinessLogic.Order;
import BusinessLogic.OrderedFood;
import UI.LoadingFrame;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Abdulbosid on 12.12.2016.
 */
public class Database
{
   public static final String SERVER_NAME = "192.168.18.224";
   private static final String url = "jdbc:mysql://" + SERVER_NAME + ":3306/preorder";
   private static final String user = "abdulbosid";
   private static final String password = "abdul618";

   private static Connection connection;

   public Database()
   {
      LoadingFrame loader = new LoadingFrame();
      loader.setVisible(true);

      establishConnection();

      loader.dispose();
   }

   public static ArrayList<Food> getAllFood(){


      Database db = new Database();
      PreparedStatement preparedStatement;
      ResultSet resultSet;
      ArrayList<Food> foods = new ArrayList<>();

      String query = "SELECT * FROM foods";
      try{
         preparedStatement = db.getConnection().prepareStatement(query);
         resultSet = preparedStatement.executeQuery();
         String name, category;
         boolean isAvailable;
         double price;
         ImageIcon image = null;
         int foodID;

         while (resultSet.next())
         {
            name = resultSet.getString("name");
            category = resultSet.getString("category");
            price = resultSet.getDouble("price");
            isAvailable = resultSet.getBoolean("isAvailable");
            resultSet.getString("imagelocation");
            foodID = resultSet.getInt("foodid");
            byte[] img = resultSet.getBytes("image");
            image = new ImageIcon(img);
            foods.add(new Food(foodID, name, category, price, image));
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }
      //some code

      return foods;
   }

   //MODIFY THIS CODE ACCORDING TO THE NEW CLASS CATEGORY
   //IT SHOULD RETURN CATEGORY-TYPE ARRAY LIST, NOT STRING TYPE
   public static ArrayList<Category> getCategories(){
      Database db = new Database();
      PreparedStatement preparedStatement;
      ResultSet resultSet;
      ArrayList<Category> categories = new ArrayList<>();

      String query = "SELECT * FROM category";
      try{
         preparedStatement = db.getConnection().prepareStatement(query);
         resultSet = preparedStatement.executeQuery();
         String name = "";
         int id = 0;
         ImageIcon image = new ImageIcon();

         while (resultSet.next())
         {
            name = resultSet.getString("categoryName");
            id = resultSet.getInt("id");
            image = new ImageIcon(resultSet.getBytes("image"));
            categories.add(new Category(name, id, image));
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }
      return categories;
   }

   public static Connection getConnection()
   {
      if (connection == null)
      {
         establishConnection();
      }
      return connection;
   }

   public static void establishConnection(){
      try
      {
         System.out.println("Connecting...");
         connection = DriverManager.getConnection(url, user, password);
         System.out.println("Connected!");

      } catch (SQLException e)
      {
         e.printStackTrace();
      }
   }

   public static void closeConnection() {
      try  {
         connection.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public static int uploadOrder(Order order) // returns orderId
   {
      double totalCost = order.getTotalCost();
      java.sql.Date date = (Date) order.getDate();;
      ArrayList<Food> foods = order.getFoods();
      String comment = order.getComment();
      int userId = order.getUserID();
      int orderId = 0;
      establishConnection();
      try
      {
         String query = "INSERT INTO orders(userid, totalcost, isAccepted, comment) VALUES (?,?,?,?)";
         //uploading
         // order object to orders table
         PreparedStatement preparedStatement = getConnection().prepareStatement(query);
         preparedStatement.setInt(1, userId);
         preparedStatement.setDouble(2, totalCost);
         preparedStatement.setBoolean(3, false);
         preparedStatement.setString(4, comment);
         System.out.println("Executing...");
         preparedStatement.execute();
         System.out.println("Executed!");

         String query1 = "SELECT orderId FROM orders WHERE 1";
         ResultSet resultSet = getConnection().createStatement().executeQuery(query1);
         if (resultSet.last())
         {
            orderId = resultSet.getInt("orderid");
         }
         for (Food food:foods)
         {
            query = "INSERT INTO orderitems(orderid, foodid) VALUES (?,?)";
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, food.getID());
            preparedStatement.execute();
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return orderId;
   }

   public static Order getOrder(int orderId)
   {
      establishConnection();

      int userId = 0;
      double totalCost = 0;
      java.sql.Date date = null;
      ArrayList<Food> foods = null;
      int isAccepted = 0;
      String comment = null;
      ImageIcon image = null;

      Order order;
      try
      {
         String query = "SELECT * FROM orders WHERE orderid=?";
         PreparedStatement preparedStatement = getConnection().prepareStatement(query);
         preparedStatement.setInt(1, orderId);
         ResultSet resultSet = preparedStatement.executeQuery();

         int counter = 0;
         while (resultSet.next())
         {
            counter++;
         }
         if (counter == 0)
         {
            throw new Exception("orderid not found in Database");
         }
         else if (counter > 1)
         {
            throw new Exception("Several orders with same orderid");
         }
         resultSet.first();
         userId = resultSet.getInt("userid");
         totalCost = resultSet.getDouble("totalcost");
         date = resultSet.getDate("datetime");
         isAccepted = resultSet.getInt("isAccepted");
         comment = resultSet.getString("comment");

         query = "SELECT * FROM orderitems WHERE orderid=?";
         preparedStatement = getConnection().prepareStatement(query);
         preparedStatement.setInt(1, orderId);
         resultSet = preparedStatement.executeQuery();

         ArrayList<Integer> foodsId = new ArrayList<Integer>();
         foods = new ArrayList<Food>();
         while (resultSet.next())
         {
            foodsId.add(resultSet.getInt("foodid"));
         }
         for (int i = 0; i < foodsId.size(); i++)
         {
            query = "SELECT * FROM foods WHERE foodid=?";
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, foodsId.get(i));
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            byte[] img = resultSet.getBytes("image");
            image = new ImageIcon(img);
            Food food = new Food(foodsId.get(i), resultSet.getString("name"), resultSet.getString("category"),
                    resultSet.getDouble("price"), image);
            foods.add(food);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      order = new Order(orderId, userId, totalCost, date, foods, isAccepted, comment);
      System.out.println("Got the order with orderid: " + orderId);
      return order;
   }

   public static void updateFood(int FoodId, String  name, Double price, String category, String imageLocation,
                                 ImageIcon image, boolean isAvailable)
   {
      try
      {
         String query = "UPDATE foods SET name=?, price=?, category=?, imagelocation=?, image=?, isAvailable=? WHERE " +
                 "foodid=?";
         PreparedStatement preparedStatement = getConnection().prepareStatement(query);
         preparedStatement.setString(1, name);
         preparedStatement.setDouble(2, price);
         preparedStatement.setString(3, category);
         preparedStatement.setString(4, imageLocation);

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

}
