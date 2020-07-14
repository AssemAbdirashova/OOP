package src;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;	

	public class Runner {
	    private TypeOfUser mode;
	    private Admin admin;
	    private User user;
	    private Teacher teacher;
	    private Manager manager;
	    private TechSupportGuy executor;
	    private ArrayList<Course> currentCourses;
	    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	    public static ArrayList<Manager> managers = new ArrayList<Manager>();
	    public static ArrayList<TechSupportGuy> executors = new ArrayList<>();
	    public static ArrayList<Student> students = new ArrayList<Student>();
	    public static ArrayList<Course> courses = new ArrayList<Course>();
	    public static ArrayList<News> news = new ArrayList<News>();
		public static ArrayList<CourseFile> courseFiles = new ArrayList<>();

	    private static final Scanner sc = new Scanner(System.in);

	    private static final String PATH = "C:\\Users\\Admin\\eclipse-workspace\\Group Project\\src\\src";
	    private static final String LOG = "log.txt";

	   	
	    public Runner() throws IOException{
	    	saveData();
	    }
	    public void begin() throws IOException {
	        System.out.println("Are you an admin or user?");

	        String ans = sc.nextLine().toLowerCase();

	        if (!(ans.equals("user") || ans.equals("admin"))) return;

	        System.out.println("Enter your login");

	        String login = sc.nextLine().toLowerCase();
	        System.out.println("Enter your password");
	        String password = sc.nextLine();

	        switch (ans) {
	            case "admin":
	                Admintime(login, password);
	                break;
	            case "user":
	                Usertime(login, password);
	                break;
	        }

	        saveData();
	    }
	    private void Admintime(String login, String password) throws IOException {
	        admin = new Admin();

	        if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
	            String ans = "";

	            Runner.writeLog("Admin logged in!");

	            while (!ans.equals("exit")) {
	                System.out.println("Choose the option!");
	                System.out.println("1. Add new user");
	                System.out.println("2. Delete user");
	                System.out.println("3. Show log file");

	                ans = sc.nextLine();

	                switch (ans) {
	                    case "1":
	                        adminAdd();
	                        break;
	                    case "2":
	                        adminRemove();
	                        break;
	                    case "3":
	                        adminLogs();
	                        break;
	                    case "exit":
	                        break;
	                    default:
	                        System.out.println("Invalid option!");
	                        break;
	                }
	            }


	        }
	        else {
	            System.out.println("Invalid login or password!");
	        }
	        saveData();
	    }
	    private void adminAdd() throws IOException {
	        while (true) {
	            System.out.println("Who do you want to add?");
	            System.out.println("1. Student");
	            System.out.println("2. Teacher");
	            System.out.println("3. Manager");
	            System.out.println("4. Executor");

	            String ans = sc.nextLine();
	            TypeOfUser mode;

	            switch (ans) {
	                case "1":
	                    mode = TypeOfUser.STUDENT;
	                    break;
	                case "2":
	                    mode = TypeOfUser.TEACHER;
	                    break;
	                case "3":
	                    mode =  TypeOfUser.MANAGER;
	                    break;
	                case "4":
	                    mode = TypeOfUser.EXECUTOR;
	                    break;
	                case "exit":
	                    return;
	                default:
	                    System.out.println("Invalid option!");
	                    continue;
	            }

	            System.out.println("Enter lastname");

	            String lname = sc.nextLine();

	            System.out.println("Enter firstname");

	            String name = sc.nextLine();

	            System.out.println("Enter login");

	            String login = sc.nextLine();

	            admin.addUser(lname, name, login, mode);
	            saveData();
	        }
	    }
	    private void adminRemove() throws IOException {
	        System.out.println("Enter the login of user you want to delete...");

	        String login = sc.nextLine();

	        if (admin.deleteUser(login)) {
	            System.out.println("Success!");
	        }
	        else {
	            System.out.println("User not found!");
	        }
	        saveData();
	    }

	    private void adminLogs() {
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(PATH + LOG));

	            String line = br.readLine();

	            while (line != null) {
	                System.out.println(line);

	                line = br.readLine();
	            }
	        }
	        catch (IOException e) {
	            System.out.println("input/output exception");
	        }
	    }

	    private void Usertime(String login, String password) throws IOException {
	        ArrayList<User> list = new ArrayList<>();
	        boolean found = false;
	        list.addAll(teachers);
	        list.addAll(students);
	        list.addAll(managers);
	        list.addAll(executors);

	        for (User u: list) {
	            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
	                user = u;
	                found = true;
	                Runner.writeLog("User " + u.getLogin() + " logged in!");
	                switch (u.getClass().toString().split(" ")[1]) {
	                    case "Student":
	                        Studenttime();
	                        break;
	                    case "Teacher":
	                        Teachertime();
	                        break;
	                    case "Manager":
	                        Managertime();
	                        break;
	                    case "Executor":
	                        Executortime();
	                        break;
	                }
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Invalid login or password!");
	        }
	        saveData();
	    }
	    private void Studenttime() {
	        Student student = (Student) user;
	        mode = TypeOfUser.STUDENT;

	        System.out.println("You are logged as student!");

	        System.out.println("Choose the option");
	        System.out.println("1. Courses");
	        System.out.println("2. Transcript");
	        System.out.println("3. News");
	        System.out.println("4. Registration");

	        String ans = sc.nextLine();

	        switch (ans) {
	            case "1":
	                student.getCourses();
	                break;
	            case "2":
	            	//student.viewMarks(c);
	                System.out.println("There is no transcript");
	                break;
	            case "3":
	            	 showNews();
	                break;
	            case "4":
	                System.out.println("Write your Course");
	                Scanner scan = new Scanner(System.in);
	                for(Course c:courses){
	                    if(c.getCourseName().equals(scan.nextLine())){
	                        student.addCourses(c);
	                    }
	                }
	        }
	    }
	    private void Teachertime() {
	        teacher = (Teacher) user;
	        mode = TypeOfUser.TEACHER;

	        currentCourses = teacher.getCourses();

	        String ans = "";

	        System.out.println("You are logged as teacher!");

	        while (!ans.equals("exit")) {
	            System.out.println("Choose the option you want");
	            System.out.println("1. Send Message");
	            System.out.println("2. News");
	            System.out.println("3. Courses");
	            System.out.println("4. Schedule");
	            System.out.println("5. Send order");

	            ans = sc.nextLine();

	            switch (ans) {
	                case "1":
	                    writeMessage();
	                    break;
	                case "2":
	                    showNews();
	                    break;
	                case "3":
	                    teacherCourses();
	                    break;
	                case "4":
	                    showSchedule();
	                    break;
	                case "5":
	                    sendOrder();
	                    break;
	                case "exit":
	                    return;
	                default:
	                    System.out.println("Not valid option!");
	                    break;
	            }
	        }
	    }
	    private void writeMessage() {
	        Employee employee;

	        switch (mode) {
	            case TEACHER:
	                employee = teacher;
	                break;
	            case MANAGER:
	                employee = manager;
	                break;
	            default:
	                return;
	        }

	        System.out.println("Write reciever`s login");
	        String login = sc.nextLine();

	        System.out.println("Write message`s title");
	        String title = sc.nextLine();

	        System.out.println("Write message`s text");
	        String text = sc.nextLine();

	        Order order = new Order(title, text, employee.getLogin(), Calendar.getInstance().getTime());

	        if (employee.sendOrder(order, login)) {
	            System.out.println("Order sent!");
	        }
	        else {
	            System.out.println("Login not found!");
	        }
	    }
	  

	    private void teacherCourses() {
	        String ans = "";

	        while (!ans.equals("exit")) {
	            System.out.println("Your courses:");

	            for (int i = 0; i < currentCourses.size(); ++i) {
	                System.out.println((i + 1) + ". " + currentCourses.get(i).getCourseName());
	            }

	            System.out.println("Select course you want");

	            ans = sc.nextLine();

	            try {
	                int ind = Integer.decode(ans);

	                ind--;

	                if (ind > -1 && ind < currentCourses.size()) {
	                    teacherCourse(ind);
	                }
	                else {
	                    System.out.println("Wrong selection");
	                }
	            }
	            catch (Exception e) {
	                System.out.println("Wrong selection");
	            }
	        }

	    }
	    private void teacherCourse(int ind) {
	        String ans = "";

	        while (!ans.equals("exit")) {
	            System.out.println("Choose the option you want");
	            System.out.println("1. Add file");
	            System.out.println("2. Delete file");
	            System.out.println("3. Show Info");

	            ans = sc.nextLine();

	            switch (ans) {
	                case "1":
	                    teacherAddFile(ind);
	                    break;
	                case "2":
	                    showSchedule();
	                    break;
	               
	                case "3":
	                    System.out.println(currentCourses.get(ind));
	                    break;
	                default:
	                    System.out.println("Not valid option!");
	                    break;
	            }
	        }
	    }

	    private void teacherAddFile(int ind) {
	        System.out.println("Load the file you want to add");

	        System.out.println("What`s its title?");
	        String title = sc.nextLine();

	        System.out.println("What`s its text?");
	        String text = sc.nextLine();

	        CourseFile courseFile = new CourseFile(title, text, teacher.getLogin());

	        currentCourses.get(ind).addFile(courseFile);

	    }

	    private void showSchedule() {
	        System.out.println("NO Schedule");
	    }
	    public static boolean showNews(){
			if(Database.news.size()==0) {
				System.out.println("No news yet...");
				return false;
			}
			for(int i=0; i<Database.news.size(); i++)
				System.out.println(i+1+ ")" + Database.news.get(i));
			return true;
		}
	   
	    
	    private void sendOrder() {
	        System.out.println("Write order you want to send");

	        System.out.println("What`s its title?");
	        String title = sc.nextLine();

	        System.out.println("What`s its text?");
	        String text = sc.nextLine();

	        Order order = new Order(title, text, teacher.getLogin(), Calendar.getInstance().getTime());

	        teacher.sendOrder(order);
	    }
	    private void Managertime() {
	        manager = (Manager) user;
	        mode = TypeOfUser.MANAGER;
	    }
	    private void Executortime() {
	        executor = (TechSupportGuy) user;
	        mode = TypeOfUser.EXECUTOR;

	        String ans = "";

	        System.out.println("You are logged as executor!");

	        while (!ans.equals("exit")) {

	            System.out.println("Choose the option you want");
	            System.out.println("1. News");
	            System.out.println("2. Show new orders");
	            System.out.println("3. Show not done orders");
	            System.out.println("4. Show done orders");
	            System.out.println("5. Show rejected orders");
	            ans = sc.nextLine();

	            switch (ans) {
	                case "1":
	                    showNews();
	                    break;
	                case "2":
	                    executorOrders(orderStatus.NEW);
	                    break;
	                case "3":
	                    executorOrders(orderStatus.NOT_DONE);
	                    break;
	                case "4":
	                    executorOrders(orderStatus.ACCEPTED);
	                    break;
	                case "5":
	                    executorOrders(orderStatus.REJECTED);
	                    break;
	                case "exit":
	                    return;
	                default:
	                    System.out.println("Not valid option!");
	                    break;
	            }
	        }
	    }
	    private void executorOrders(orderStatus status) {
	        ArrayList<Order> orders = executor.getOrders(status);

	        for (int i = 0; i < orders.size(); ++i) {
	            System.out.println((i + 1) + ". " + orders.get(i).getTitle());
	        }
	        String ans = "";

	        System.out.println("Select one order!");

	        while (!ans.equals("exit")) {
	            ans = sc.nextLine();

	            try {
	                int ind = Integer.decode(ans);

	                ind--;

	                if (ind > -1 && ind < orders.size()) {
	                    executorOrder(orders.get(ind));
	                }
	                else {
	                    System.out.println("Wrong selection");
	                }
	            }
	            catch (Exception e) {
	                if (ans.equals("exit")) {
	                    break;
	                }

	                System.out.println("Wrong selection");
	            }
	        }
	    }
	    private void executorOrder(Order order) throws IOException {
	        System.out.println(order);

	        String ans = "";

	        if (order.getStatus() == orderStatus.NEW) {
	            System.out.println("Accept this order or reject?");

	            ans = sc.nextLine().toLowerCase();

	            switch (ans) {
	                case "accept":
	                    order.setStatus(orderStatus.ACCEPTED);
	                    break;
	                case "reject":
	                    order.setStatus(orderStatus.REJECTED);
	                    break;
	                default:
	                    System.out.println("Not valid operation!");
	                    break;
	            }
	        }

	        else if (order.getStatus() == orderStatus.NOT_DONE) {
	            System.out.println("Have this order done?");

	            ans = sc.nextLine().toLowerCase();

	            switch (ans) {
	                case "yes":
	                    order.setStatus(orderStatus.ACCEPTED);
	                case "no":
	                    break;
	                default:
	                    System.out.println("Not valid operation!");
	                    break;
	            }
	        }
	        Database.serOrders();
	    }
	    private static void writeLog(String msg) throws IOException {
	    		final String DATE_PATTERN = "dd.MM.yy HH:mm";
	        
	            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH + LOG, true));

	            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PATTERN);

	            bw.write(dtf.format(LocalDateTime.now())+ " - " + msg + "\n");

	            bw.flush();
	            bw.close();       
	    	}
	        
	    private static void saveData() throws IOException {
	    	Database.serStudents();
			Database.serCourses();
			Database.serManagers();
			Database.serOrders();
			Database.serNews();
			Database.serExecutors();
			Database.serTeachers();
			Database.serCourseFiles();			
	    }	    
}
