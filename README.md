# Book-Interface

- This project is an **LLD (Low Level Design) assignment** that demonstrates object-oriented design and implementation of a simple book database system. 

- The application reads book data from a CSV file and provides multiple operations through an interactive command-line menu.

---

### File Structure

```bash
book-interface/
│
├── bestsellers with categories.csv        # Dataset file
│
├── Book.java                              # Model class with validation and printDetails
│
├── DatasetReader.java                     # Abstract reader class
│
├── CSVReader.java                         # Concrete reader for CSV files
│
├── BookService.java                       # Service layer with business logic
│
└── Driver.java                            # Entry point (interactive CLI)
```

---

## How to Run the Program

1. Ensure you have **Java 17+** installed.  
2. Place the dataset file `bestsellers with categories.csv` in the same directory as the `.java` files.  
3. Compile all Java files:
   ```bash
   javac *.java
   ```
4. Run the program:
    ```
    java Driver
    ```

---

## Tasks Supported

```bash
==== Book-Interface Menu ====
1. Total number of books by an author
2. All authors in the dataset
3. Names of all the books by an author
4. Classify with a user rating
5. Price of all the books by an author
6. Exit
Enter your choice: 
```