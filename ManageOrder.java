package src;

import java.util.Date;

public interface ManageOrder {
	
	 public void changeOrderStatus(String title, String sender, Date date, orderStatus status);
}
