package util;

public class Grade {
    private int score;
    private String letterGrade;
    //Constructor to create as requested, the object Grade.
    public Grade(int score) {
        this.score = score;
        //Creates a new String findLetter whose purpose is to match the inputted user score to a letter grade
        //Which will be stored within the object Grade
        String findLetter;
        if(score >= 90) {
            findLetter = "A";
        } else if(score >= 85) {
            findLetter = "A-";
        } else if(score >= 80) {
            findLetter = "B+";
        } else if(score >= 75) {
            findLetter = "B";
        } else if(score >= 70) {
            findLetter = "B-";
        } else if(score >= 65) {
            findLetter = "C+";
        } else if(score >= 60) {
            findLetter = "C";
        } else if(score >= 50) {
            findLetter = "D";
        } else {
            findLetter = "F";
        }
        this.letterGrade = findLetter;
    }

    //Setters and Getters
    public int getScore() {
        return score;
    }

    public String getLetterGrade() {
        return letterGrade;
    }
}
