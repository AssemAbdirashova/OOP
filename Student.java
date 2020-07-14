package src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Student extends User implements ManageCourse, Serializable{
	    private String id;
	    private LevelofStudy lvl;
	    private Faculty faculty;
	    private int yearOfStudy;
	    private double gpa;
	    private HashMap<Teacher, Integer> ratingList;
	    private ArrayList<Course> courses;
	    Schedule s;
	    private HashMap<Course, Mark> marks = new HashMap<Course, Mark>();
	    private HashMap<Course, Vector<ATTENDANCE>> attestation = new HashMap<Course, Vector<ATTENDANCE>>();

	    public Student (String lastName, String firstName, String login,String id, int y, Faculty f , LevelofStudy l) {
	        super(lastName, firstName, login);
	        this.yearOfStudy = y;
	        this.id = id;
	        this.faculty = f;
	        this.lvl = l;
	        courses = new ArrayList<Course>();
	    }

	    public Student(String lastName, String name, String login) {
	    	super(lastName, name, login);
		}

		public String getId() { 
	    	return id; 
	    	}

	    public int getYearOfStudy() { 
	    	return yearOfStudy; 
	    	}

	    public void incrYearOfStudy() { 
	    	yearOfStudy++; 
	    	}

	    @Override
	    public ArrayList<Course> getCourses() {
	        ArrayList<Course> curCourses = new ArrayList<>();

	        for (Course c: .courses) {
	            for (Course s: courses) {
	                if (c.equals(s) && c.getStudents().contains(this)){
	                    curCourses.add(c);
	                }
	            }
	        }
	        return curCourses;
	    }

	 
	    public String getCourseInfo(Course course) {
	        return course.getFile(course.getCourseName()).toString();
	    }

	    public void addCourses(Course course) {
	        courses.add(course);
	    }

	    public void deleteCourse(Course course) {
	    	courses.remove(course);
	    }
	    public ArrayList<Mark> viewMarks(Course c) {
	    	return c.getMarks();
	    }
	    
	    public ArrayList<Teacher> viewInfoaboutTeacher(Course c){
			return c.getTeachers();
	    }

	    public String toString() {
	        String degreeInfo, facultyInfo;
	        try {
	            degreeInfo = lvl.toString() + ", ";
	        }
	        catch (Exception e) {
	            degreeInfo = "";
	        }
	        try {
	            facultyInfo = faculty.toString() + " ";
	        }
	        catch (Exception e) {
	            facultyInfo = "";
	        }
	        String info = "Education: " + facultyInfo + degreeInfo + yearOfStudy + " course\n";
	        String idInfo = "Personal ID: " + id + '\n';
	        return "Student\n" + super.toString() + idInfo + info;
	    }

	    @Override
	    	public boolean equals(Object obj) {
	    	    if (obj == this) return true;
	    	    if (!(obj instanceof Student)) return false;
	    	    Student u = (Student) obj;
	    	    return u.yearOfStudy==yearOfStudy && super.equals(u)
	    	      && u.gpa==gpa && u.faculty.equals(faculty)
	    	      &&  u.lvl.equals(lvl);
	    }
	    	

	    @Override
	    public int hashCode() { 
	    	return (int) (super.hashCode() + faculty.hashCode() + lvl.hashCode() + gpa*5 + yearOfStudy*6); 
	    	
	    }
	    
	    public String viewSchedule() {
	    	return s.toString();
	    }
	    
	    public double getGpa(double score) {
	    	return Mark.toGpa(score);
	    }
	    
	    public void rateTeacher(Teacher t) {
	    	int RatingScore;
	    	System.out.println("Please rate from 1 to 10 this Teacher: " + t);
	    	Scanner sc = new Scanner(System.in);
	    	RatingScore = sc.nextInt();
	    	ratingList.put(t, RatingScore);
	    	System.out.println("Thank you");
	    	
	    }
	    
	    public Faculty getFaculty() {
	    	return faculty;
	    }
	    
	    public void registerForCourse(Course c) {
	    	Manager.approveRegistration(this, c);
	    }
	    
	    public void putAttendance(Course c, ATTENDANCE a) {
	    	Vector<ATTENDANCE> b;
	    	if(attestation.get(c) != null) b = attestation.get(c);
	    	else b = new Vector<ATTENDANCE>();	
	    	b.add(a);
	    	attestation.put(c, b);
	    }
}
