package LIBRARY_PROGRAM;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Librarian librarian = new Librarian();
        librarian.addBook();
    }
}
