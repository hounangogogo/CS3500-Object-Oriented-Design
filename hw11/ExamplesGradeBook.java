package gradebook;

import java.util.ArrayList;
import java.util.HashMap;

import tester.Tester;

/**
 * Method to test all the method
 * 
 * @author Haonan Zhao
 * @version 2014-04-11
 */
public class ExamplesGradeBook {
    /** represent empty grade book **/
    MyGradeBook mgb = new MyGradeBook();

    /**
     * return a empty grade book
     */
    void cleanBook() {
        mgb = new MyGradeBook();
    }

    /** represent grade1 **/
    Grade g1fors1 = new Grade("A1", 80.2, "too bad");
    /** represent grade1 **/
    Grade g1fors2 = new Grade("A1", 81.2, "bad");
    /** represent grade1 **/
    Grade g1fors3 = new Grade("A1", 82.2, "bad");
    /** represent grade1 **/
    Grade g1fors4 = new Grade("A1", 83.2, "too bad");
    /** represent grade1 **/
    Grade g2fors1 = new Grade("A2", 84.2, "too bad");
    /** represent grade1 **/
    Grade g2fors2 = new Grade("A2", 85.2, "bad");
    /** represent grade1 **/
    Grade g2fors3 = new Grade("A2", 86.2, "bad");
    /** represent grade1 **/
    Grade g2fors4 = new Grade("A2", 87.2, "too bad");

    /** represent grade1 **/
    Grade gg1 = new Grade("A6", 87.2, "too bad");


    /** represent grade1 **/
    ArrayList<Grade> gf1 = new ArrayList<Grade>();
    /** represent grade1 **/
    ArrayList<Grade> gf2 = new ArrayList<Grade>();
    /** represent grade1 **/
    ArrayList<Grade> gf3 = new ArrayList<Grade>();
    /** represent grade1 **/
    ArrayList<Grade> gf4 = new ArrayList<Grade>();

    /** represent grade1 **/
    ArrayList<Grade> gf6 = new ArrayList<Grade>();

    /**
     * represent empty grade
     */
    void cleanGrade() {
        gf1 = new ArrayList<Grade>();
        gf2 = new ArrayList<Grade>();
        gf3 = new ArrayList<Grade>();
        gf4 = new ArrayList<Grade>();
        gf6 = new ArrayList<Grade>();
    }

    /**
     * represent add grade
     */
    void intiGrade() {
        gf1.add(g1fors1);
        gf1.add(g2fors1);

        gf2.add(g1fors2);
        gf2.add(g2fors2);

        gf3.add(g1fors3);
        gf3.add(g2fors3);

        gf4.add(g1fors4);
        gf4.add(g2fors4);

        gf6.add(gg1);
    }

    // ///////////////////////////////////////////////////////////////////
    /** represent grade1 **/
    Assignment a1 = new Assignment("A1", 100, 0.5);
    /** represent grade1 **/
    Assignment a2 = new Assignment("A2", 100, 0.5);
    /** represent grade1 **/
    Assignment a100 = new Assignment("A100", 1000, 0.2);
    /** represent grade1 **/
    ArrayList<Assignment> assign = new ArrayList<Assignment>();

    /**
     * represent empty assignment
     */
    void cleanAssignment() {
        a1 = new Assignment("A1", 100, 0.5);
        a2 = new Assignment("A2", 100, 0.5);
    }

    /**
     * represent add assignment
     */
    void intiAssignment() {
        assign.add(a1);
        assign.add(a2);
    }

    // /////////////////////////////////////////////////////////////////
    /** represent grade1 **/
    Student s1 = new Student("visop", "zhen", "wei", "JB", 2015);
    /** represent grade1 **/
    Student s2 = new Student("kenghuo", "chen", "cheng", "JB1", 2016);
    /** represent grade1 **/
    Student s3 = new Student("fan", "fan", "yuecan", "JB", 2015);
    /** represent grade1 **/
    Student s4 = new Student("goubi", "zai", "xika", "JB3", 2016);

    /** represent grade1 **/
    Student addone = new Student("sb", "s", "b", "mei", 2033);


    /** represent grade1 **/
    Student e1 = new Student("qq", "q", "q", "q", 2043);

    /** represent grade1 **/
    HashMap<Student, ArrayList<Grade>> gb =
            new HashMap<Student, ArrayList<Grade>>();

    /**
     * represent added gradebook
     */
    void intiGradeBook() {
        gb.put(s1, gf1);
        gb.put(s2, gf2);
        gb.put(s3, gf3);
        gb.put(s4, gf4);

    }

    /**
     * 
     * @param t
     *            tester
     */
    void testgetCheckGrade(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();

        mgb.setStudentMap(gb);
        t.checkExpect(mgb.getCheckGrade(), gb);

    }

    /**
     * 
     * @param t
     *            tester
     */
    void testgetAssignments(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setAssignments(assign);
        t.checkExpect(mgb.getAssighments(), assign);
    }

    // ///////////////////////////////////////////////////
    /**
     * 
     * @param t
     *            tester
     */
    void testgetStudent(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        t.checkExpect(mgb.getStudent("visop"), s1);

    }

    /**
     * 
     * @param t
     *            tester
     */
    void testaddStudent(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.addStudent(addone);
        t.checkExpect(mgb.getStudent("sb"), addone);

    }

    /**
     * 
     * @param t
     *            tester
     */
    void testupdateGrade(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        mgb.updateGrade("A1", "visop", 0.0001);
        t.checkExpect(mgb.assignmentGrade("A1", "visop"), 0.0001);

    }


    /**
     * 
     * @param t
     *            tester
     */
    void testaddGrade(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        mgb.addGrade("A1000", "visop", 200.1);
        t.checkExpect(mgb.assignmentGrade("A1000", "visop"), 200.1);

    }

    /**
     * 
     * @param t
     *            tester
     */
    void testaddAssignment(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        mgb.addAssignment(a100);
        t.checkExpect(mgb.getAssighments().contains(a100), true);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testchangeGrade(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        t.checkExpect(mgb.changeGrade("A100", "visop", 3.4), false);
        t.checkExpect(mgb.changeGrade("A1", "visop", 3.4), true);

    }

    /**
     * 
     * @param t
     *            tester
     */
    void testaverage(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setAssignments(assign);

        mgb.setStudentMap(gb);
        t.checkExpect(mgb.average("A2"), 85.7);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testMedin(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        mgb.setAssignments(assign);

        t.checkExpect(mgb.median("A1"), 81.7);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testmin(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        mgb.setAssignments(assign);

        t.checkExpect(mgb.min("A2"), 84.2);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testmax(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        mgb.setAssignments(assign);

        t.checkExpect(mgb.max("A1"), 83.2);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testpercentage(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setStudentMap(gb);
        mgb.setAssignments(assign);

        t.checkExpect(mgb.getPercent("A1"), 0.5);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testgetTotal(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setAssignments(assign);
        mgb.setStudentMap(gb);
        t.checkExpect(mgb.getTotal("A2"), 100.0);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testcurrentGrade(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setAssignments(assign);
        mgb.setStudentMap(gb);
        t.checkExpect(mgb.currentGrade("fan"), 84.2);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testcurrentPercent(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setAssignments(assign);
        mgb.setStudentMap(gb);
        t.checkExpect(mgb.currentPercent("fan"), 1.0);

    }

    /**
     * 
     * @param t
     *            tester
     */
    void testcurrentGrades(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setAssignments(assign);
        mgb.setStudentMap(gb);

        t.checkExpect(mgb.currentGrades().size(), 4);
    }

    /**
     * 
     * @param t
     *            tester
     */
    void testassignmentGrade(Tester t) {
        cleanBook();
        cleanGrade();
        cleanAssignment();
        intiGrade();
        intiAssignment();
        intiGradeBook();
        mgb.setAssignments(assign);
        mgb.setStudentMap(gb);

        t.checkExpect(mgb.assignmentGrade("A1", "fan"), 82.2);
    }




    /**
     * represent student 9
     */
    Student s9 = new Student("aa", "bb", "cc", "dd", 2222);

    /**
     * method to test set and get student
     * @param t tester
     */
    void testgetsetstudent(Tester t) {
        t.checkExpect(s9.getUsername().equals("aa"), true);
        t.checkExpect(s9.getFirstName().equals("bb"), true);
        t.checkExpect(s9.getLastName().equals("cc"), true);
        t.checkExpect(s9.getGraduationYear(), 2222);
        t.checkExpect(s9.getAdvisor().equals("dd"), true);
        s9.setUsername("wangba");
        t.checkExpect(s9.getUsername().equals("wangba"), true);

        s9.setFirstName("qqq");
        t.checkExpect(s9.getFirstName().equals("qqq"), true);

        s9.setLastName("www");
        t.checkExpect(s9.getLastName().equals("www"), true);

        s9.setGraduationYear(3333);
        t.checkExpect(s9.getGraduationYear() == 3333);

        s9.setAdvisor("goushi");
        t.checkExpect(s9.getAdvisor().equals("goushi"));


    }


    /** represent grade1 **/
    Assignment a9 = new Assignment("A9", 100, 0.5);

    /**
     * method to test assignment
     * @param t tester 
     */
    void testgetsetAssignment(Tester t) {
        t.checkExpect(a9.getName().equals("A9"), true);
        t.checkExpect(a9.getPercentOfGrade() == 0.5);
        t.checkExpect(a9.getTotalPoints(), 100.0);

        a9.setName("A99");
        t.checkExpect(a9.getName().equals("A99"), true);

        a9.setPercentOfGrade(0.9);
        t.checkExpect(a9.getPercentOfGrade() == 0.9, true);

        a9.setTotalPoints(999);
        t.checkExpect(a9.getTotalPoints(), 999.0);


    }

    /**represent grade */
    Grade g9 = new Grade("g333", 90.7, "tooo bad");
    /**
     * 
     * @param t tester 
     */
    void testgetsetGrade(Tester t) {
        t.checkExpect(g9.getAssignmentName(), "g333");
        t.checkExpect(g9.getComment(), "tooo bad");
        t.checkExpect(g9.getScore(), 90.7);


        g9.setScore(89.9);
        t.checkExpect(g9.getScore(), 89.9);

        g9.setAssignmentName("g99999");
        t.checkExpect(g9.getAssignmentName(), "g99999");


        g9.setComment("ku");
        t.checkExpect(g9.getComment(), "ku");


    }

    /** represent grade1 **/
    Student stu = new Student("rrr", "ddd", "fff", "ccc", 2015);
    /** represent grade1 **/
    ArrayList<Student> arrystudent = new ArrayList<Student>();
    
    /**
     * represent empty student
     */
    void empstu() {
        arrystudent = new ArrayList<Student>();
        
    }
    
    
    /** represent grade1 **/
    Assignment asss = new Assignment("A99", 100, 0.5);
    /** represent grade1 **/
    ArrayList<Assignment> arryass = new ArrayList<Assignment>();
    
    /**
     * represent empty student
     */
    void empass() {
        arryass = new ArrayList<Assignment>();
        
    }
    
    
    /** represent grad*/
    Grade ggg1 = new Grade("A99", 87.2, "too bad");
    /** represent grad*/
    ArrayList<Grade> arraygrade = new ArrayList<Grade>();

    /**
     * represent empty student
     */
    void empgrade() {
        arraygrade = new ArrayList<Grade>();

        
    }
    
   
    
    /** represent empty grade book **/
    MyGradeBook mlgb = new MyGradeBook();
    
    /**
     * represent empty student
     */
    void empbook() {
        mlgb = new MyGradeBook();
        
        
    }
    
    /** represent grade1 **/
    HashMap<Student, ArrayList<Grade>> gradb =
            new HashMap<Student, ArrayList<Grade>>();

    /**
     * represent addall
     */
    void addall() {
        arrystudent.add(stu);
        arryass.add(asss);
        arraygrade.add(ggg1);
        
        gradb.put(stu, arraygrade);
    }
    
    
    /**
     * represent currentgrade
     * @param t tester
     */
    void testoutputCurrentGrades(Tester t) {
        empbook();
        empgrade();
        empass();
        empstu();
        addall();
        mlgb.setAssignments(arryass);
        mlgb.setStudentMap(gradb);
        t.checkExpect(mlgb.outputCurrentGrades(), 
                "CURRENT_GRADES" + "\n" + "rrr" + "\t" + 87.2 + "\n");

        
    }
    
    
    /**
     * represent testsort
     * @param t tester
     */
    void testsort(Tester t) {
        empbook();
        empgrade();
        empass();
        empstu();
        addall();
        mlgb.setAssignments(arryass);
        mlgb.setStudentMap(gradb);
        mlgb.setStudentMap(gradb);
        t.checkExpect(mlgb.sort(arrystudent), arrystudent);
    }
    
    
    /**
     * represent outputstudentgrade
     * @param t tester
     */
    void testoutputStudentGrades(Tester t) {
        empbook();
        empgrade();
        empass();
        empstu();
        addall();
        mlgb.setAssignments(arryass);
        mlgb.setStudentMap(gradb);        
        mlgb.setStudentMap(gradb);
        t.checkExpect(mlgb.outputStudentGrades("rrr"),
                "STUDENT_GRADES" + "\r\n" + "rrr" + "\r\n" + "ddd"
                + "\r\n" + "fff" + "\r\n" + "ccc" + "\r\n"
                + 2015 + "\r\n" + "----" + "\r\n" + "A99"
                + "\t" + 87.2 + "\r\n"
                + "----" + "\r\n" + "CURRENT GRADE" + "\t"
                + 87.2);
    }
    
    
    /**
     * 
     * @param t tester
     */
    void testoutassignmentGrade(Tester t) {
        empbook();
        empgrade();
        empass();
        empstu();
        addall();
        mlgb.setAssignments(arryass);
        mlgb.setStudentMap(gradb);        
        mlgb.setStudentMap(gradb);
        t.checkExpect(mlgb.outputAssignmentGrades("A99"), 
                "ASSIGNMENT_GRADES" + "\r\n" + "A99" + "\r\n"
                + 100.0
                + "\r\n" + 0.5 + "\r\n"
                + "----" + "\r\n" + "rrr" + "\t" + 
                87.2 + "\r\n" + "----" + "\r\n"
                + "STATS" + "\r\n" + "Average" + "\t"
                + 87.2 + "\r\n" + "Median" + "\t"
                + 87.2 + "\r\n" + "Max" + "\t" + 87.2
                + "\r\n" + "Min" + "\t" + 87.2);

    }
    
    
    
    /**
     * 
     * @param t tester
     */
    void testgetgrades(Tester t) {
        empbook();
        empgrade();
        empass();
        empstu();
        addall();
        mlgb.setAssignments(arryass);
        mlgb.setStudentMap(gradb);        
        mlgb.setStudentMap(gradb);
        
        t.checkExpect(mlgb.getgrades("rrr"), "\t" + 87.2);
        
    }
    
    
    
    /**
     * 
     * @param t tester
     */
    void testgetAllAssignmentName(Tester t) {
        empbook();
        empgrade();
        empass();
        empstu();
        addall();
        mlgb.setAssignments(arryass);
        mlgb.setStudentMap(gradb);        
        mlgb.setStudentMap(gradb);
        t.checkExpect(mlgb.getAllAssignmentName(),
                "\t" + "A99" +  "\r\n" + "\t" 
            + "\t" + "\t" + "\t" + "\t" + 100.0 
            + "\r\n" + "\t" + "\t" + "\t" + "\t" + "\t" + 0.5);

    }
}