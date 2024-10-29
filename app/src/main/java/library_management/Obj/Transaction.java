package library_management.Obj;

import java.util.Date;
import java.util.Calendar;

public class Transaction {
    private int transaction_id = 0;
    private User user;
    private Book book;
    private Date borrow_date;
    private Date return_date;
    private Date actual_return_date;

    public Transaction() {}

    // Fetch transaction
    public Transaction(int transaction_id, User user, Book book, Date borrow_date, Date return_date, Date actual_return_date) {
        this.transaction_id = transaction_id;
        this.user = user;
        this.book = book;
        this.return_date = return_date;
        this.actual_return_date = actual_return_date;
    }

    // Create transaction
    public Transaction(User user, Book book) {
        this.transaction_id = transaction_id++;
        this.user = user;
        this.book = book;
        this.borrow_date = new Date(System.currentTimeMillis());
        this.return_date = returnDate(this.borrow_date);
        this.actual_return_date = null;
    }

    private Date returnDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return new Date(calendar.getTimeInMillis());
    }

    @Override
    public String toString() {
        return book.getTitle() + " - Due date : " + return_date;
    }

    public boolean isEmpty() {
        return (this.transaction_id == 0) && (this.user.isEmpty()) && (this.book.isEmpty()) && 
               (this.borrow_date == null) && (this.return_date == null) && (this.actual_return_date == null);
    }

    /**
     * @return int return the transaction_id
     */
    public int getTransaction_id() {
        return transaction_id;
    }

    /**
     * @param transaction_id the transaction_id to set
     */
    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    /**
     * @return int return the user_id
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user_id to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return int return the book_id
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book the book_id to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return LocalDate return the borrow_date
     */
    public Date getBorrow_date() {
        return borrow_date;
    }

    /**
     * @param borrow_date the borrow_date to set
     */
    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    /**
     * @return LocalDate return the return_date
     */
    public Date getReturn_date() {
        return return_date;
    }

    /**
     * @param return_date the return_date to set
     */
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    /**
     * @return LocalDate return the actual_return_date
     */
    public Date getActual_return_date() {
        return actual_return_date;
    }

    /**
     * @param actual_return_date the actual_return_date to set
     */
    public void setActual_return_date(Date actual_return_date) {
        this.actual_return_date = actual_return_date;
    }

}
