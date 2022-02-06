/*
Programming II Assignment 1
By: Erick Rivera
Due Date: Feb 3, 2022
PID: 6311416
 */
package main;
import util.Student;
import util.Grade;
import util.Gradebook;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Using userInput, we will capture the users first request when the program is first loaded.
        String userInput;
        Scanner scnr = new Scanner(System.in);
        Gradebook newGradebook = new Gradebook();
        System.out.println();
        System.out.println("Welcome to my Grade Book!");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("| Please enter the information of the first student using the following format: |");
        System.out.println("| FirstName LastName PID Grade                                                  |");
        System.out.println("| EX: Jon Smith 9999999 98                                                      |");
        System.out.println("| Press Enter when you are done                                                 |");
        System.out.println("---------------------------------------------------------------------------------");
        //Calls do while loop to keep allowing for user input.
        do {
            //Read user input
            userInput = scnr.nextLine();
            System.out.println();
            //Validate if chosen user input is "done".
            if (userInput.equalsIgnoreCase("done")) {
                break;
            } else {
                //String below will break the userInput into a String Array using .split() method.
                String[] inputValidator = userInput.split(" ");
                //Validate if userInput satisfies the four items of info needed to save Student
                if (inputValidator.length == 4) {
                    /*
                    The following chunk of if, else if, and else statements will call the appropriate method needed to
                    validate that every information satisfies the strict record keeping policy.
                    EX: isFirstValid(inputValidator[0].toLowerCase() calls on the method isFirstValid with the first
                    value in array inputValidator while calling on the.toLowerCase() method to provide uniform capitalization
                    throughout the Grade Book. Once the method isFirstValid is called it will check and return a boolean based
                    on the information provided and if true, it will proceed to the following if statement and if its false
                    it will proceed to the coordinating else statement and printing out the respective error followed by
                    a request for a new Student input.
                     */
                    if(isFirstValid(inputValidator[0].toLowerCase())) {
                        if(isSecondValid(inputValidator[1].toLowerCase())) {
                            if(isPIDValid(inputValidator[2])) {
                                if(isGradeValid(inputValidator[3])) {
                                    inputValidator[0] = inputValidator[0].toLowerCase();
                                    inputValidator[1] = inputValidator[1].toLowerCase();
                                    /*
                                    To provide uniform capitalization across all first and last names, we call
                                    the substring method and toUpperCase method to capitalize only the first letter of
                                    each student first and last name.
                                    */
                                    inputValidator[0] = inputValidator[0].substring(0,1).toUpperCase() + inputValidator[0].substring(1);
                                    inputValidator[1] = inputValidator[1].substring(0,1).toUpperCase() + inputValidator[1].substring(1);
                                    //Calls the Student Constructor to create a new Student and proceeds to store it in
                                    //the arraylist ListOfStudents
                                    Student s = new Student(inputValidator[0], inputValidator[1], Integer.parseInt(inputValidator[2]), new Grade(Integer.parseInt(inputValidator[3])));
                                    newGradebook.addElement(s);
                                    System.out.println("---------------------------------------------------------------------------");
                                    System.out.println("| Success!!!                                                              |");
                                    System.out.println("| Please enter the information of the next student using the same format. |");
                                    System.out.println("| If there is no more students, please enter the keyword \"DONE\"         |");
                                    System.out.println("---------------------------------------------------------------------------");
                                    System.out.println();
                                } else if(!isFirstValid(inputValidator[3])) {
                                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                                    System.out.println("| Please try again - Grade can ONLY contain 2 non-negative numerical characters, CAN'T be GREATER than 100. |");
                                    System.out.println("| Remember the Format is:                                                                                   |");
                                    System.out.println("| FirstName LastName PID Grade                                                                              |");
                                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                                    System.out.println();
                                }
                            } else if(!isFirstValid(inputValidator[2])) {
                                System.out.println("---------------------------------------------------------------------------------------");
                                System.out.println("| Please try again - PID can ONLY contain 7 numerical characters, CAN'T START with 0. |");
                                System.out.println("| Remember the Format is:                                                             |");
                                System.out.println("| FirstName LastName PID Grade                                                        |");
                                System.out.println("---------------------------------------------------------------------------------------");
                                System.out.println();
                            }
                        } else if(!isFirstValid(inputValidator[1])) {
                            System.out.println("------------------------------------------------------------------------------------");
                            System.out.println("| Please try again - LastName can ONLY contain alphabetical characters and one (.) |");
                            System.out.println("| Remember the Format is:                                                          |");
                            System.out.println("| FirstName LastName PID Grade                                                     |");
                            System.out.println("------------------------------------------------------------------------------------");
                            System.out.println();
                        }
                    } else if(!isFirstValid(inputValidator[0])) {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("| Please try again - FirstName can ONLY contain alphabetical characters |");
                        System.out.println("| Remember the Format is:                                               |");
                        System.out.println("| FirstName LastName PID Grade                                          |");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println();
                    }
                } else {
                        System.out.println("---------------------------------");
                        System.out.println("| Please try again              |");
                        System.out.println("| Remember the Format is:       |");
                        System.out.println("| FirstName LastName PID Grade  |");
                        System.out.println("---------------------------------");
                        System.out.println();

                    }
                }
            } while (!"done".equals(userInput));

            System.out.println("GRADE-BOOK MENU");
            System.out.println("""
                --------------------------------------------------------------------------------------------------------------
                | min score  - Calculate & print the minimum score of all students.                                          |
                | min letter - Calculate & print the minimum letter grade of all students.                                   |
                | max score  - Calculate & print the maximum score of all students.                                          |
                | max letter - Calculate & print the maximum letter grade of all students.                                   |
                | letter XXXXXXX - To search and print the letter grade using students PID.                                  |
                | name XXXXXXX   - To search and print the students name using students PID.                                 |
                | change XXXXXXX YY - To update a students grade using students PID.                                         |
                | average score - Calculate & print the average of all test scores.                                          |
                | average letter - Calculate & print the average letter grade of all test scores.                            |
                | median score - Calculate and print the median score of all students.                                       |
                | median letter - Calculate and print the letter-grade of median score of all students.                      |
                | tab scores - Print the list of all students in the form of a tab separated table containing four columns.  |
                | tab letters - Print the list of all students in the form of a tab separated table containing four columns. |
                | quit - End Program                                                                                         |
                --------------------------------------------------------------------------------------------------------------
                """);
        /*
        New infinite loop until quit is requested, this loops primary focus is receiving the user input in a new String
        variable "choice" and matching it using .equalsIgnoreCase() method to its respective if, else if statement. As
        the previous menu, I decided to use multiple methods for easier code modifications, improved readability and
        increased reusability.
         */
        String choice = scnr.nextLine();
        do {
            if (choice.equalsIgnoreCase("min score")) {
                newGradebook.minScore();
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("min letter")) {
                newGradebook.minLetter();
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("max score")) {
                newGradebook.maxScore();
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("max letter")) {
                newGradebook.maxLetter();
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.toLowerCase().startsWith("letter")) {
                String[] pidRetriever = choice.split(" ");
                if(pidRetriever.length == 2) {
                    if (pidRetriever[1].matches("[0-9]+")) {
                        System.out.println("================================");
                        System.out.println("| Requested Letter Grade");
                        System.out.println("--------------------------------");
                        newGradebook.viewLetter(Integer.parseInt(pidRetriever[1]));
                    } else {
                        System.out.println("PID must be a 7 digit number");
                    }
                } else {
                    System.out.println("PID Required");
                }
                System.out.println("--------------------------------");
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.toLowerCase().startsWith("name")) {
                String[] pidRetriever = choice.split(" ");
                if(pidRetriever.length == 2) {
                    if (pidRetriever[1].matches("[0-9]+")) {
                        System.out.println("================================");
                        System.out.println("| Requested Name");
                        System.out.println("--------------------------------");
                        newGradebook.viewName(Integer.parseInt(pidRetriever[1]));
                    } else {
                        System.out.println("PID must be a 7 digit number");
                    }
                } else {
                    System.out.println("PID Required");
                }
                System.out.println("--------------------------------");
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.toLowerCase().startsWith("change")) {
                String[] pidRetriever = choice.split(" ");
                if(pidRetriever.length == 3) {
                    if (pidRetriever[1].matches("[0-9]+") && pidRetriever[2].matches("[0-9]+") && Integer.parseInt(pidRetriever[2]) >= 0 && Integer.parseInt(pidRetriever[2]) <= 100) {
                        System.out.println("================================");
                        System.out.println("Letter Grade Change");
                        System.out.println("--------------------------------");
                        newGradebook.changeLetter(Integer.parseInt(pidRetriever[1]), Integer.parseInt(pidRetriever[2]));
                    } else {
                        System.out.println("Invalid Input");
                    }
                } else {
                    System.out.println("PID Required");
                }
                System.out.println("--------------------------------");
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("average score")) {
                System.out.println("=======================================");
                System.out.printf("| The Average Student Score is %-2.2f\n", newGradebook.calculateAvg());
                System.out.println("---------------------------------------");
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("average letter")) {
                System.out.println("===========================================");
                System.out.printf("The Average Student Letter Grade is %-2s\n", newGradebook.calculateAvgLetter());
                System.out.println("-------------------------------------------");
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("median score")) {
                System.out.println("====================================");
                System.out.printf("The Median Student Score is %-2.2f\n", newGradebook.calculateMedian());
                System.out.println("------------------------------------");
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("median letter")) {
                System.out.println("========================================");
                System.out.printf("The Median Student Letter Grade is %-2s\n", newGradebook.calculateMedianLetter());
                System.out.println("----------------------------------------");
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("tab scores")) {
                newGradebook.printAllStudents(0);
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("tab letters")) {
                newGradebook.printAllStudents(1);
                System.out.println("Enter New Command Below:");
                choice = scnr.nextLine();

            } else if (choice.equalsIgnoreCase("quit")) {
                System.out.print("""
                         GOOD BYE!
                         
                               .__(.)< (MEOW)
                                \\\\___)
                                
                        """);
                System.exit(0);

            } else {
                System.out.println();
                System.out.println("Invalid Choice - Try Again!");
                choice = scnr.nextLine();
            }
        } while (!choice.equals("secret infinite loop"));
    }

    //Boolean return that makes sure first name only contains letters.
    public static boolean isFirstValid(String str) {
        return str.matches("[a-zA-Z]+");
    }
    //Boolean return that makes sure last name only contains letters and one (.).
    public static boolean isSecondValid(String str) {
        boolean check = false;
            if(((str.matches("[a-zA-Z.]+")))) {
                check = true;
                for (int i = 0; i < str.length(); i++) {
                    for (int j = i + 1; j < str.length(); j++) {
                        if (((str.charAt(i) == str.charAt(j)) && (str.charAt(i) == '.'))) {
                            check = false;
                            break;
                        }
                    }
                }
            }
        return check;
    }
    //Boolean return that makes sure PID only contains numbers, 7 digits, and no leading zeros.
    public static boolean isPIDValid (String str){
        return ((str.matches("[0-9]+"))) && ((Float.parseFloat(str) - 999999) > 0) && (str.length() == 7);
    }
    //Boolean return that makes sure grade only contains non-negative numbers with an upper bound of 100.
    public static boolean isGradeValid(String str) {
        return ((str.matches("[0-9]+"))) && (((Integer.parseInt(str)) >= 0) && ((Integer.parseInt(str)) <= 100));
    }
}