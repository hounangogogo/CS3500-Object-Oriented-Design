package gradebook;

/**
 * Assignment class
 * 
 * @author Chao
 * @version 2014-04-10
 */
public class Assignment {

    /** Assignment name */
    String name;
    /** Assignment total podoubles */
    double totalPoints;
    /** percent of grade of this assignment */
    double percentOfGrade;

    /**
     * Assignment Constructor
     * 
     * @param name
     *            String name
     * @param totalPoints
     *            double totalPoints
     * @param percentOfGrade
     *            double
     */
    Assignment(String name, double totalPoints, double percentOfGrade) {
        this.name = name;
        this.totalPoints = totalPoints;
        this.percentOfGrade = percentOfGrade;
    }

    /**
     * Empty Constructor
     */
    public Assignment() {
        super();
    }

    /**
     * getter method for name
     * 
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for name
     * 
     * @param name
     *            String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for totalPoints
     * 
     * @return double totalPoints
     */
    public double getTotalPoints() {
        return totalPoints;
    }

    /**
     * setter method for totalPodoubles
     * 
     * @param totalPoints
     *            double
     */
    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    /**
     * getter method for percentOfGrade
     * 
     * @return double percent of grade
     */
    public double getPercentOfGrade() {
        return percentOfGrade;
    }

    /**
     * setter method for percentOfGrade
     * 
     * @param percentOfGrade
     *            double percent
     */
    public void setPercentOfGrade(double percentOfGrade) {
        this.percentOfGrade = percentOfGrade;
    }

}
