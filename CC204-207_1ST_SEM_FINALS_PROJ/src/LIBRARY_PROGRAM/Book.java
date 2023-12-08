package LIBRARY_PROGRAM;

import java.util.Scanner;

public class Book {
    public String bookID;
    public String bookTitle;
    public String bookCategory;
    public String bookAuthor;

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
}
