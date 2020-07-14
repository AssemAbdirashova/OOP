package src;

import java.util.Date;

public class Schedule {
	Course c;
	String room;
	Date d;
	
	public Schedule(Course course, String r, Date date){
		c= course;
		room = r;
		d = date;
	}
	
	public String toString() {
		return room + " " + " Course" + c + "\n date" + d;
		
	}
}
