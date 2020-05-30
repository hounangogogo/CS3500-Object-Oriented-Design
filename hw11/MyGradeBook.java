package gradebook;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * MyGradeBook Class
 * @author Chao
 * @version 2014-04-10
 */
public class MyGradeBook {

    /** HashMap storage storing information about student and their grades */
    HashMap<Student, ArrayList<Grade>> studentMap =
            new HashMap<Student, ArrayList<Grade>>();

    /** ArrayList storage storing information about assignments */
    ArrayList<Assignment> assignments = new ArrayList<Assignment>();


    /** Empty Constructor */
    public MyGradeBook() {
        super();
    }

    /** 
     * getters method for Hashmap
     * @return a HashMap
     */
    public HashMap<Student, ArrayList<Grade>> getCheckGrade() {
        return studentMap;
    }

    /**
     * setters method for HashMap
     * @param checkGrade HashMap<Student, Grade> 
     */
    public void setStudentMap(HashMap<Student, ArrayList<Grade>> checkGrade) {
        this.studentMap = checkGrade;
    }

    /**
     * getters method for list of assignments
     * @return an ArrayList<Assignment>
     */
    public ArrayList<Assignment> getAssighments() {
        return assignments;
    }

    /**
     * setters method for list of assignments
     * @param assignments ArrayList<Assignment>
     */
    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    /**
     * Factory method to construct an empty MyGradebook
     * 
     * @return an empty MyGradeBook
     */
    public static MyGradeBook initialize() {
        MyGradeBook  mgb = new MyGradeBook();
        return mgb;
    }

    /**
     * Factory method to construct a MyGradebook that contains the grade book
     * from filename
     * 
     * @param filename
     *            the filename for the file that contains the initial grade
     *            book, which is formatted like initial.txt
     * @return a MyGradebook that contains the grade book from filename
     */
    public static MyGradeBook initializeWithFile(String filename) {
        MyGradeBook mgb = new MyGradeBook();
        File file = new File(filename);
        ArrayList<Assignment> alist = new ArrayList<Assignment>();
        ArrayList<String> slist = new ArrayList<String>();

        HashMap<Student, ArrayList<Grade>> grademap =
                new HashMap<Student, ArrayList<Grade>>();

        try {
            Scanner input = new Scanner(file);
            input.useDelimiter("\t+");
            if (input.hasNext()) {
                String line1 = input.next();
                slist.add(line1);
            }

            if (input.hasNextLine()) {
                String line2 = input.nextLine();
                Scanner lineScan2 = new Scanner(line2);
                lineScan2.useDelimiter("\t+");
                Scanner lineScan21 = new Scanner(line2);
                lineScan21.useDelimiter("\t+");
                Scanner lineScan22 = new Scanner(line2);
                lineScan22.useDelimiter("\t+");
                while (lineScan2.hasNext()) {

                    Assignment a = new Assignment();
                    a.setName(lineScan2.next());
                    alist.add(a);
                }

                mgb.setAssignments(alist);

                if (input.hasNextLine()) {
                    String line3 = input.nextLine();
                    Scanner lineScan3 = new Scanner(line3);
                    Scanner lineScan31 = new Scanner(line3);
                    alist.clear();
                    while (lineScan3.hasNextDouble()) {
                        Assignment a = new Assignment();
                        if (lineScan21.hasNext()) {
                            a.setName(lineScan21.next());
                        }
                        a.setTotalPoints(lineScan3.nextDouble());
                        alist.add(a);
                    }
                    mgb.setAssignments(alist);

                    if (input.hasNextLine()) {
                        String line4 = input.nextLine();
                        Scanner lineScan4 = new Scanner(line4);
                        alist.clear();
                        while (lineScan4.hasNextDouble()) {

                            Assignment a = new Assignment();
                            if (lineScan22.hasNext()) {
                                a.setName(lineScan22.next()); 
                            }
                            if (lineScan31.hasNextDouble()) {
                                a.setTotalPoints(lineScan31.nextDouble());
                            }
                            a.setPercentOfGrade(lineScan4.nextDouble());
                            alist.add(a);
                        }
                        mgb.setAssignments(alist);


                        while (input.hasNextLine()) {
                            ArrayList<Grade> glist = new ArrayList<Grade>();
                            String line = input.nextLine();
                            Scanner lineScan = new Scanner(line);
                            lineScan.useDelimiter("\t+");
                            Student s = new Student();
                            if (lineScan.hasNext()) {
                                String username = lineScan.next();
                                s.setUsername(username);
                            }
                            if (lineScan.hasNext()) {
                                String fname = lineScan.next();
                                s.setFirstName(fname);
                            }
                            if (lineScan.hasNext()) {
                                String lname = lineScan.next();
                                s.setLastName(lname);
                            }
                            if (lineScan.hasNext()) {
                                String adv = lineScan.next();
                                s.setAdvisor(adv);
                            }
                            if (lineScan.hasNextInt()) {
                                int grad = lineScan.nextInt();
                                s.setGraduationYear(grad);
                            }




                            while (lineScan.hasNextDouble()) {
                                Grade grade = new Grade();
                                double d = lineScan.nextDouble();
                                grade.setScore(d);
                                glist.add(grade);
                            }

                            for (int index = 0; index < glist.size(); index++) {
                                Grade g = glist.get(index);
                                g.setAssignmentName(alist.get(index).getName());
                                glist.set(index, g);
                            }

                            grademap.put(s, glist);

                        }
                    }
                }
            }
            mgb.setStudentMap(grademap);





        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return mgb;
    }
    /**
     * Factory method to construct a MyGradebook that contains the grade book
     * from startingString
     * 
     * @param startingString
     *            String that contains the initial grade book, which is
     *            formatted like initial.txt
     * @return a MyGradebook that contains the grade book from startingString
     *
     */
    public static MyGradeBook initializeWithString(
            String startingString) {

        ArrayList<String> slist = new ArrayList<String>();
        MyGradeBook mgb = new MyGradeBook();
        ArrayList<Assignment> alist = new ArrayList<Assignment>();
        HashMap<Student, ArrayList<Grade>> grademap =
                new HashMap<Student, ArrayList<Grade>>();

        Scanner input = new Scanner(startingString);
        input.useDelimiter("\t+");
        String line1 = input.next();
        slist.add(line1);
        if (input.hasNextLine()) {
            String line2 = input.nextLine();
            Scanner lineScan2 = new Scanner(line2);
            lineScan2.useDelimiter("\t+");
            Scanner lineScan21 = new Scanner(line2);
            lineScan21.useDelimiter("\t+");
            Scanner lineScan22 = new Scanner(line2);
            lineScan22.useDelimiter("\t+");
            while (lineScan2.hasNext()) {

                Assignment a = new Assignment();
                a.setName(lineScan2.next());
                alist.add(a);
            }

            mgb.setAssignments(alist);

            if (input.hasNextLine()) {
                String line3 = input.nextLine();
                Scanner lineScan3 = new Scanner(line3);
                Scanner lineScan31 = new Scanner(line3);
                alist.clear();
                while (lineScan3.hasNextDouble()) {
                    Assignment a = new Assignment();
                    if (lineScan21.hasNext()) {
                        a.setName(lineScan21.next());
                    }
                    a.setTotalPoints(lineScan3.nextDouble());
                    alist.add(a);
                }
                mgb.setAssignments(alist);

                if (input.hasNextLine()) {
                    String line4 = input.nextLine();
                    Scanner lineScan4 = new Scanner(line4);
                    alist.clear();
                    while (lineScan4.hasNextDouble()) {

                        Assignment a = new Assignment();
                        if (lineScan22.hasNext()) {
                            a.setName(lineScan22.next()); 
                        }
                        if (lineScan31.hasNextDouble()) {
                            a.setTotalPoints(lineScan31.nextDouble());
                        }
                        a.setPercentOfGrade(lineScan4.nextDouble());
                        alist.add(a);
                    }
                    mgb.setAssignments(alist);


                    while (input.hasNextLine()) {
                        ArrayList<Grade> glist = new ArrayList<Grade>();
                        String line = input.nextLine();
                        Scanner lineScan = new Scanner(line);
                        lineScan.useDelimiter("\t+");
                        Student s = new Student();
                        if (lineScan.hasNext()) {
                            String username = lineScan.next();
                            s.setUsername(username);
                        }
                        if (lineScan.hasNext()) {
                            String fname = lineScan.next();
                            s.setFirstName(fname);
                        }
                        if (lineScan.hasNext()) {
                            String lname = lineScan.next();
                            s.setLastName(lname);
                        }
                        if (lineScan.hasNext()) {
                            String adv = lineScan.next();
                            s.setAdvisor(adv);
                        }
                        if (lineScan.hasNextInt()) {
                            int grad = lineScan.nextInt();
                            s.setGraduationYear(grad);
                        }




                        while (lineScan.hasNextDouble()) {
                            Grade grade = new Grade();
                            double d = lineScan.nextDouble();
                            grade.setScore(d);
                            glist.add(grade);
                        }

                        for (int index = 0; index < glist.size(); index++) {
                            Grade g = glist.get(index);
                            g.setAssignmentName(alist.get(index).getName());
                            glist.set(index, g);
                        }

                        grademap.put(s, glist);

                    }
                }
            }
        }
        mgb.setStudentMap(grademap);
        return mgb;
    }

    /**
     * Add to the state of this grade book---new assignments, new students, new
     * grades---by processing filename
     * 
     * @param filename
     *            the filename for a file that contains information that will be
     *            added to the grade book. The file could contain several
     *            different types of information---new assignments, new
     *            students, new grades. The file will be formatted like
     *            addAssignments.txt, addStudents.txt, gradesForAssignment1.txt,
     *            and gradesForStudent.txt.
     */
    public void processFile(String filename) {
        ArrayList<String> slist = new ArrayList<String>();
        File file = new File(filename);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();

                slist.add(line);
                if (line.equals("ASSIGNMENT")) {
                    String name = input.nextLine();
                    double total = 0;
                    double per = 0.0;
                    if (input.hasNextDouble()) {
                        total = input.nextDouble(); 
                    }
                    if (input.hasNextDouble()) {
                        per = input.nextDouble(); 
                    }
                    Assignment a = new Assignment(name, total, per);
                    this.assignments.add(a);
                }

                if (line.equals("STUDENT")) {
                    String username = "";
                    String fname = "";
                    String lname = "";
                    String adv = "";
                    int grad = 0;
                    if (input.hasNextLine()) {
                        username = input.nextLine();
                    }
                    if (input.hasNextLine()) {
                        fname = input.nextLine();
                    }
                    lname = input.nextLine();
                    if (input.hasNextLine()) {
                        adv = input.nextLine();
                    }
                    if (input.hasNextInt()) {
                        grad = input.nextInt();
                    }
                    Student s = new Student(username, fname, lname, adv, grad);
                    this.addStudent(s);
                }

                if (line.equals("GRADES_FOR_ASSIGNMENT")) {
                    String assignment = input.nextLine();
                    while (input.hasNextLine()) {
                        String name = input.nextLine();
                        while (input.hasNextDouble()) {
                            double score = input.nextDouble();
                            this.addGrade(assignment, name, score);
                        }
                    }

                }

                if (line.equals("GRADES_FOR_STUDENT")) {
                    String username = input.nextLine();
                    while (input.hasNextLine()) {
                        String assignment = input.nextLine();
                        while (input.hasNextDouble()) {
                            double score = input.nextDouble();
                            this.addGrade(assignment, username, score);
                        }
                    }
                }


            }


        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add to the state of this grade book---new assignments, new students, new
     * grades---by processing additionalString
     * 
     * @param additionalString
     *            String that contains information that will be added to the
     *            grade book. The String could contain several different types
     *            of information---new assignments, new students, new grades.
     *            The String will be formatted like addAssignments.txt,
     *            addStudents.txt, gradesForAssignment1.txt, and
     *            gradesForStudent.txt.
     * @throws FileNotFoundException 
     */
    public void processString(String additionalString) 
        throws FileNotFoundException {


        ArrayList<String> slist = new ArrayList<String>();
        Scanner input = new Scanner(additionalString);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            slist.add(line);
            if (line.equals("ASSIGNMENT")) {
                String name = input.nextLine();
                double total = 0;
                double per = 0.0;
                if (input.hasNextDouble()) {
                    total = input.nextDouble(); 
                }
                if (input.hasNextDouble()) {
                    per = input.nextDouble(); 
                }
                Assignment a = new Assignment(name, total, per);
                this.assignments.add(a);
            }

            if (line.equals("STUDENT")) {
                String username = "";
                String fname = "";
                String lname = "";
                String adv = "";
                int grad = 0;
                if (input.hasNextLine()) {
                    username = input.nextLine();
                }
                if (input.hasNextLine()) {
                    fname = input.nextLine();
                }
                lname = input.nextLine();
                if (input.hasNextLine()) {
                    adv = input.nextLine();
                }
                if (input.hasNextInt()) {
                    grad = input.nextInt();
                }
                Student s = new Student(username, fname, lname, adv, grad);
                this.addStudent(s);
            }

            if (line.equals("GRADES_FOR_ASSIGNMENT")) {
                String assignment = input.nextLine();
                while (input.hasNextLine()) {
                    String name = input.nextLine();
                    while (input.hasNextDouble()) {
                        double score = input.nextDouble();
                        this.addGrade(assignment, name, score);
                    }
                }

            }

            if (line.equals("GRADES_FOR_STUDENT")) {
                String username = input.nextLine();
                while (input.hasNextLine()) {
                    String assignment = input.nextLine();
                    while (input.hasNextDouble()) {
                        double score = input.nextDouble();
                        this.addGrade(assignment, username, score);
                    }
                }
            }


        }
    }

    /**
     * To get one specifc student from hashmap storage, 
     * given student's username
     * @param username student's username
     * @return a Student
     */
    public Student getStudent(String username) {
        Student s = new Student();
        s.setUsername("Unset");
        for (Student student : studentMap.keySet()) {
            if (username.equals(student.getUsername())) {
                s.setUsername(username);
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                s.setAdvisor(student.getAdvisor());
                s.setGraduationYear(student.getGraduationYear());
            }

        }
        if (s.username.equals(username)) {
            return s;
        }
        else {
            throw new NoSuchElementException("Invalid username");
        }

    }


    /**
     * Add the given student to HashMap storage
     * @param student the given student
     */
    public void addStudent(Student student) {
        ArrayList<Grade> grades = new ArrayList<Grade>();

        studentMap.put(student, grades);
    }

    /**
     * update the grade information, given assignement name, 
     * student's username and new grade score
     * @param assignment assignment name
     * @param username student's username
     * @param newGrade new grade score
     */
    protected void updateGrade(String assignment, 
            String username, double newGrade) {
        ArrayList<Grade> prevgrade = studentMap.get(this.getStudent(username));
        for (Grade grade: prevgrade) {
            if (grade.getAssignmentName().equals(assignment)) {
                grade.setScore(newGrade);
            }
        }
        studentMap.put(getStudent(username), prevgrade);


    }

    /**
     * add new Grade information to the HashMap storage, 
     * given assignment name, student's username and new 
     * grade score
     * @param assignment assignment name
     * @param username student's username
     * @param score new score
     */
    protected void addGrade(String assignment, String username, double score) {
        Grade grade = new Grade(assignment, score, "");
        ArrayList<Grade> gradelist = studentMap.get(this.getStudent(username));
        gradelist.add(grade);
        studentMap.put(getStudent(username), gradelist);

    }


    /**
     * add new assignment information to ArrayList storage,
     * given new assignment
     * @param assignment new assignment
     */
    public void addAssignment(Assignment assignment) {
        if (assignments.size() == 0) {
            assignments.add(assignment);
        }
        else {
            for (int index = 0; index < assignments.size(); index++) {
                if (assignments.get(index).getName().equals(
                        assignment.getName())) {
                    assignments.set(index, assignment);
                }
                else {
                    assignments.add(assignment);
                }
            }
        }
    }


    /**
     * Changes the assignment (named assignmentName) grade for student (whose
     * username is equal to username) to newGrade
     * 
     * @param assignmentName
     *            name of the assignment
     * @param username
     *            username for the student
     * @param newGrade
     *            the new grade for the given assignment and student
     * @return whether there was a grade to change. Returns true if the given
     *         assignment/student combination exists, returns false otherwise
     */
    public boolean changeGrade(String assignmentName,
            String username, double newGrade) {
        Student s = new Student();
        s.setUsername(username);
        boolean result = false;
        if (studentMap.containsKey(s)) {
            for (Grade grade: studentMap.get(getStudent(username))) {
                if (grade.getAssignmentName().equals(assignmentName)) {
                    result = true;
                    this.updateGrade(assignmentName, username, newGrade);
                }
            }
            return result;
        }

        else {
            return result;
        }
    }





    /**
     * Calculates the average across all students for a given assignment
     * 
     * @param assignment assignment name
     * @return the average across all students for assignmentName
     */
    public double average(String assignment) {

        ArrayList<Student> students = new ArrayList<Student>();
        students.addAll(studentMap.keySet());
        double i = 0;

        for (Student s: students) {
            for (Grade grade: studentMap.get(s)) {
                if (grade.getAssignmentName().equals(assignment)) {
                    i = i + grade.getScore();
                }
            }
        }
        i = i / students.size();
        return i;

    }

    /**
     * Calculates the median across all students for a given assignment
     * 
     * @param assignment Name
     *            name of the assignment
     * @return the median across all students for assignmentName
     */
    public double median(String assignment) {
        ArrayList<Double> scores = new ArrayList<Double>();
        ArrayList<Student> students = new ArrayList<Student>();
        students.addAll(studentMap.keySet());


        for (Student s: students) {
            for (Grade grade: studentMap.get(s)) {
                if (grade.getAssignmentName().equals(assignment)) {
                    scores.add(grade.getScore());
                }
            }
        }
        Collections.sort(scores);

        int middle = scores.size() / 2;

        if (scores.size() % 2 == 1) {
            return scores.get(middle);
        } 
        else {
            return (scores.get(middle - 1) + scores.get(middle)) / 2.0;

        }
    }

    /**
     * Calculates the min across all students for a given assignment
     * 
     * @param assignment 
     *            name of the assignment
     * @return the min across all students for assignmentName
     */
    public double min(String assignment) {
        ArrayList<Double> scores = new ArrayList<Double>();
        ArrayList<Student> students = new ArrayList<Student>();
        students.addAll(studentMap.keySet());

        for (Student s: students) {
            for (Grade grade: studentMap.get(s)) {
                if (grade.getAssignmentName().equals(assignment)) {
                    scores.add(grade.getScore());
                }
            }
        }
        Collections.sort(scores);

        return scores.get(0);
    }

    /**
     * Calculates the max across all students for a given assignment
     * 
     * @param assignment Name
     *            name of the assignment
     * @return the max across all students for assignmentName
     */
    public double max(String assignment) {
        ArrayList<Double> scores = new ArrayList<Double>();
        ArrayList<Student> students = new ArrayList<Student>();
        students.addAll(studentMap.keySet());

        for (Student s: students) {
            for (Grade grade: studentMap.get(s)) {
                if (grade.getAssignmentName().equals(assignment)) {
                    scores.add(grade.getScore());
                }
            }
        }
        Collections.sort(scores);

        return scores.get(scores.size() - 1);
    }


    /**
     * given assignment name, get the percent of grade of 
     * this assignment.
     * @param assignment String assignment name
     * @return a double representing percentage
     */
    protected double getPercent(String assignment) {
        double p = 0.0;

        for (Assignment a: assignments) {
            if (a.getName().equals(assignment)) {
                p = a.getPercentOfGrade();
            }
        }
        return p;
    }

    /**
     * given assignment name, get the total points of
     * this assignment.
     * @param assignment String assignment name
     * @return an int representing total points
     */
    protected double getTotal(String assignment) {
        double total = 0;

        for (Assignment a: assignments) {
            if (a.getName().equals(assignment)) {
                total = a.getTotalPoints();
            }
        }
        return total;
    }

    /**
     * given student's username, get the current percent of grade
     * of this student in this course
     * @param username the given student's username
     * @return an douple representing current percent of grade
     */
    protected double currentPercent(String username) {

        double currentP = 0.0;

        for (Grade grade: studentMap.get(getStudent(username))) {
            currentP = currentP + this.getPercent(
                    grade.getAssignmentName());
        }

        return currentP;
    }

    /**
     * Calculates the current grade for the given student
     * 
     * @param username
     *            username for the student
     * @return the current grade for student with username. The current grade is
     *         calculated based on the current assignment grades, assignment
     *         total points, assignment percent of semester. The current grade
     *         for a student is the sum of the relative assignment grades
     *         divided by the current percent of semester time 100. Since all
     *         grades may not currently be entered, we have to divide by the
     *         current percent. The relative assignment grade is the student's
     *         assignment grade divide by total point value for the assignment
     *         times the percent of semester.
     */
    public double currentGrade(String username) {
        double cg = 0;
        double currentPercent = this.currentPercent(username);

        for (Grade grade: studentMap.get(getStudent(username))) {
            cg = cg + (grade.getScore() / 
                    this.getTotal(grade.getAssignmentName())
                    * this.getPercent(grade.getAssignmentName())) / 
                    currentPercent;

        }

        cg = cg * 100;
        cg = Math.round(cg * 1e13) / 1e13;
        return cg;
    }

    /**
     * Calculates the current grade for all students
     * 
     * @return HashMap of the current grades for all students. The key of the
     *         HashMap is the username of the student. The value is the current
     *         grade for the associated student. 
     *         The current grade is calculated
     *         based on the current assignment grades, assignment total points,
     *         assignment percent of semester. The current grade for a student
     *         is the sum of the relative assignment grades divided by the
     *         current percent of semester time 100. Since all grades may not
     *         currently be entered, we have to divide by the current percent.
     *         The relative assignment grade is the student's assignment grade
     *         divide by total point value for the assignment times the percent
     *         of semester.
     */
    public HashMap<String, Double> currentGrades() {
        HashMap<String, Double> allgrade = new HashMap<String, Double>();

        for (Student student : studentMap.keySet()) {
            allgrade.put(student.getUsername(), 
                    currentGrade(student.getUsername()));

        }
        return allgrade;

    }


    /**
     * Provides the grade earned by the given student for the given assignment
     * 
     * @param assignment 
     *            name of the assignment
     * @param username
     *            username for the student
     * @return the grade earned by username for assignmentName
     */
    public double assignmentGrade(String assignment, String username) {
        double cg = 0.0;
        for (Grade grade : studentMap.get(getStudent(username))) {
            if (grade.getAssignmentName().equals(assignment)) {
                cg = grade.getScore();
            }
        }
        return cg;
    }

    /**
     * Provide a String that contains the current grades of all students in the
     * course
     * 
     * @return a String that contains the current grades of all students in the
     *         course. The String should be formatted like
     *         currentGrades.txt---CURRENT_GRADES heading and each row: username
     *         followed by tab and current grade. The usernames will be listed
     *         alphabetically.
     */
    public String outputCurrentGrades() {

        ArrayList<Student> students = new ArrayList<Student>();
        students.addAll(studentMap.keySet());

        String title = "CURRENT_GRADES" + "\n";
        for (Student student : sort(students)) {
            title = title + student.getUsername() + "\t" 
                    + currentGrade(student.getUsername()) + "\n";
        }

        return title;
    }

    /**
     * 
     * @param studentlist student list
     * @return sorted student list
     */
    protected ArrayList<Student> sort(ArrayList<Student> studentlist) {
        ArrayList<String> namelist = new ArrayList<String>();
        for (Student student : studentlist) {
            namelist.add(student.getUsername());
        }

        Collections.sort(namelist);

        ArrayList<Student> sortedlist = new ArrayList<Student>();
        for (String username : namelist) {
            sortedlist.add(getStudent(username));

        }
        return sortedlist;
    }

    /**
     * Provide a String that contains the current grades of the given student
     * 
     * @param username
     *            username for student
     * @return a String that contains the current grades of username. The String
     *         should be formatted like studentGrades.txt---STUDENT_GRADES
     *         heading, student info, dividers, each assignment (assignment name
     *         followed by tab and assignment grade), and current grade.
     *         Assignments are to remain in the same order as given.
     */
    public String outputStudentGrades(String username) {
        Student s = null;
        for (Student student : studentMap.keySet()) {
            if (username.equals(student.getUsername())) {
                s = student;
            }
        }

        String assign = "";
        for (Grade grade : studentMap.get(getStudent(username))) {
            assign = assign + "\r\n" + grade.getAssignmentName()
                    + "\t" + grade.getScore();

        }

        return "STUDENT_GRADES" + "\r\n" + username + "\r\n" + s.getFirstName()
                + "\r\n" + s.getLastName() + "\r\n" + s.getAdvisor() + "\r\n"
                + s.getGraduationYear() + "\r\n" + "----" + assign + "\r\n"
                + "----" + "\r\n" + "CURRENT GRADE" + "\t"
                + currentGrade(username);
    }

    /**
     * Provide a String that contains the assignment grades of all students in
     * the course for the given assignment
     * 
     * @param assignName
     *            name of the assignment
     * @return a String that contains the assignment grades of all students in
     *         the course for assignName. The String should be formatted like
     *         assignmentGrade.txt---ASSIGNMENT_GRADES heading, assignment info,
     *         dividers, each student (username followed by tab and assignment
     *         grade), and assignment stats. The usernames will be listed
     *         alphabetically while assignments are to remain in the same order
     *         as given.
     */
    public String outputAssignmentGrades(String assignName) {
        Assignment assig = null;
        for (Assignment a : assignments) {
            if (a.getName().equals(assignName)) {
                assig = a;
            }
        }

        ArrayList<Student> students = new ArrayList<Student>();
        students.addAll(studentMap.keySet());
        String ss = "";

        for (Student student : sort(students)) {
            for (Grade grade : studentMap.get(student)) {
                if (grade.getAssignmentName().equals(assignName)) {
                    ss = ss + "\r\n" + student.getUsername() + "\t" + 
                            grade.getScore();
                }
            }
        }

        return "ASSIGNMENT_GRADES" + "\r\n" + assig.getName() + "\r\n"
            + assig.getTotalPoints() 
            + "\r\n" + assig.getPercentOfGrade() + "\r\n"
            + "----" + ss + "\r\n" + "----" + "\r\n"
            + "STATS" + "\r\n" + "Average" + "\t"
            + average(assignName) + "\r\n" + "Median" + "\t"
            + median(assignName) + "\r\n" + "Max" + "\t" + max(assignName)
            + "\r\n" + "Min" + "\t" + min(assignName);

    }

    /**
     * Provide a String that contains the current grade book. This String could
     * be used to initialize a new grade book.
     * 
     * @return a String that contains the current grade book. This String could
     *         be used to initialize a new grade book. The String should be
     *         formatted like gradebook.txt. The usernames will be listed
     *         alphabetically.
     */
    public String outputGradebook() {
        ArrayList<Student> students = new ArrayList<Student>();
        if (studentMap.size() != 0) {
            students.addAll(studentMap.keySet());


            String title = "GRADEBOOK";

            if (assignments.size() != 0) {
                title = title + "\r\n" + "\t" + "\t" + "\t" + "\t"
                        + this.getAllAssignmentName();
            }


            for (Student student : sort(students)) {

                title = title + "\r\n" + student.getUsername() + "\t"
                        + student.getFirstName() + "\t" + student.getLastName()
                        + "\t" + student.getAdvisor() + "\t"
                        + student.getGraduationYear() 
                        + this.getgrades(student.getUsername());
            }
            return title;
        }
        else {
            return "GRADEBOOK";
        }



    }

    /**
     * 
     * @param name assignment name
     * @return String infomation about assignment
     */
    protected String getgrades(String name) {
        String assign = "";
        if (assignments.size() != 0) {
            for (Assignment a : assignments) {

                assign = assign + "\t" + this.assignmentGrade(a.getName(), 
                        name);

            }
            return assign;
        }
        return "";

    }

    /**
     * 
     * @return all assignment name
     */
    protected String getAllAssignmentName() {
        String aname = "";
        String totalpoints = "";
        String percentage = "";
        if (assignments.size() != 0) {
            for (Assignment assign : assignments) {
                aname = aname  + "\t" + assign.getName();
            }
            for (Assignment assign : assignments) {
                totalpoints = totalpoints  + "\t" + assign.getTotalPoints();
            }
            for (Assignment assign : assignments) {
                percentage = percentage  + "\t" + assign.percentOfGrade;
            }
            return aname + "\r\n" + "\t" + "\t" + "\t" + "\t" 
                + totalpoints + "\r\n" + "\t" + "\t" + "\t" + "\t" + percentage;
        }
        else {
            return "";
        }

    }


    /**
     * output an text file using the given filename, which
     * contains all information of this gradebook
     * @param filename String filename 
     * @throws FileNotFoundException 
     */
    public void outputGradeBookFile(String filename)
        throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(filename + ".txt"));
        output.println(this.outputGradebook());
    }























}

