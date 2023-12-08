package LIBRARY_PROGRAM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Librarian extends User {
    private String firstName;
    private String lastName;
    private String librarianID;
    private String username;
    private String password;
    private LinkedList<String> books = new LinkedList<String>();
    Main main = new Main();

    // public Librarian(String firstName, String lastName, String librarianID) {
    // this.firstName = firstName;
    // this.lastName = lastName;
    // this.librarianID = librarianID;
    // }

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

    public String getLibrarianID() {
        return librarianID;
    }

    public void setLibrarianID(String librarianID) {
        this.librarianID = librarianID;
    }

    public void addBook() throws IOException {
        // File checkFile = new File("bookList.txt");

        // if (!checkFile.isFile()) {
        // checkFile = new File("bookList.txt");
        // BufferedWriter writer = new BufferedWriter(new
        // FileWriter("librarianAccounts.txt", true));
        // writer.write("BookID/BookTitle/Password/FirstName/LastName");
        // writer.close();
        // }

        BufferedWriter writer = new BufferedWriter(new FileWriter("bookList.txt", true));
        Scanner scan = new Scanner(System.in);

        System.out.print("Book ID: ");
        String bookID = scan.nextLine();
        System.out.print("Book title: ");
        String bookTitle = scan.nextLine();
        System.out.print("Book Category: ");
        String bookCategory = scan.nextLine();
        System.out.print("Book author: ");
        String bookAuthor = scan.nextLine();
        Book book = new Book(bookID, bookTitle, bookCategory, bookAuthor);

        writer.write("\n" + bookID + "/" + bookTitle + "/" + bookCategory + "/"
                + bookAuthor);
        writer.close();
    }

    // public void displayBook() {
    // int count = 1;
    // for (Book e : books) {
    // System.out.println(count + ". " + e.getBookAuthor());
    // count++;
    // }
    // }

    @Override
    public void createUser() throws IOException {
        // File checkFile = new File("librarianAccounts.txt");

        // if (!checkFile.isFile()) {
        // checkFile = new File("librarianAccounts.txt");
        // BufferedWriter writer = new BufferedWriter(new
        // FileWriter("librarianAccounts.txt", true));
        // writer.write("LibrarianID./Username/Password/FirstName/LastName");
        // writer.close();
        // }

        BufferedWriter writer = new BufferedWriter(new FileWriter("librarianAccounts.txt", true));
        Scanner scan = new Scanner(System.in);

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        librarianID = ("LIB" + timeStamp);

        System.out.print("Enter Username: ");
        username = scan.nextLine();
        System.out.print("Enter Password: ");
        password = scan.nextLine();
        System.out.print("Enter First Name: ");
        firstName = scan.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = scan.nextLine();

        System.out.println("Created Succesfully!");
        System.out.println("Your Librarian ID is: " + librarianID);

        writer.write("\n" + librarianID + "/" + username + "/" + password + "/" + firstName + "/" + lastName);
        writer.close();
    }

    @Override
    public void logIn() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("librarianAccounts.txt"));
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
                librarianID = scan.next();
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
                    reader.close();
                }
            }
        }
        System.out.println("End code");
    }

    public void showBooks() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("bookList.txt",
                true));
        BufferedReader reader = new BufferedReader(new FileReader("bookList.txt"));

        String e;
        int liCount = 0;
        while ((e = reader.readLine()) != null) {
            liCount++;
        }
        reader.close();

        String[][] data = new String[liCount][4];

        reader = new BufferedReader(new FileReader("bookList.txt"));
        int lineCount = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            Scanner scan = new Scanner(line);
            scan.useDelimiter("/");

            while (scan.hasNext()) {
                String bookID = scan.next();
                String bookTitle = scan.next();
                String bookCategory = scan.next();
                String bookAuthor = scan.next();

                data[lineCount][0] = bookID;
                data[lineCount][1] = bookTitle;
                data[lineCount][2] = bookCategory;
                data[lineCount][3] = bookAuthor;
            }
            lineCount++;
        }
        JFrame f;
        JTable j;
        f = new JFrame();
        f.setTitle("Book List");
        String[] columnNames = { "ID", "TITLE", "CATEGORY", "AUTHOR" };
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(500, 200);
        f.setVisible(true);
        writer.close();
        reader.close();
    }

    public void manageBooks() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("bookList.txt"));
        LineNumberReader lineNum = new LineNumberReader(new FileReader("bookList.txt"));
        Scanner input = new Scanner(System.in);
        int linenum = 0;
        String e;
        System.out.println("Enter Book ID to edit: ");
        String bkID = input.nextLine();

        while ((e = reader.readLine()) != null && (e = lineNum.readLine()) != null) {
            books.add(e);

            Scanner scan = new Scanner(e);
            scan.useDelimiter("/");

            while (scan.hasNext()) {
                String bookID = scan.next();
                String bookTitle = scan.next();
                String bookCategory = scan.next();
                String bookAuthor = scan.next();

                if (bkID.equals(bookID)) {
                    linenum = lineNum.getLineNumber() - 1;
                    String ch = "";
                    boolean checkCh = false;

                    do {
                        switch (ch) {
                            case "1": {

                                checkCh = true;
                                break;
                            }

                            case "2": {

                                checkCh = true;
                                break;
                            }

                            default:
                                break;
                        }
                    } while (checkCh == false);
                    main.showMenu();
                }
            }
        }
        System.out.println("Book ID does not exist.");
        System.out.println(books.size());
        System.out.println(linenum);
        System.out.println(books.get(linenum));
        books.remove(linenum);
        books.add(linenum, "aosdkoask");
        System.out.println(books);

        // for (int i = 0; i < fileContent.size(); i++) {
        // if (fileContent.get(i).equals("old line")) {
        // fileContent.set(i, "new line");
        // break;
        // }
        // }

        // Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
    }

    public void deleteBook() throws IOException {

    }
}
