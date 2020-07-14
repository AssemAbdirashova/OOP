package src;
import java.util.ArrayList;

public interface ManageCourse {

    ArrayList<Course> getCourses();

    String getCourseInfo(Course course);        

    void addCourses(Course course);

    void deleteCourse(Course course);
}