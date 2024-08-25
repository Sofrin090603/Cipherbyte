
package librarycatalogsystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


  

class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author + " (" + year + ")";
    }
}

class LibraryCatalog {
    private final List<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' added to the catalog.");
    }

    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the catalog.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class LibraryCatalogSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        while (true) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. List All Books");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addBook(catalog);
                case "2" -> searchByTitle(catalog);
                case "3" -> searchByAuthor(catalog);
                case "4" -> catalog.listBooks();
                case "5" -> {
                    System.out.println("Exiting the Library Catalog System. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please select an option between 1 and 5.");
            }
        }
    }

    private static void addBook(LibraryCatalog catalog) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = Integer.parseInt(scanner.nextLine());

        Book book = new Book(title, author, year);
        catalog.addBook(book);
    }

    private static void searchByTitle(LibraryCatalog catalog) {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        List<Book> results = catalog.searchByTitle(title);
        if (!results.isEmpty()) {
            for (Book book : results) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found with that title.");
        }
    }

    private static void searchByAuthor(LibraryCatalog catalog) {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();
        List<Book> results = catalog.searchByAuthor(author);
        if (!results.isEmpty()) {
            for (Book book : results) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found by that author.");
        }
    }
}

