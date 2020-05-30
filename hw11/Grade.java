package gradebook;

/**
 * Grade class
 * 
 * @author Chao
 * @version 2014-04-10
 */
public class Grade {

    /** Assignment name */
    String assignmentName;
    /** Assignment score */
    double score;
    /** Instructor's comment */
    String comment = "";

    /**
     * Grade Constructor
     * 
     * @param assignmentName
     *            String
     * @param score
     *            double
     * @param comment
     *            String
     */
    public Grade(String assignmentName, double score, String comment) {
        super();
        this.assignmentName = assignmentName;
        this.score = score;
        this.comment = comment;
    }

    /**
     * Empty Constructor
     */
    public Grade() {
        super();
    }

    /**
     * getter method for AssignmentName
     * 
     * @return assignmentName
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * setter method for AssignmentName
     * 
     * @param assignmentName
     *            String assignmentName
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     * getter method for score
     * 
     * @return double score
     */
    public double getScore() {
        return score;
    }

    /**
     * setter method for score
     * 
     * @param score
     *            double score
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * getter method for comment
     * 
     * @return string comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * setter method for comment
     * 
     * @param comment
     *            String comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

}
