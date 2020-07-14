package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Admin implements Serializable {
    private String login;
    private String password;

    public String getLogin() { return login; }

    public String getPassword() { return password; }


    public Admin() {
        getData();
    }

    private void getData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Admin\\eclipse-workspace\\Group Project\\admin.ser"));

            String firstLine = br.readLine();
            String secondLine = br.readLine();

            String r_login, r_password;

            try {
                r_login = firstLine;
                r_password = secondLine;

                login = r_login;
                password = r_password;
            }
            catch (Exception e) {
                System.out.println("Wrong data in " + "admin.ser");
            }

        }
        catch (IOException e) {
            System.out.println("Cannot read from " + "admin.ser");
        }
    }

    public void addUser(String lastName, String name, String newLogin, TypeOfUser mode) {
    	Scanner sc = new Scanner(System.in);
        switch (mode) {
            case STUDENT:
            	System.out.println("Please, enter new student's id");
            	String id;
            	id = sc.next();
            	System.out.println("Please, enter new student's year of study");
            	int y = sc.nextInt();
            	System.out.println("Please, enter new student's Faculty");
            	String f = sc.next();
            	Faculty ff = null ;
            	if(f.toString().toUpperCase()==Faculty.BS.toString()) {
            		ff = ff.BS;
            	}
            	else if(f.toString().toUpperCase()==Faculty.FIT.toString()) {
            		ff = ff.FIT;
            	}
            	System.out.println("Please, enter new student's Level of Study");
            	LevelofStudy l = null ;
            	String ll = sc.next();
            	if(ll.toString().toUpperCase()==LevelofStudy.BACHELOR.toString()) {
            		l = l.BACHELOR;
            	}
            	else if(ll.toString().toUpperCase()==LevelofStudy.FOUNDATION.toString()) {
            		l = l.FOUNDATION;
            	}            		
            	
            	else if(ll.toString().toUpperCase()==LevelofStudy.MASTER.toString()) {
            		l = l.MASTER;
            	}
            	else if(ll.toString().toUpperCase()==LevelofStudy.PhD.toString()) {
            		l = l.PhD;
            	}
            	addStudent(lastName, name, newLogin,id , y, ff , l);	
            	
			
                break;
            case TEACHER:
                addTeacher(lastName, name, newLogin);
                break;
            case MANAGER:
            	System.out.println("Please, enter new Manager's Faculty");
            	String faculty = sc.next();
            	Faculty fa = null ;
            	if(fa.toString().toUpperCase()==Faculty.BS.toString()) {
            		fa = fa.BS;
            	}
            	else if(fa.toString().toUpperCase()==Faculty.FIT.toString()) {
            		fa = fa.FIT;
            	}
                addManager(lastName, name, newLogin,fa);
                break;
            case EXECUTOR:
                addExecutor(lastName, name, newLogin);
                break;
        }
    }

    

	public boolean deleteUser(String login) {
        for (User u: Runner.students) {
            if (u.getLogin().equals(login)) {
                Runner.students.remove(u);

                return true;
            }
        }
        for (User u: Runner.managers) {
            if (u.getLogin().equals(login)) {
                Runner.managers.remove(u);

                return true;
            }
        }
        for (User u: Runner.executors) {
            if (u.getLogin().equals(login)) {
                Runner.executors.remove(u);

                return true;
            }
        }
        for (User u: Runner.teachers) {
            if (u.getLogin().equals(login)) {
                Runner.teachers.remove(u);

                return true;
            }
        }

        return false;
    }

    private void addExecutor(String lastName, String name, String newLogin) {
        TechSupportGuy executor = new TechSupportGuy(lastName, name, newLogin);

        if (!Runner.executors.contains(executor)) {
            Runner.executors.add(executor);
        }
        else {
            System.out.println(executor.getClass().toString().split(" ")[1] + " already exists!");
        }
    }

    private void addManager(String lastName, String name, String newLogin , Faculty F) {
        Manager manager = new Manager(lastName, name, newLogin, F);

        if (!Runner.managers.contains(manager)) {
           Runner.managers.add(manager);
        }
        else {
            System.out.println(manager.getClass().toString().split(" ")[1] + " already exists!");
        }
    }

    private void addTeacher(String lastName, String name, String newLogin) {
        Teacher teacher = new Teacher(lastName, name, newLogin);
        Runner.teachers.add(teacher);
    }

    private void addStudent(String lastName, String Name, String login, String id, int year, Faculty f, LevelofStudy l) {
        Student student = new Student(lastName, Name, login, id, year, f , l);

        if (!Runner.students.contains(student)) {
            Runner.students.add(student);
        }
        else {
            System.out.println(student.getClass().toString().split(" ")[1] + " already exists!");
        }
    }
    
    
    
    public String toString() { return "Admin login: " + login + '\n'; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Admin)) return false;
        Admin a = (Admin) obj;
        return a.password.equals(password) && a.login.equals(login);
    }

    @Override
    public int hashCode() { return login.hashCode(); }
}
