public class Book {
    private String title;
    private String author;
    private double userRating;
    private int reviewCount;
    private int price;
    private int year;
    private String genre;


    public Book(String title, String author, double userRating, int reviewCount, int price, int year, String genre) {
        setTitle(title);
        setAuthor(author);
        setUserRating(userRating);
        setReviewCount(reviewCount);
        setPrice(price);
        setYear(year);
        setGenre(genre);
    }

    // Setters with validation
    public void setTitle(String title){
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Title can't be empty");
        this.title = title.trim();
    }

    public void setAuthor(String author){
        if (author == null || author.trim().isEmpty())
            throw new IllegalArgumentException("Author can't be empty");
        this.author = author.trim();
    }

    public void setUserRating(double userRating){
        if (userRating < 0.0 || userRating > 5.0)
            throw new IllegalArgumentException("User Rating must be between 0.0 and 5.0");
        this.userRating = userRating;
    }

    public void setReviewCount(int reviewCount) {
        if (reviewCount < 0)
            throw new IllegalArgumentException("Review count cannot be negative");
        this.reviewCount = reviewCount;
    }

    public void setPrice(int price) {
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void setYear(int year) {
        if (year < 0)
            throw new IllegalArgumentException("Year cannot be negative");
        this.year = year;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty())
            throw new IllegalArgumentException("Genre can't be empty");
        this.genre = genre.trim();
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getUserRating() { return userRating; }
    public int getReviewCount() { return reviewCount; }
    public int getPrice() { return price; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }

    // Pretty print book details
    public void printDetails() {
        System.out.printf("""
                Title: %s
                Author: %s
                User Rating: %.1f
                Reviews: %,d
                Price: $%,d
                Year: %d
                Genre: %s
                ------------------------
                """, getTitle(), getAuthor(), getUserRating(), getReviewCount(), getPrice(), getYear(), getGenre());
    }
}
