package FunctionalClasses;
import BusinessLogic.Customer;
import BusinessLogic.Food;
import BusinessLogic.Order;
import UI.*;

import javax.swing.*;
import java.util.ArrayList;

public class Starter
{
    public static void main(String[] args)
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //DARKHONBEK
        Order order = fakeOrder();//new ImageIcon());
        //JOptionPane.showMessageDialog(null, "Hello world!");

        java.awt.EventQueue.invokeLater(() ->
                new LoginFrame().setVisible(true)
                //new AdminMainFrame().setVisible(true)
                //new RegisterFrame().setVisible(true)
                //new AddFoodFrame().setVisible(true)
                //new MultipleCategoriesPanel().setVisible(true)
                //new OrderWaitingFrame().setVisible(true)
                //new LoadingFrame().setVisible(true)
                //new ClientMainFrame(new Customer("Darkhonbek", "Mamataliev", 001, "+998971316997", "qwerty") ).setVisible(true)
                //new OrdersFrame(order).setVisible(true)
                //new ClientMainFrame2(new Customer("Darkhonbek", "Mamataliev", 001, "+998971316997", "qwerty") ).setVisible(true)
        );
    }

    public static Order fakeOrder(){
        ArrayList<Food> foods = new ArrayList<>();
        ImageIcon img = new ImageIcon("/Assets/Food icon.png");
        Food food1 = new Food(001, "Bize", "Dishes", 5000, img);
        Food food2 = new Food(002, "Ice-cream", "Sweats", 1000, img);
        Food food3 = new Food(003, "Cake", "Cakes", 12000, img);
        Food food4 = new Food(004, "Tornado pancake", "Cakes", 7000, img);
        Food food5 = new Food(005, "Lavash", "Fast food", 5000, img);
        Food food6 = new Food(006, "Lolly-pop", "Sweats", 5000, img);
        for (int i = 0; i < 2; i++) {
            foods.add(food1);
            foods.add(food2);
            foods.add(food3);
            foods.add(food4);
            foods.add(food5);
            foods.add(food6);
        }
        Order order = new Order(1, 13);
        order.setFoods(foods);
        return order;
    }
}
