package library_management.Obj;

public class Book {

    private int book_id;
    private String title;
    private String author;
    private String isbn;
    private int published_year;
    private boolean is_available;

    // Default constructor
    public Book() {}

    // Constructor with parameter
    public Book(int book_id, String title, String author, String isbn, int published_year, boolean is_available) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.published_year = published_year;
        this.is_available = is_available;
    }

    // Override of toString to display the information of the books.
    @Override
    public String toString() {
        return title + " - " + author;
    }

    public boolean isEmpty() {
        return (this.book_id == 0) && (this.title == null || this.title.isEmpty()) && (this.author == null || this.author.isEmpty());
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return book_id;
    }

    /**
     * @param book_id the id to set
     */
    public void setId(int book_id) {
        this.book_id = book_id;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return String return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return int return the published_year
     */
    public int getPublished_year() {
        return published_year;
    }

    /**
     * @param published_year the published_year to set
     */
    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }

    /**
     * @return boolean return the is_available
     */
    public boolean isIs_available() {
        return is_available;
    }

    /**
     * @param is_available the is_available to set
     */
    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

}