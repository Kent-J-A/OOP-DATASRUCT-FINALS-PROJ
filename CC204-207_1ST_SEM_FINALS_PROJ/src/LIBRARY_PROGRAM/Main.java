package LIBRARY_PROGRAM;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Librarian librarian = new Librarian();
        Student student = new Student();
        Teacher teacher = new Teacher();

        // showMenu();
        librarian.manageBooks();
    }

    public void showMenu() throws IOException {
        Scanner input = new Scanner(System.in);
        Librarian librarian = new Librarian();
        Student student = new Student();
        Teacher teacher = new Teacher();

        String ch;
        boolean checkCh;
        String choice = "";

        System.out.println("1. Log in");
        System.out.println("2. Create Account");
        do {
            System.out.print("Enter Choice: ");
            choice = input.nextLine();
            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Choose a valid option");
            }
        } while (!choice.equals("1") && !choice.equals("2"));

        if (choice.equals("1")) {
            System.out.println("\n1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Librarian");
            System.out.print("Enter choice: ");
            ch = input.nextLine();
            checkCh = false;

            do {
                switch (ch) {
                    case "1": {
                        student.logIn();
                        checkCh = true;
                        break;
                    }

                    case "2": {
                        teacher.logIn();
                        checkCh = true;
                        break;
                    }

                    case "3": {
                        librarian.logIn();
                        checkCh = true;
                        break;
                    }

                    default: {
                        System.out.println("Please choose a valid option");
                    }
                }
            } while (checkCh == false);
        }

        if (choice.equals("2")) {
            System.out.println("\n1. Student");
            System.out.println("2. Teacher");
            System.out.print("Enter choice: ");
            ch = input.nextLine();
            checkCh = false;

            do {
                switch (ch) {
                    case "1": {
                        student.createUser();
                        checkCh = true;
                        break;
                    }

                    case "2": {
                        teacher.createUser();
                        checkCh = true;
                        break;
                    }

                    default: {
                        System.out.println("Please choose a valid option");
                    }
                }
            } while (checkCh == false);
        }
    }
}
