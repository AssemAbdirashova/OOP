package src;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements ManageFiles, Serializable{
    private String courseName;
    private int credits;
    private Faculty f;
    private ArrayList<CourseFile> files;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Mark> marks;

    public Course(String courseName,int credits,ArrayList<Teacher> teachers , Faculty faculty){
        this.courseName = courseName;
        this.credits = credits;
        this.teachers = teachers;
        this.f = faculty;
    }
    public String getCourseName() { 
    	return courseName; 
    	}
    public void setCourseName(String courseName) { 
    	this.courseName = courseName; 
    	}

    public ArrayList<Teacher> getTeachers() { 
    	return teachers; 
    	}
    public void addTeacher(Teacher t) { 
    	teachers.add(t); 
    	}
    public void deleteTeacher(Teacher t) { 
    	teachers.remove(t); 
    	}

    public ArrayList<Student> getStudents() { 
    	return students; 
    	}
    public ArrayList<Mark> getMarks(){
    	return marks;
    }
    public void addStudent(Student s) { 
    	students.add(s); 
    	}
    
    private void deleteStudent(Student s) { 
    	students.remove(s); 
    	}

    public int getCredits() { 
    	return credits; 
    	}
    public void setCredits(int credits) { 
    	this.credits = credits; 
    	}

    public ArrayList<CourseFile> getFiles(){
        return files;
    }

    public CourseFile getFile(String title) {
        CourseFile file = null;
        for(CourseFile f:files){
            if(f.getTitle().equals(title)){
                file = f;
                break;
            }
        }
        return file;
    }

    public void addFile(CourseFile courseFile) {
        files.add(courseFile);
    }

    public void deleteFile(String title) {
        for(CourseFile f:files){
            if(f.getTitle().equals(title)){
                files.remove(f);
                break;
            }
        }

    }
    
    public String toString() {
    	return "CourseName" + courseName + "credits" + credits; 
    }
	public void addMark(Mark m) {
		marks.add(m);
	}
	public Faculty getF() {
		return f;
	}
	public void setF(Faculty f) {
		this.f = f;
	}
}
