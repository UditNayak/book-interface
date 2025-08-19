import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader extends DatasetReader {

    @Override
    public List<Book> readData(String sourcePath) {
        books = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(sourcePath))) {
            boolean firstLine = true;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Skip header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                String[] values = line.split(",");

                if (values.length < 7) {
                    System.err.println("Skipping malformed row: " + line);
                    continue;
                }

                try {
                    String title = values[0].trim();
                    String author = values[1].trim();
                    double userRating = Double.parseDouble(values[2].trim());
                    int reviews = Integer.parseInt(values[3].trim());
                    int price = Integer.parseInt(values[4].trim());
                    int year = Integer.parseInt(values[5].trim());
                    String genre = values[6].trim();

                    Book book = new Book(title, author, userRating, reviews, price, year, genre);
                    books.add(book);

                } catch (Exception e) {
                    System.err.println("Skipping bad row: " + line);
                    System.err.println("Error: " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + sourcePath);
        }

        return books;
    }
}