package src;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employee implements Serializable,ManageNews,Searching{
    private Faculty faculty;
    public Manager(String lastname,String firstname,String login, Faculty faculty){
        super(lastname,firstname,login);
        this.faculty = faculty;
    }
    public void sendOrder(Order order) throws IOException{
        Database.orders.add(order);
        Database.serOrders();
    }
	public Faculty getFaculty(){
        return this.faculty;
    }
    public void setFaculty(Faculty faculty){
        this.faculty = faculty;
    }
    public static String assignSchedule(Teacher t , Date d , Course c) {
    	String s = "";
    	Schedule ss  = new Schedule(c,s ,d);
    	return "Teacher"  + t +ss.toString();
    }
    public static boolean approveRegistration(Student s, Course c) {
    	int cnt = 0 ;
    	if(s.getFaculty() == c.getF()) {
    		for(int i = 0; i < s.getCourses().size(); ++i) {
      			cnt += s.getCourses().get(i).getCredits();
    			if(cnt <= 21) return true;
    		}
    	}
    	return false;
    } 

    public void addNews(News news) {
        Runner.news.add(news);

    }

    public void deleteNews(News news) {
        Runner.news.remove(news);
    }

    @Override
    public Course findCourse(String courseName) {
    	 Course course = null;
         for (Course c: Runner.courses) {
             if (c.getCourseName().equals(courseName)) {
                 course = c;
                 break;
             }
         }
         return course;
    }

    @Override
    public Student findStudent(String login) {
        Student student = null;
        for(Student s : Runner.students){
            if(s.getLogin().equals(login)){
                student = s;
                break;
            }
        }
        return student;
    }

    @Override
    public Teacher findTeacher(String login) {
        Teacher teacher = null;

        for(Teacher t:Runner.teachers){
            if(t.getLogin().equals(login)){
                teacher = t;
                break;
            }
        }
        return teacher;
    }
}
