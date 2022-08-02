import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {

    public int getStreakGoal(){
        int sum = 0;
        for(int  i = 0; i < 11; i++){
            sum += i;
        }
        return sum; 
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;
        for(int i=0; i < prices.length; i++){
            sum += prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        // String menuItem1 = menuItems.get(0);
        // String menuItem2 = menuItems.get(1);
        // String menuItem3 = menuItems.get(2);
        // String menuItem4 = menuItems.get(3);
        // System.out.println(menuItems.get(0));
        for(String item: menuItems){
            System.out.println(item);
        }
    }

    public void addCustomer(ArrayList<String>customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello" + " " + userName);
        int size = customers.size();
        System.out.println("There is" + " " + customers.size() + " " +"people in front of you.");
        customers.add(userName);
        System.out.println(customers);
    }

}