package library.service;

import library.data.Database;
import library.entities.Book;
import library.entities.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderService {
    public void addReader(Scanner scanner){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        Reader reader = new Reader(name, phoneNumber, address);
        Database.readers.add(reader);
    }
    private Reader findReaderById(int id){
        for (Reader reader: Database.readers){
            if (id == reader.getId()){
                return reader;
            }
        }
        return null;
    }
    private Reader findReaderByName(String name){
        for (Reader reader: Database.readers){
            if (name.equalsIgnoreCase(reader.getName())){
                return reader;
            }
        }
        return null;
    }
    public void editReader(Scanner scanner, boolean update){
        System.out.println("Nhập id người đọc cần tìm: ");
        int id = Integer.parseInt(scanner.nextLine());
        Reader reader = findReaderById(id);
        while (reader == null) {
            System.out.println("Người đọc đã nhập không tồn tại");
        }
        if (update){
            System.out.println("Nhâp thông tin mới của người đọc:");
            System.out.println("Nhập tên: ");
            String name = scanner.nextLine();
            System.out.println("Nhập địa chỉ: ");
            String address = scanner.nextLine();
            System.out.println("Nhập số điện thoại: ");
            int phoneNumber = Integer.parseInt(scanner.nextLine());
            reader.setName(name);
            reader.setAdress(address);
            reader.setPhoneNumber(phoneNumber);
        } else {
            Database.readers.remove(reader);
        }
    }
    public void findReader(Scanner scanner, boolean idname){
        if (idname){
            System.out.println("Nhập id người đọc cần tìm: ");
            int id = Integer.parseInt(scanner.nextLine());
            Reader reader = findReaderById(id);
            System.out.println(reader);
        } else {
            List<Reader> readersByName = new ArrayList<>();
            System.out.println("Nhập tên người đọc cần tìm: ");
            String name = scanner.nextLine();
            Reader reader = findReaderByName(name);
            readersByName.add(reader);
            System.out.println(readersByName);
        }
    }
}
