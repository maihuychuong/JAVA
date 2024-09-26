package library.entities;

import java.time.LocalDateTime;

public class TicketBook {
    private static int autoId;
    private int id;
    private int bookId;
    private int readerId;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public TicketBook(int bookId, int readerId, LocalDateTime borrowDate, LocalDateTime returnDate) {
        this.id = ++autoId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        TicketBook.autoId = autoId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "TicketBook{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
