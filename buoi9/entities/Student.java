package extend_lesson.buoi9.entities;

public class Student {
    private static int autoId;
    private int id;
    private String name;
    private String classify;

    public Student(String name, String classify) {
        this.id = ++autoId;
        this.name = name;
        this.classify = classify;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classify='" + classify + '\'' +
                '}';
    }
}
