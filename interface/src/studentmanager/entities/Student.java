package studentmanager.entities;

public class Student {
    private String name;
    private int age;
    private double marks;
    private String classification;

    public Student(String name, int age, double marks, String classification) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                ", classification='" + classification + '\'' +
                '}';
    }
}
