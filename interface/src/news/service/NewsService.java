package news.service;

import news.entities.News;

import java.util.Scanner;

public class NewsService implements INews{
    public News inputNews(Scanner scanner){
        System.out.println("Nhập tiêu đề: ");
        String title = scanner.nextLine();
        System.out.println("Nhập tác giả: ");
        String author = scanner.nextLine();
        System.out.println("Nhập ngày xuất bản: ");
        String publicDate = scanner.nextLine();
        System.out.println("Nhập đánh giá: ");
        Double rate = Double.parseDouble(scanner.nextLine());
        return new News(title, author, publicDate, rate);
    }
    @Override
    public void display(News news) {
        System.out.println(news);
    }
}
