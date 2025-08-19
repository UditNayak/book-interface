import java.util.*;

public class Driver {
    public static void main(String[] args) {
        String csvPath = "bestsellers with categories.csv";
        DatasetReader reader = new CSVReader();
        List<Book> books = reader.readData(csvPath);

        if (books.isEmpty()) {
            System.out.println("No data loaded. Exiting...");
            return;
        }

        BookService service = new BookService(books);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Book-Interface Menu ====");
            System.out.println("1. Total number of books by an author");
            System.out.println("2. All authors in the dataset");
            System.out.println("3. Names of all the books by an author");
            System.out.println("4. Classify with a user rating");
            System.out.println("5. Price of all the books by an author");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    int count = service.getTotalBooksByAuthor(author);
                    System.out.println(author + " has written " + count + " book(s) in the dataset.");
                }
                case 2 -> {
                    System.out.println("All Authors:");
                    service.getAllAuthors().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    List<String> titles = service.getBooksByAuthor(author);
                    if (titles.isEmpty()) {
                        System.out.println("No books found for " + author);
                    } else {
                        System.out.println("Books by " + author + ":");
                        titles.forEach(System.out::println);
                    }
                }
                case 4 -> {
                    System.out.print("Enter rating: ");
                    double rating = sc.nextDouble();
                    sc.nextLine();
                    List<Book> ratedBooks = service.getBooksByRating(rating);
                    if (ratedBooks.isEmpty()) {
                        System.out.println("No books found with rating " + rating);
                    } else {
                        ratedBooks.forEach(Book::printDetails);
                    }
                }
                case 5 -> {
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    Map<String, Integer> bookPrices = service.getBookPricesByAuthor(author);
                    if (bookPrices.isEmpty()) {
                        System.out.println("No books found for " + author);
                    } else {
                        System.out.println("Books and prices by " + author + ":");
                        bookPrices.forEach((title, price) ->
                                System.out.printf(" - %s : $%d%n", title, price));
                    }
                }
                case 6 -> {
                    System.out.println("Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
