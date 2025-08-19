import java.util.*;

public class BookService {
    private List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    // 1. Total number of books by an author
    public int getTotalBooksByAuthor(String author) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }

    // 2. Get all authors (unique + sorted)
    public Set<String> getAllAuthors() {
        Set<String> authors = new TreeSet<>(); // TreeSet keeps them sorted
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    // 3. Get all books by an author
    public List<String> getBooksByAuthor(String author) {
        List<String> titles = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                titles.add(book.getTitle());
            }
        }
        return titles;
    }

    // 4. Get books by rating
    public List<Book> getBooksByRating(double rating) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getUserRating() == rating) {
                result.add(book);
            }
        }
        return result;
    }

    // 5. Get price of all books by an author
    public Map<String, Integer> getBookPricesByAuthor(String author) {
        Map<String, Integer> bookPrices = new HashMap<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                bookPrices.put(book.getTitle(), book.getPrice());
            }
        }
        return bookPrices;
    }
}
