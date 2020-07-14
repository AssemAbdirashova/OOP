package src;

import java.util.ArrayList;

public interface ManageFiles {
	    ArrayList<CourseFile> getFiles();

	    CourseFile getFile(String title);

	    void addFile(CourseFile courseFile);

	    void deleteFile(String title);
}
