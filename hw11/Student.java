package gradebook;

/**
 * Student class
 * 
 * @author Chao
 * @version 2014-04-10
 */
public class Student {

    /** Student's username */
    String username;
    /** Student's firstName */
    String firstName;
    /** Student's lastName */
    String lastName;
    /** Student's advisor */
    String advisor;
    /** Student's graduation year */
    int graduationYear;

    /**
     * 
     * @param username
     *            String username
     * @param firstName
     *            String firstname
     * @param lastName
     *            String lastName
     * @param advisor
     *            String advisor name
     * @param graduationYear
     *            int represeent graduationYear
     */
    Student(String username, String firstName, String lastName, String advisor,
            int graduationYear) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.advisor = advisor;
        this.graduationYear = graduationYear;

    }

    /**
     * Empty Constructor
     */
    public Student() {
        super();
    }

    /**
     * getter method for username
     * 
     * @return String usernmae
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter method for username
     * 
     * @param username
     *            String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter method for firstName
     * 
     * @return string firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter method for firstName
     * 
     * @param firstName
     *            string
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter method for lastName
     * 
     * @return String lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter method for lastName
     * 
     * @param lastName
     *            String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter method for advisor
     * 
     * @return String advisor
     */
    public String getAdvisor() {
        return advisor;
    }

    /**
     * setter method for advisor
     * 
     * @param advisor
     *            String
     */
    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    /**
     * getter method for graduationYear
     * 
     * @return int graduationYear
     */
    public int getGraduationYear() {
        return graduationYear;
    }

    /**
     * setter method for graduationYear
     * 
     * @param graduationYear
     *            int
     */
    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    /**
     * Rewrite equals method
     * 
     * @param o
     *            Object
     * @return boolean
     */
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student s = (Student) o;
            return this.username.equals(s.username);
        }
        return false;
    }

    /**
     * Rewrite hashCode method
     * 
     * @return int
     */
    public int hashCode() {
        return this.username.hashCode();
    }

}
