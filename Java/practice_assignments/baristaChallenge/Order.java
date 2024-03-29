import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(){
        this.name = "guest";
        this.items = new ArrayList<Item>();
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

        // GETTERS & SETTERS
    public String getName(){
        return this.name;
    }

    public boolean isReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIsReady(){
        this.ready = ready;
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }


    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!

    public void addItem(Item item){
        this.items.add(item);
    }


    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready";
        } else {
            return "Thank you for waiting. Your order will be ready soon";
        }
    }

        public double getOrderTotal(){
        double total = 0.0;
        for(Item i: this.items) {
            total += i.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.printf("Customer Name: %s", this.name);
        for(Item i: this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }


}

