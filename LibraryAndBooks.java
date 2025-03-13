import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void displayBook() {
        System.out.println("Book: " + title + " by " + author);
    }
}


class Library {
    private String name;
    private List<Book> books;


    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }


    public void addBook(Book book) {
        books.add(book);
    }


    public void displayLibrary() {
        System.out.println("\nLibrary: " + name);
        System.out.println("Books in this library:");
        for (Book book : books) {
            book.displayBook();
        }
    }
}


public class LibraryAndBooks {
    public static void main(String[] args) {

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        // Creating Library objects
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");


        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2);
        library2.addBook(book3);

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

