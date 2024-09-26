package library.view;

import library.entities.TicketBook;
import library.service.BookService;
import library.service.ReaderService;
import library.service.TicketBookService;

import java.util.Scanner;

public class Menu {
    BookService bookService = new BookService();
    ReaderService readerService = new ReaderService();
    TicketBookService ticketBookService = new TicketBookService();
    public void mainMenu(Scanner scanner){
        System.out.println("1. Quản lí sách");
        System.out.println("2. QUản lí người đọc");
        System.out.println("3. Quản lí mượn/trả sách");
        System.out.println("Mời lụa chọn");
        selectMainMenu(scanner);
    }
    private void selectMainMenu(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                bookMenu(scanner);
                break;
            case 2:
                readerMenu(scanner);
                break;
            case 3:
                ticketBookMenu(scanner);
        }
    }

    private void bookMenu(Scanner scanner){
        while (true){
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xóa");
            System.out.println("4. Quay lại");
            System.out.println("Mời lụa chọn");
            selectBookMenu(scanner);
        }
    }
    private void selectBookMenu(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                bookService.addBook(scanner);
                break;
            case 2:
                bookService.editBook(scanner, true);
                break;
            case 3:
                bookService.editBook(scanner, false);
                break;
            case 4:
                mainMenu(scanner);
        }
    }
    private void readerMenu(Scanner scanner){
        while (true){
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xóa");
            System.out.println("4. Tìm kiếm người đọc");
            System.out.println("5. Quay lại");
            System.out.println("Mời lụa chọn");
            selectReaderMenu(scanner);
        }
    }
    private void selectReaderMenu(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                readerService.addReader(scanner);
                break;
            case 2:
                readerService.editReader(scanner, true);
                break;
            case 3:
                readerService.editReader(scanner, false);
                break;
            case 4:
                findReader(scanner);
                break;
            case 5:
                mainMenu(scanner);
        }
    }
    private void findReader(Scanner scanner){
        System.out.println("1. Tìm kiếm theo id");
        System.out.println("2. Tìm kiếm theo tên");
        System.out.println("3. Quay lại");
        System.out.println("Mời lụa chọn");
        selectFindReader(scanner);
    }
    private void selectFindReader(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                readerService.findReader(scanner, true);
                break;
            case 2:
                readerService.findReader(scanner, false);
                break;
            case 3:
                readerMenu(scanner);
        }
    }
    private void ticketBookMenu(Scanner scanner){
        System.out.println("1. Tạo phiếu mượn sách");
        System.out.println("2. Trả sách");
        System.out.println("3. Quay lại");
        System.out.println("Mời lụa chọn");
        selectTicketBookMenu(scanner);
    }
    private void selectTicketBookMenu(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                ticketBookService.createTicketBook(scanner);
                break;
            case 2:
                ticketBookService.returnBook(scanner);
                break;
            case 3:
                mainMenu(scanner);
        }
    }
}
