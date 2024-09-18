package news;

import news.entities.News;
import news.service.NewsService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewsService newsService = new NewsService();
        News news = newsService.inputNews(scanner);
        newsService.display(news);
    }

}