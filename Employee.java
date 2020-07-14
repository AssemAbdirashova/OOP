package src;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")

public abstract class Employee extends User implements Serializable{
    private ArrayList<Order> orders;
    private int salary;
    
    public Employee(String firstName, String lastName, String login,int salary) {
        super(firstName, lastName, login);
        this.salary = salary;
        orders = new ArrayList<Order>();
    }
    public Employee(String firstName, String lastName, String login) {
        super(firstName, lastName, login);
        orders = new ArrayList<Order>();
    }

    public boolean sendOrder(Order order, String login) {
        for (Employee e : Runner.teachers) {
            if (e.getLogin().equals(login)) {
                e.orders.add(order);
                return true;
            }
        }
        for (Employee e : Runner.managers) {
            if (e.getLogin().equals(login)) {
                e.orders.add(order);
                return true;
            }
        }
        return false;
    }
    
    
	public int getSalary() {
		return salary;
	}
	
	public String toString() {
	    return super.toString() + "salary" ;
	}

	public boolean equals(Object obj) {
	    if (obj == this) return true;
	    if (!(obj instanceof Employee)) return false;
	    Employee u = (Employee) obj;
	    return u.salary==salary && super.equals(u);
	}
	    
	    
	    public int hashCode() {
	        return super.hashCode() +  salary*8;
	       }
}
