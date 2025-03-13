import java.util.ArrayList;
import java.util.List;

// Book class (independent entity)
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Book: " + title + " by " + author);
    }
}

// Library class (aggregates Book objects)
class Library {
    private String name;
    private List<Book> books; // Aggregation: Library has a list of Books

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display library details
    public void displayLibrary() {
        System.out.println("\nLibrary: " + name);
        System.out.println("Books in this library:");
        for (Book book : books) {
            book.displayBook();
        }
    }
}

// Main class to demonstrate aggregation
public class LibraryAndBooks {
    public static void main(String[] args) {
        // Creating independent Book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        // Creating Library objects
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        // Adding books to different libraries
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2); // Book can be in multiple libraries
        library2.addBook(book3);

        // Displaying libraries and their books
        library1.displayLibrary();
        library2.displayLibrary();

//        Library: City Library
//        Books in this library:
//        Book: The Great Gatsby by F. Scott Fitzgerald
//        Book: To Kill a Mockingbird by Harper Lee
//
//        Library: University Library
//        Books in this library:
//        Book: To Kill a Mockingbird by Harper Lee
//        Book: 1984 by George Orwell
    }
}

