package src;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class TechSupportGuy extends Employee implements ManageOrder, Serializable {
	 static {
	        try {
				Database.desOrders();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
    public TechSupportGuy(String lastName, String firstName, String login) {
        super(lastName, firstName, login);
     }
    
    public ArrayList<String> getOrders() {
        ArrayList<String> Text =  new ArrayList<>();

        for (Order o: Database.orders) {
            Text.add(o.getTitle() + "\nSender: " + o.getSender() + "\n\n");
        }

        return Text;
    }
    public String viewDoneAndAcceptedOrders(){
      for (Order o: Database.orders) {
        if(o.getStatus() == orderStatus.ACCEPTED)
        return o.toString();
      }
        return "Nothing accepted";
    }
    
   
    public void changeOrderStatus(String title, String sender, Date date, orderStatus status) {
        for (Order o: Database.orders) {
            if (o.getTitle().equals(title) && o.getSender().equals(sender) && o.getDate().equals(date)) {
                o.setStatus(status);
                break;
            }
        }
    }
       
	public ArrayList<Order> getOrders(orderStatus status) {
	 ArrayList<Order> curOrders = new ArrayList<>();

	        for (Order o : Database.orders) {
	            if (o.getStatus() == status) {
	                curOrders.add(o);
	            }
	        }
	        return curOrders;		
	}
	  
}
