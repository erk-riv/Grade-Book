package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Gradebook {
    //Creates and initializes the ArrayList "listOfStudents".
    private ArrayList<Student> listOfStudents = new ArrayList<Student>();
    //Allows for main to save the Objects created their into this ArrayList
    public void addElement(Student element) {
        listOfStudents.add(element);
    }
    //Verifies the Min Score using an ArrayList that stores location (Integer) and once the lowest value is assigned
    //to location, we will then call displayInfo on the list of students with that letter grade.
    public void minScore() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }
        Arrays.sort(scores);
        int minGrade = scores[0];
        System.out.println("================================");
        System.out.printf("| Lowest Score: %-2d\n", minGrade);
        int j = 0;
        ArrayList<Integer> location = new ArrayList<Integer>();
        for (Student s : listOfStudents) {
            if(s.getGrade().getScore() == minGrade) {
                location.add(j);
            }
            j++;
        }
        System.out.println("--------------------------------");
        System.out.println("| Students With Lowest Score");
        System.out.println("--------------------------------");
        for (Integer finLocation: location) {
            listOfStudents.get(finLocation).displayInfo();
        }
        System.out.println("--------------------------------");
    }
    //Verifies the Max Score using an ArrayList that stores location (Integer) and once the highest value is assigned
    //to location, we will then call displayInfo on the list of students with that letter grade.
    public void maxScore() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }
        Arrays.sort(scores);
        int maxGrade = scores[scores.length - 1];
        System.out.println("================================");
        System.out.printf("| Highest Score: %-2d\n", maxGrade);
        int j = 0;
        ArrayList<Integer> location = new ArrayList<>();
        for (Student s : listOfStudents) {
            if (s.getGrade().getScore() == maxGrade) {
                location.add(j);
            }
            j++;
        }
        System.out.println("--------------------------------");
        System.out.println("| Students With Highest Score");
        System.out.println("--------------------------------");
        for (Integer finLocation : location) {
            listOfStudents.get(finLocation).displayInfo();
        }
        System.out.println("--------------------------------");
    }
    //Same concept as minScore() but takes the lowest letterGrade instead.
    public void minLetter() {
        int i = 0, n = listOfStudents.size();
        String[] scores = new String[n];
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getLetterGrade();
        }
        Arrays.sort(scores);
        String minLetter = scores[scores.length - 1];
        System.out.println("================================");
        System.out.printf("| Lowest Letter Grade: %-2s\n", minLetter);
        int j = 0;
        ArrayList<Integer> location = new ArrayList<Integer>();
        for (Student s : listOfStudents) {
            if(s.getGrade().getLetterGrade().equals(minLetter)) {
                location.add(j);
            }
            j++;
        }
        System.out.println("--------------------------------");
        System.out.println("| Students With Lowest Letter");
        System.out.println("--------------------------------");
        for (Integer finLocation: location) {
            listOfStudents.get(finLocation).displayInfoLetter();
        }
        System.out.println("--------------------------------");
    }
    //Same concept as maxScore() but takes the highest letterGrade instead.
    public void maxLetter() {
        int i = 0, n = listOfStudents.size();
        String[] scores = new String[n];
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getLetterGrade();
        }
        Arrays.sort(scores);
        String maxLetter = scores[0];
        System.out.println("================================");
        System.out.printf("| Highest Letter Grade: %-2s\n", maxLetter);
        int j = 0;
        ArrayList<Integer> location = new ArrayList<Integer>();
        for (Student s : listOfStudents) {
            if(s.getGrade().getLetterGrade().equals(maxLetter)) {
                location.add(j);
            }
            j++;
        }
        System.out.println("--------------------------------");
        System.out.println("| Students With Highest Letter");
        System.out.println("--------------------------------");
        for (Integer finLocation: location) {
            listOfStudents.get(finLocation).displayInfoLetter();
        }
        System.out.println("--------------------------------");
    }
    //For this method I take in an input (int) which is the PID and use an enhanced for loop to search through the
    //ArrayList and at the sametime using the int variable location to keep track of the position of the PID if its found.
    public void viewLetter(int PID) {
        boolean pidFound = false;
        int location = 0;
        while(!pidFound) {
            for (Student s : listOfStudents) {
                if (s.getPid() == PID) {
                    listOfStudents.get(location).displayInfoLetter();
                    return;
                }
                location++;
            }
            System.out.println("| PID Not Found - Please Try Again");
            return;
        }
     }
    //Exact same concept as the method above but displays the students name using printf.
    public void viewName(int PID) {
        boolean pidFound = false;
        int location = 0;
        while(!pidFound) {
            for (Student s : listOfStudents) {
                if (s.getPid() == PID) {
                    System.out.printf("| Student: %-1s %-10s\n", listOfStudents.get(location).getFirstName(), listOfStudents.get(location).getLastName());
                    return;
                }
                location++;
            }
            System.out.println("PID Not Found - Please Try Again");
            return;
        }
    }
    //For this concept it's the same principle in finding the corresponding PID but in addition if its found then the
    //setGrade setter is called and when call the constructor as well to change the student score.
    public void changeLetter(int PID, int score) {
        boolean pidFound = false;
        int location = 0;
        while(!pidFound) {
            for (Student s : listOfStudents) {
                if (s.getPid() == PID) {
                    s.setGrade(new Grade(score));
                    System.out.println("Student Grade Changed:");
                    s.displayInfo();
                    return;
                }
                location++;
            }
            System.out.println("PID Not Found - Please Try Again");
            return;
        }
    }
    //We take a double variable sum and using the enhanced for loop, we add up all the scores.
    //Then we return a double of the sum / size of the ArrayList listOfStudents.
    public double calculateAvg() {
        double sum = 0;
        for (Student s : listOfStudents) {
            sum += s.getGrade().getScore();
        }
        return sum / listOfStudents.size();
    }
    //We take an array and store all the students scores within it. Once the for loop populates the int[] array with
    //the scores we then do n (size of lisftOfStudents ArrayList) and mod it by two to see if its even or odd.
    //If odd we do (scores[n / 2] + scores[n / 2 - 1]) / 2.0f).
    public float calculateMedian() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }
        Arrays.sort(scores);
        if ((n % 2) == 0) {
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        } else {
            return scores[n / 2];
        }
    }
        //Used in tabLetter and tabScore to print out every students info using printf
        public void printAllStudents(int choice) {
            if (choice == 0) {
                System.out.println("================================================");
                System.out.println("| First Name: |  LastName:  |   PID:  | Score: |");
                System.out.println("|-----------------------------------------------");
                for (Student s : listOfStudents) {
                    System.out.printf("| %-12s %-13s %-10d\t%-8d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
                }
            } else {
                System.out.println("=============================================");
                System.out.println("| First Name: | LastName: |  PID: | Letter: |");
                System.out.println("|--------------------------------------------");
                for (Student s : listOfStudents) {
                    System.out.printf("| %-12s %-13s %-10d\t%-2s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
                }
            }
            System.out.println("|--------------------------------------------");
        }
        //Same principle as calculate median scores but with letters.
        public String calculateMedianLetter() {
            int i = 0, n = listOfStudents.size();
            int[] scores = new int[n];
            for (Student s : listOfStudents) {
                scores[i++] = s.getGrade().getScore();
            }
            Arrays.sort(scores);
            if ((n % 2) == 0) {
                return letterVerify(((scores[n / 2] + scores[n / 2 - 1]) / 2.0f), 0);
            } else {
                return letterVerify(scores[n / 2], 0);
            }
        }
        //Used to return a string but converting a float and or double into a letter grade.
        public String letterVerify(float score, double score1) {
            String findLetter;

            if (score != 0) {
                if (score >= 90) {
                    findLetter = "A";
                } else if (score >= 85) {
                    findLetter = "A-";
                } else if (score >= 80) {
                    findLetter = "B+";
                } else if (score >= 75) {
                    findLetter = "B";
                } else if (score >= 70) {
                    findLetter = "B-";
                } else if (score >= 65) {
                    findLetter = "C+";
                } else if (score >= 60) {
                    findLetter = "C";
                } else if (score >= 50) {
                    findLetter = "D";
                } else {
                    findLetter = "F";
                }
            }else {
                if (score1 >= 90) {
                    findLetter = "A";
                } else if (score1 >= 85) {
                    findLetter = "A-";
                } else if (score1 >= 80) {
                    findLetter = "B+";
                } else if (score1 >= 75) {
                    findLetter = "B";
                } else if (score1 >= 70) {
                    findLetter = "B-";
                } else if (score1 >= 65) {
                    findLetter = "C+";
                } else if (score1 >= 60) {
                    findLetter = "C";
                } else if (score1 >= 50) {
                    findLetter = "D";
                } else {
                    findLetter = "F";
                }
            }
            return findLetter;
    }
        //Calculates average letter grade by using the double sum and an enhanced for loop to add up all the scores to the
        //it. Then we call the method letterVerify and receive the letterGrade equivalent of the score.
        public String calculateAvgLetter() {
            double sum = 0;
            for (Student s : listOfStudents) {
                sum += s.getGrade().getScore();
            }
            return letterVerify(0, (sum / listOfStudents.size()));
        }
    }
