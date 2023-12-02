package LIBRARY_PROGRAM;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class Librarian {
    private String firstName;
    private String lastName;
    private String librarianID;

    private LinkedList<Book> books = new LinkedList<Book>();

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
        BufferedWriter writer = new BufferedWriter(new FileWriter("bookList.txt", true));
        Scanner scan = new Scanner(System.in);

        System.out.println("Book ID: ");
        String bookID = scan.nextLine();
        System.out.println("Book title: ");
        String bookTitle = scan.nextLine();
        System.out.println("Book Category: ");
        String bookCategory = scan.nextLine();
        System.out.println("Book author: ");
        String bookAuthor = scan.nextLine();
        Book book = new Book(bookID, bookTitle, bookCategory, bookAuthor);
        books.add(book);

        for (int i = 0; i < books.size(); i++) {
            writer.write(book.getBookAuthor() + "/" + book.getBookCategory() + "/" + book.getBookID() + "/"
                    + book.getBookTitle() + "\n");
        }
        writer.close();
    }

    public void displayBook() {
        int count = 1;
        for (Book e : books) {
            System.out.println(count + ". " + e.getBookAuthor());
            count++;
        }
    }
}
