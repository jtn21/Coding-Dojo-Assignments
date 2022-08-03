


public class TestOrders{

    public static void main(String[] args){
        // Menu items
        Item item1 = new Item("mocha", 4.0);
        Item item2 = new Item("latte", 4.5);
        Item item3 = new Item("drip coffee", 3.0);
        Item item4 = new Item("capuccino", 3.5);


        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Bob");
        Order order4 = new Order("Tom");
        Order order5 = new Order("Sam");

        order1.addItem(item1);
        order1.addItem(item3);
        order2.addItem(item2);
        order2.addItem(item3);
        order3.addItem(item1);
        order4.addItem(item2);
        order4.addItem(item3);

        System.out.println(order1.getStatusMessage());
        System.out.println(order1.getOrderTotal());

        order4.display();
    }
}