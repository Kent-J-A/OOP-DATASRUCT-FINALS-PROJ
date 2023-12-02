package LIBRARY_PROGRAM;

import java.util.Scanner;

public class Book {
    private String bookID;
    private String bookTitle;
    private String bookCategory;
    private String bookAuthor;

    public Book(String bookID, String bookTitle, String bookCategory, String bookAuthor) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.bookAuthor = bookAuthor;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void addBook() {
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
    }

    public void displayBook() {
        int count = 1;
        for (Book e : books) {
            System.out.println(count + ". " + e.getBookAuthor());
            count++;
        }
    }
}
