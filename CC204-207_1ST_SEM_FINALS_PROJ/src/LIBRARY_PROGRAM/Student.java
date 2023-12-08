package LIBRARY_PROGRAM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student extends User {
    private String username;
    protected String password;
    private String firstName;
    private String lastName;
    private String studentNo;
    private FileWriter fileWriter;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public void createUser() throws IOException {
        // File checkFile = new File("studentAccounts.txt");

        // if (!checkFile.isFile()) {
        // checkFile = new File("studentAccounts.txt");
        // BufferedWriter writer = new BufferedWriter(new
        // FileWriter("studentAccounts.txt", true));
        // writer.write("StudentNo./Username/Password/FirstName/LastName");
        // writer.close();
        // }

        BufferedWriter writer = new BufferedWriter(new FileWriter("studentAccounts.txt", true));
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Student No.: ");
        studentNo = scan.nextLine();
        System.out.print("Enter Username: ");
        username = scan.nextLine();
        System.out.print("Enter Password: ");
        password = scan.nextLine();
        System.out.print("Enter First Name: ");
        firstName = scan.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = scan.nextLine();

        writer.write("\n" + studentNo + "/" + username + "/" + password + "/" + firstName + "/" + lastName);
        writer.close();
    }

    @Override
    public void logIn() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("studentAccounts.txt"));
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String enterUsername = input.nextLine();
        System.out.print("Enter Password: ");
        String enterPassword = input.nextLine();

        String line;
        while ((line = reader.readLine()) != null) {
            Scanner scan = new Scanner(line);
            scan.useDelimiter("/");

            while (scan.hasNext()) {
                studentNo = scan.next();
                username = scan.next();
                password = scan.next();
                firstName = scan.next();
                lastName = scan.next();

                // System.out.println("Student No: " + studentNo);
                // System.out.println("Username: " + username);
                // System.out.println("Password: " + password);
                // System.out.println("First Name: " + firstName);
                // System.out.println("Last Name: " + lastName);

                if (enterUsername.equals(username) && enterPassword.equals(password)) {
                    System.out.println("Logged in succesfully");
                }
            }
        }
        System.out.println("End code");
    }
}
