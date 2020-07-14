package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Database {
	public static Vector<Course> courses = new Vector<Course>();
	public static Vector<Student> students  = new Vector<Student>();
	public static Vector<Teacher> teachers = new Vector<Teacher>();
    public static Vector<Manager> managers = new Vector<Manager>();
    public static Vector<TechSupportGuy> executors = new Vector<>();
    public static Vector<News> news = new Vector<News>();
	public static Vector<CourseFile> courseFiles = new Vector<>();
	public static Vector<Order> orders = new Vector<>();
	static FileInputStream fis;
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static ObjectInputStream oin;
	public static void desCourses() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("courses");
		oin = new ObjectInputStream(fis);
		courses = (Vector<Course>) oin.readObject();
	}
	public static void serCourses()throws IOException{
		fos = new FileOutputStream("courses");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.close();
	}
	public  static void desStudents() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("students");
		oin = new ObjectInputStream(fis);
		students = (Vector<Student>) oin.readObject();
	}
	
	public static void serStudents()throws IOException{
		fos = new FileOutputStream("students");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(students);
		oos.close();
	}
	public static void desTeachers() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("teachers");
		oin = new ObjectInputStream(fis);
		teachers = (Vector<Teacher>) oin.readObject();
	}
	public static void serTeachers()throws IOException{
		fos = new FileOutputStream("teachers");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(teachers);
		oos.close();
	}
	public  static void desManagers() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("managers");
		oin = new ObjectInputStream(fis);
		managers = (Vector<Manager>) oin.readObject();
	}
	
	public static void serManagers()throws IOException{
		fos = new FileOutputStream("managers");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(managers);
		oos.close();
	}
	public static void desExecutors() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("executors");
		oin = new ObjectInputStream(fis);
		executors = (Vector<TechSupportGuy>) oin.readObject();
	}
	public static void serExecutors()throws IOException{
		fos = new FileOutputStream("executors");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(executors);
		oos.close();
	}
	public  static void desNews() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("news");
		oin = new ObjectInputStream(fis);
		news = (Vector<News>) oin.readObject();
	}
	
	public static void serNews()throws IOException{
		fos = new FileOutputStream("news");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(news);
		oos.close();
	}
	public static void desOrders() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("orders");
		oin = new ObjectInputStream(fis);
		orders = (Vector<Order>) oin.readObject();
	}
	public static void serOrders()throws IOException{
		fos = new FileOutputStream("orders");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(orders);
		oos.close();
	}
	public  static void desCourseFiles() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("courseFiles");
		oin = new ObjectInputStream(fis);
		courseFiles = (Vector<CourseFile>) oin.readObject();
	}
	
	public static void serCourseFiles()throws IOException{
		fos = new FileOutputStream("courseFiles");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(courseFiles);
		oos.close();
	}
}
