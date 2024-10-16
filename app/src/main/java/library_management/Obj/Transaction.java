package library_management.Obj;


import java.sql.Date;
import java.util.Calendar;

public class Transaction {
    private int transaction_id = 0;
    private int user_id;
    private int book_id;
    private Date borrow_date;
    private Date return_date;
    private Date actual_return_date;

    public Transaction() {}

    public Transaction(int user_id, int book_id) {
        this.transaction_id = transaction_id++;
        this.user_id = user_id;
        this.book_id = book_id;
        this.borrow_date = new Date(System.currentTimeMillis());
        this.return_date = returnDate(new Date(System.currentTimeMillis()));
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
        return "transaction_id : " + transaction_id + "\n" +
            "user_id : " + user_id + "\n" +
            "book_id : " + book_id + "\n" + 
            "borrow_date : " + borrow_date + "\n" + 
            "return_date : " + return_date + "\n" + 
            "actual_return_date : " + actual_return_date;
    }

    public boolean isEmpty() {
        return (this.transaction_id == 0) && (this.user_id == 0) && (this.book_id == 0) && 
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
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return int return the book_id
     */
    public int getBook_id() {
        return book_id;
    }

    /**
     * @param book_id the book_id to set
     */
    public void setBook_id(int book_id) {
        this.book_id = book_id;
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
