package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;
    //Constructs the object Student with a String firstName and lastName, an int PID, and object Grade.
    public Student(String firstName, String lastName, int pid, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }
    //Setter and Getter
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPid() {
        return pid;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    //Can be used to display the students PID along with their score.
    public void displayInfo() {
        System.out.printf("| PID: %-7d\t\tScore: %-2d\n", getPid(), getGrade().getScore());
    }
    //Can be used to display the students PID along with their letterGrade.
    public void displayInfoLetter() {
        System.out.printf("| PID: %-7d\t\tScore: %-2s\n", getPid(), getGrade().getLetterGrade());
    }
}
