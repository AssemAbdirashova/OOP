package src;

public abstract class User extends Person {
	private String login;
    private String password;
  
    public User(String lastName, String firstName, String login) {
        super(lastName, firstName);
        this.login = login;
        password = defaultPassword;
    }

    public static String defaultPassword = "111";

    public String getLogin() { return login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }    

    public String toString() {
        return super.toString() + "Intranet login: " + login + '\n';
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        User u = (User) obj;
        return  super.equals(u) && u.login.equals(login);
    }
    
    public int hashCode() {
    	return super.hashCode() +  login.hashCode()*8 + password.hashCode()*4;
    }
}
