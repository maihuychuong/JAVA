package library.service;

import library.data.Database;
import library.entities.Reader;
import library.entities.TicketBook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TicketBookService {
    public void createTicketBook(Scanner scanner) {
        System.out.println("Nhập id sách cho mượn: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập id người mượn: ");
        int readerId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày mượn: ");
        String borrowDate = scanner.nextLine();
        LocalDateTime borrowPattern = LocalDateTime.parse(borrowDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Nhập ngày trả: ");
        String returnDate = scanner.nextLine();
        LocalDateTime returnPattern = LocalDateTime.parse(returnDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        TicketBook ticketBook = new TicketBook(bookId, readerId, borrowPattern, returnPattern);
        Database.ticketBooks.add(ticketBook);
    }
    private TicketBook findTicketBookById(int id){
        for (TicketBook ticketBook: Database.ticketBooks){
            if (id == ticketBook.getId()){
                return ticketBook;
            }
        }
        return null;
    }
    public void returnBook(Scanner scanner){
        System.out.println("Nhập id phiếu cho mượn sách: ");
        int id = Integer.parseInt(scanner.nextLine());
        TicketBook ticketBook = findTicketBookById(id);
        Database.ticketBooks.remove(ticketBook);
    }
}
