package src;
public abstract class Person {
	private String lastName,firstName;
	private Gender gender;
	public Person(){}

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.getLastName() + " " + this.getFirstName();
    }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
	public Person(String l, String f){
		lastName  = l;
		firstName = f;
		gender = null;
	}
	
	public String toString() {
		return "Lastname:" + lastName + " Firstname:" + firstName;
	}
	
	public boolean equals(Object o){
		if(o == this) return true;
		if(o==null || o.getClass()!=this.getClass()) return false;
		Person p = (Person)o;
		return lastName.equals(p.lastName) && firstName.equals(p.firstName);
	}
    
    public int hashCode(){
		return 17+31*lastName.hashCode() + 25*firstName.hashCode();
	}
    
   
    
}
