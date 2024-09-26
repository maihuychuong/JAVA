package library.service;

import library.data.Database;
import library.entities.Book;

import java.util.Scanner;

public class BookService {
    public void addBook(Scanner scanner){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập chủ đề: ");
        String theme = scanner.nextLine();
        System.out.println("Nhập tác giả: ");
        String author = scanner.nextLine();
        System.out.println("Nhập số lượng còn lại: ");
        int numberLeft = Integer.parseInt(scanner.nextLine());
        Book book = new Book(name, theme, author, numberLeft);
        Database.books.add(book);
    }
    private Book findBookById(int id){
        for (Book book: Database.books){
            if (id == book.getId()){
                return book;
            }
        }
        return null;
    }
    public void editBook(Scanner scanner, boolean update){
        System.out.println("Nhập id sách cần tìm: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = findBookById(id);
        while (book == null) {
            System.out.println("Sách đã nhập không tồn tại");
        }
        if (update){
            System.out.println("Nhâp thông tin mới của sách:");
            System.out.println("Nhập chủ đề: ");
            String theme = scanner.nextLine();
            System.out.println("Nhập tác giả: ");
            String author = scanner.nextLine();
            System.out.println("Nhập số lượng còn lại: ");
            int numberLeft = Integer.parseInt(scanner.nextLine());
            book.setTheme(theme);
            book.setAuthor(author);
            book.setNumberLeft(numberLeft);
        } else {
            Database.books.remove(book);
        }
    }
}