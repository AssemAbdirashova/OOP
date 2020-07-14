package src;

import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		if(new File("courses").exists()) {Database.desCourses();}
		if(new File("students").exists()) {Database.desStudents();}
		if(new File("executors").exists()) {Database.desExecutors();}
		if(new File("teachers").exists()) {Database.desTeachers();}
		if(new File("courseFiles").exists()) {Database.desCourseFiles();}
		if(new File("managers").exists()) {Database.desManagers();}
		if(new File("news").exists()) {Database.desNews();}
		if(new File("orders").exists()) {Database.desOrders();}
		Runner r = new Runner();
		r.begin();
	}
}
