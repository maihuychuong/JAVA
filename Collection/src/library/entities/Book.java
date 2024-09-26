package library.entities;

public class Book {
    private static int autoId;
    private int id;
    private String name;
    private String theme;
    private String author;
    private int numberLeft;

    public Book(String name, String theme, String author, int numberLeft) {
        this.id = ++autoId;
        this.name = name;
        this.theme = theme;
        this.author = author;
        this.numberLeft = numberLeft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberLeft() {
        return numberLeft;
    }

    public void setNumberLeft(int numberLeft) {
        this.numberLeft = numberLeft;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", author='" + author + '\'' +
                ", numberLeft=" + numberLeft +
                '}';
    }
}
