package library.data;

import library.entities.Book;
import library.entities.Reader;
import library.entities.TicketBook;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Book> books = new ArrayList<>();
    public static List<Reader> readers = new ArrayList<>();
    public static List<TicketBook> ticketBooks = new ArrayList<>();
}
