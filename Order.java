package src;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("serial")
public class Order implements Serializable {
    private orderStatus status;
    private String title;
    private String text;
    private String sender;
    private Date date;
    
    public Order(String title, String text, String sender, Date date) {
       this.title = title;
       this.text = text;
       this.sender = sender;
       this.date = date;
        status = orderStatus.NEW;
    }

    public orderStatus getStatus() {
        return status;
    }
    public void setStatus(orderStatus status) {
        this.status = status;
    }
    
    public boolean equals(Object obj) {
    	Order order = (Order)obj ;
    	if(order.status == status && order.title.equals(title) && order.text.equals(text) &&
                order.sender.equals(sender) && order.date.equals(date)) {
    		return true;
    	}
    	else return false;
    }

	@Override
    public String toString() {
		String dateInfo = new SimpleDateFormat("dd.MM.yyyy").format(date);
        String timeInfo = new SimpleDateFormat("HH:mm").format(date);
        String info = title + "\n\n" + text + "\n\n";
        info += "Sender: " + sender + '\n' + "Date: " + dateInfo + '\n' + "Time: " + timeInfo + '\n' + "Status: " + status.toString() + '\n'; 
        return info;
    }

	public String getTitle() {
		return title;
	}

	
	public String getText() {
		return text;
	}

	public Date getDate() {
		return date;
	}

	public String getSender() {
		return sender;
	}



	
}

