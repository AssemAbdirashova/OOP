package src;
import java.io.Serializable;
import java.util.Date;

public class News implements Serializable{
    private Faculty faculty;
    private String title;
    private String text;
    private String sender;
    Date date;
    
    public News(String title, String text, String sender, Date date, Faculty faculty) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.faculty = faculty;
    }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public String toString() {
        String info = super.toString();
        info += "Faculty: " + faculty.toString() + '\n';
        return info;
    }
    
    
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof News)) return false;
        News news = (News) obj;
        return super.equals(obj);
    }

    public int hashCode() { 
    	return super.hashCode();
    	}

	public int getTitle() {
		
		return 0;
	}
}
