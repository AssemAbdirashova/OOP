package src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;

public class Teacher extends Employee implements ManageCourse, Serializable{
    private ArrayList<Course> courses;
    private LevelofTeacher level;
    private Faculty faculty;
	private Mark mark;
  
    public Teacher (String lastName, String firstName, String login) {
        super(lastName, firstName, login);
        
    }

    public LevelofTeacher setLevelofTeacher() {
    	return level;
    }
    
    public Faculty getFaculty() { return faculty; }

    public void sendOrder(Order order){
        TechSupportGuy.orders.add(order);
        TechSupportGuy.saveOrders();
    }

    public String viewCourse(){
        String s="";
        for (int i=0;  i< courses.size() ; i++){
            s+= courses.get(i).toString();
        }
        return s;
    }

    @Override
    public void addCourses(Course course) {
        courses.add(course);
    }

    @Override
    public void deleteCourse(Course course) {
        courses.remove(course);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Teacher) {
            Teacher other = (Teacher) obj;
            if (!courses.equals(other.getCourses())) return false;
            else if (!level.equals(other.getLevelofTeacher())) return false;
            else if (!faculty.equals(other.faculty)) return false;
            else return super.equals(other);
        }
        else {
            return false;
        }
    }
    private LevelofTeacher getLevelofTeacher() {
		return level;
	}

	@Override
    public String toString() {
        return super.toString();
    }

	@Override
	public String getCourseInfo(Course course) {
        for (Course c: Runner.courses) {
            if (c.getCourseName().equals(course.getCourseName()) && c.getTeachers().contains(this)) {
                course = c;
                break;
            }
        }
        return course.getFile(course.getCourseName()).toString();
	}
	
	public void putMark(Course c,Student student, Mark m){
		for(int i = 0; i< courses.size(); ++i) {
			for(int j = 0; j < c.getStudents().size(); ++j) {
				if(courses.get(i).equals(c) && c.getStudents().get(j).equals(student)) {
					this.mark = m;
					c.addMark(m);
				}
			}
		}		
	}
	
   
    public void addCourseFile(String title, String text, String owner){
        CourseFile courseFile = new CourseFile(title, text, owner);
    }
    public void deleteCourseFile(String name){
        for (int i=0 ; i < Runner.courseFiles.size() ; i++){
            if(Runner.courseFiles.get(i).getTitle().equals(name)){
                Runner.courseFiles.get(i).setTitle("");
                Runner.courseFiles.get(i).setText("");
                Runner.courseFiles.get(i).setOwner("");
                
            }
        }
    }
    public String infAboutStudent(Student student){
        for (int i=0 ; i< Runner.students.size() ; i++){
            if(Runner.students.get(i).equals(student)){
                return Runner.students.get(i).toString();
            }
        }
        return "Not Found";
    }
    
    public int getSalary(LevelofTeacher lvl) {
		if(this.level == LevelofTeacher.TUITOR) {
			return 10;
		}
		else if(this.level == LevelofTeacher.SENIOR_LECTOR) {
			return 20;
		}
		else if(this.level == LevelofTeacher.PROFESSOR) {
			return 30;
		}
		else 
			return 40;
	}

    

	@Override
	public ArrayList<Course> getCourses() {
		
	    ArrayList<Course> curCourses = new ArrayList<>();

        for (Course c: Runner.courses) {
            for (Course s: courses) {
                if (c.equals(s) && c.getTeachers().contains(this)){
                    curCourses.add(c);
                }
            }
        }
        return curCourses;
    }
	public ArrayList<Mark> viewMarks(Course c){
		return c.getMarks();
	}
	
	/*
	public boolean Attendance(Course c , Student s) {
		for(int i = 0; i < c.getStudents().size(); ++i) {
			if(c.getStudents().contains(s))
				return true;
		}
		return false;
	}
	*/
	
}