import java.util.List;

public abstract class DatasetReader {
    protected List<Book> books;  // protected --> so child classes can directly populate it
    
    public abstract List<Book> readData(String sourcePath);
    
    // Common getter for loaded books
    public List<Book> getBooks() {
        return books;
    }
}
